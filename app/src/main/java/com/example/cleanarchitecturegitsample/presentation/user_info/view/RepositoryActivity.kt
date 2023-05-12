package com.example.cleanarchitecturegitsample.presentation.user_info.view

import android.os.Bundle
import com.example.cleanarchitecturegitsample.R
import com.example.cleanarchitecturegitsample.databinding.ActivityRepositoryBinding
import com.example.cleanarchitecturegitsample.domain.entity.login.Repository
import com.example.cleanarchitecturegitsample.presentation.base.BaseActivity
import com.example.cleanarchitecturegitsample.presentation.user_info.adapter.RepositoryViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class RepositoryActivity : BaseActivity() {


    private lateinit var binding: ActivityRepositoryBinding

    companion object {
        const val REPOSITORY = "Repository"

        const val BUNDLE = "Bundle"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRepositoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        val repo = intent.getBundleExtra(BUNDLE)?.getSerializable(REPOSITORY) as? Repository

        val userName = repo?.repositoryOwner.orEmpty()
        val repoName = repo?.repositoryName.orEmpty()

        binding.appName.text = repoName
        binding.appDescription.text = repo?.repositoryDescription ?: ""

        val pages = resources.getStringArray(R.array.repository_tab)

        val homeViewPagerAdapter = RepositoryViewPagerAdapter(
            this, userName, repoName
        )

        binding.reposViewPager.adapter = homeViewPagerAdapter

        TabLayoutMediator(
            binding.reposTabLayout,
            binding.reposViewPager
        ) { tab, position ->
            tab.text = (pages[position])
        }.attach()
    }
}