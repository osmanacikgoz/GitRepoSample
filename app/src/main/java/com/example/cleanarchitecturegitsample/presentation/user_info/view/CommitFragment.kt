package com.example.cleanarchitecturegitsample.presentation.user_info.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.cleanarchitecturegitsample.databinding.FragmentCommitsBinding
import com.example.cleanarchitecturegitsample.presentation.base.BaseFragment
import com.example.cleanarchitecturegitsample.presentation.user_info.adapter.commit.CommitItemAdapter
import com.example.cleanarchitecturegitsample.presentation.user_info.adapter.commit.CommitItemCallback
import com.example.cleanarchitecturegitsample.presentation.user_info.viewmodel.commit.CommitState
import com.example.cleanarchitecturegitsample.presentation.user_info.viewmodel.commit.CommitViewModel
import org.koin.android.ext.android.inject

class CommitFragment : BaseFragment() {

    private lateinit var binding: FragmentCommitsBinding

    private val commitsViewModel: CommitViewModel by inject()
    private var commitAdapter: CommitItemAdapter? = null

    companion object {
        const val USER_NAME = "UserName"
        const val REPO_NAME = "RepoName"

        fun newInstance(userName: String, repoName: String) =
            CommitFragment().apply {
                arguments = Bundle().apply {
                    this.putString(USER_NAME, userName)
                    this.putString(REPO_NAME, repoName)
                }
            }

    }

    override fun onStart() {
        super.onStart()
        initViewModel()
    }

    override fun onStop() {
        super.onStop()
        commitsViewModel.onCommitState.removeObservers(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCommitsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        val userName = arguments?.getString(CollaboratorsFragment.USER_NAME) ?: ""
        val repoName = arguments?.getString(CollaboratorsFragment.REPO_NAME) ?: ""

        commitsViewModel.getCommit(userName, repoName)
    }


    private fun initView() {
        commitAdapter = CommitItemAdapter(CommitItemCallback())
        binding.commitList.adapter = commitAdapter
    }


    private fun initViewModel() {
        commitsViewModel.onCommitState.observe(viewLifecycleOwner) { commitState ->
            when (commitState) {
                is CommitState.Success -> {
                    commitAdapter?.submitList(commitState.commits)
                }

                is CommitState.Error -> {
                    val errorMessage = commitState.errorMessage
                    Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
                }

                else -> Unit
            }
        }
    }
}