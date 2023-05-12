package com.example.cleanarchitecturegitsample.presentation.user_info.view

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import com.example.cleanarchitecturegitsample.R
import com.example.cleanarchitecturegitsample.databinding.ActivityUserInfoBinding
import com.example.cleanarchitecturegitsample.presentation.base.BaseActivity
import com.example.cleanarchitecturegitsample.presentation.user_info.adapter.repo.ReposAdapter
import com.example.cleanarchitecturegitsample.presentation.user_info.adapter.repo.RepositoryItemCallback
import com.example.cleanarchitecturegitsample.presentation.user_info.viewmodel.user_info.UserInfoState
import com.example.cleanarchitecturegitsample.presentation.user_info.viewmodel.user_info.UserInfoViewModel
import org.koin.android.ext.android.inject

class UserInfoActivity : BaseActivity(), ReposAdapter.OnRepositoryClicked {

    companion object {
        const val LOGIN_NAME = "LoginName"
    }

    private lateinit var binding: ActivityUserInfoBinding

    private var reposAdapter: ReposAdapter? = null

    private val userInfoViewModel: UserInfoViewModel by inject()

    override fun onStart() {
        super.onStart()
        initViewModel()
    }

    override fun onStop() {
        super.onStop()
        userInfoViewModel.onUserInfoState.removeObservers(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        val loginName = intent.getStringExtra(LOGIN_NAME) ?: ""
        val actionBar = binding.actionBar
        actionBar.findViewById<TextView>(R.id.userName)

        reposAdapter = ReposAdapter(RepositoryItemCallback(), this)
        binding.apply {
            userInfoList.adapter = reposAdapter
            showLoadingDialog()
        }
        userInfoViewModel.getRepos(loginName)


    }

    private fun initViewModel() {
        userInfoViewModel.onUserInfoState.observe(this) { userInfoState ->

            when (userInfoState) {
                is UserInfoState.Success -> {
                    reposAdapter?.submitList(userInfoState.repository)
                }
                is UserInfoState.Error -> {
                    val errorMessage = userInfoState.errorMessage
                    Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
                }
                else -> Unit
            }
            dismissLoadingDialog()
        }
    }


    override fun onRepositoryClicked(position: Int) {
        Bundle().putSerializable(
            RepositoryActivity.REPOSITORY,
            reposAdapter?.currentList?.get(position)
        )
        Intent().putExtra(
            RepositoryActivity.BUNDLE,
            bundleOf()
        )
        startActivity(Intent().setClass(this, RepositoryActivity::class.java))

    }
}