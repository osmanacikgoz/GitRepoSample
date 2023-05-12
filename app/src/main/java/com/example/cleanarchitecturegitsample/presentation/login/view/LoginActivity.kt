package com.example.cleanarchitecturegitsample.presentation.login.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.cleanarchitecturegitsample.databinding.ActivityLoginBinding
import com.example.cleanarchitecturegitsample.presentation.base.BaseActivity
import com.example.cleanarchitecturegitsample.presentation.login.viewmodel.LoginState
import com.example.cleanarchitecturegitsample.presentation.login.viewmodel.LoginViewModel
import com.example.cleanarchitecturegitsample.presentation.user_info.view.UserInfoActivity
import org.koin.android.ext.android.inject

class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by inject()

    override fun onStart() {
        super.onStart()
        initViewModel()
    }

    override fun onStop() {
        super.onStop()
        viewModel.onLoginState.removeObservers(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

    }


    private fun initView() {
        binding.searchButton.setOnClickListener {
            val userName = binding.userEditText.text.toString()

            if (userName.isEmpty()) {
                Toast.makeText(this, "Enter your username", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            viewModel.getUser(userName)
        }
    }

    private fun initViewModel() {
        viewModel.onLoginState.observe(this) { loginState ->
            when (loginState) {
                is LoginState.Success -> {
                    val login = loginState.user?.login ?: return@observe
                    openUserInfoPage(login)
                }
                is LoginState.Error -> {
                    val errorMesage = loginState.errorMessage
                    Toast.makeText(this, errorMesage, Toast.LENGTH_LONG).show()
                }
                else -> Unit
            }
        }
    }

    private fun openUserInfoPage(loginName: String) {
        val intent = Intent()

        intent.putExtra(UserInfoActivity.LOGIN_NAME, loginName)

        intent.setClass(this, UserInfoActivity::class.java)

        startActivity(intent)

        finish()
    }

}