package com.example.cleanarchitecturegitsample.presentation.user_info.adapter.repo

import androidx.recyclerview.widget.DiffUtil
import com.example.cleanarchitecturegitsample.domain.entity.login.Repository

class RepositoryItemCallback : DiffUtil.ItemCallback<Repository>() {

    override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean {
        return oldItem.id == newItem.id
    }

}