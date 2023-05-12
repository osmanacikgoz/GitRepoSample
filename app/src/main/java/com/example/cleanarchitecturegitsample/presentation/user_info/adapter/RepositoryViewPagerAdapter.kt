package com.example.cleanarchitecturegitsample.presentation.user_info.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cleanarchitecturegitsample.presentation.user_info.view.CollaboratorsFragment
import com.example.cleanarchitecturegitsample.presentation.user_info.view.CommitFragment

class RepositoryViewPagerAdapter(
    fragmentActivity: FragmentActivity, private val userName: String, private val repoName: String
) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> CommitFragment.newInstance(userName, repoName)
        1 -> CollaboratorsFragment.newInstance(userName, repoName)
        else -> CommitFragment.newInstance(userName, repoName)
    }


}