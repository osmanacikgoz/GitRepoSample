package com.example.cleanarchitecturegitsample.presentation.user_info.adapter.collaborator

import androidx.recyclerview.widget.DiffUtil
import com.anthony.net.sample.github.domain.entity.user_info.Collaborator
import com.anthony.net.sample.github.domain.entity.user_info.Commit

class CollaboratorItemCallback : DiffUtil.ItemCallback<Collaborator>() {

    override fun areItemsTheSame(oldItem: Collaborator, newItem: Collaborator): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Collaborator, newItem: Collaborator): Boolean {
        return oldItem.id == newItem.id
    }
}