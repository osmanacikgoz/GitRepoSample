package com.example.cleanarchitecturegitsample.presentation.user_info.adapter.collaborator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.anthony.net.sample.github.domain.entity.user_info.Collaborator
import com.example.cleanarchitecturegitsample.R
import com.example.cleanarchitecturegitsample.databinding.CollaboratorItemBinding


class CollaboratorAdapter(
    collaboratorItemCallback: CollaboratorItemCallback,
) :
    ListAdapter<Collaborator, CollaboratorAdapter.ViewHolder>(collaboratorItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CollaboratorItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(getItem(position))

    }

    inner class ViewHolder(private val binding: CollaboratorItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Collaborator) {
            binding.apply {

                collaboratorImg.load(item.avatarUrl) {
                    crossfade(true)
                    placeholder(R.drawable.github)
                    transformations(CircleCropTransformation())
                }

                collaboratorName.text = item.collaboratorName
            }

        }

    }

}