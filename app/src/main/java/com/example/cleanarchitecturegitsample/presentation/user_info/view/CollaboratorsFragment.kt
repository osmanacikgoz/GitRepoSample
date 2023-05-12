package com.example.cleanarchitecturegitsample.presentation.user_info.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.cleanarchitecturegitsample.databinding.FragmentCollaboratorsBinding
import com.example.cleanarchitecturegitsample.presentation.base.BaseFragment
import com.example.cleanarchitecturegitsample.presentation.user_info.adapter.collaborator.CollaboratorAdapter
import com.example.cleanarchitecturegitsample.presentation.user_info.adapter.collaborator.CollaboratorItemCallback
import com.example.cleanarchitecturegitsample.presentation.user_info.viewmodel.collaborators.CollaboratorsState
import com.example.cleanarchitecturegitsample.presentation.user_info.viewmodel.collaborators.CollaboratorsViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CollaboratorsFragment : BaseFragment() {
    private lateinit var binding: FragmentCollaboratorsBinding
    private val collaboratorsViewModel: CollaboratorsViewModel by inject()
    private var collaboratorAdapter: CollaboratorAdapter? = null

    companion object {

        const val USER_NAME = "UserName"

        const val REPO_NAME = "RepoName"

        fun newInstance(userName: String, repoName: String) =
            CollaboratorsFragment().apply {

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
        collaboratorsViewModel.onCollaboratorsState.removeObservers(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCollaboratorsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()

        val userName = arguments?.getString(USER_NAME) ?: ""
        val repoName = arguments?.getString(REPO_NAME) ?: ""

        collaboratorsViewModel.getCollaborators(userName, repoName)
    }


    private fun initView() {
        collaboratorAdapter = CollaboratorAdapter(CollaboratorItemCallback())
        binding.collaboratorsList.adapter = collaboratorAdapter
    }

    private fun initViewModel(){
        collaboratorsViewModel.onCollaboratorsState.observe(viewLifecycleOwner) {collaboratorsState->

            when(collaboratorsState) {

                is CollaboratorsState.Success-> {
                    collaboratorAdapter?.submitList(collaboratorsState.collaborators)
                }

                is CollaboratorsState.Error ->{
                    val errorMessage = collaboratorsState.errorMessage
                    Toast.makeText(context,errorMessage,Toast.LENGTH_LONG).show()
                }

                else->Unit
            }
        }


    }
}