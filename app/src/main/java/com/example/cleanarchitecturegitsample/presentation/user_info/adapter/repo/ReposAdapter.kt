package com.example.cleanarchitecturegitsample.presentation.user_info.adapter.repo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.cleanarchitecturegitsample.R
import com.example.cleanarchitecturegitsample.databinding.ItemRepositoryLayoutBinding
import com.example.cleanarchitecturegitsample.domain.entity.login.Repository

class ReposAdapter(
    repositoryItemCallback: RepositoryItemCallback,
    private val onRepoClickListener: OnRepositoryClicked
) : ListAdapter<Repository, ReposAdapter.ViewHolder>(repositoryItemCallback) {
    interface OnRepositoryClicked {
        fun onRepositoryClicked(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposAdapter.ViewHolder {
        return ViewHolder(
            ItemRepositoryLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ReposAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemRepositoryLayoutBinding) :
        RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {
        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(item: Repository) {
            binding.apply {
                gitImage.load(item.avatarUrl) {
                    crossfade(true)
                    placeholder(R.drawable.github)
                    transformations(CircleCropTransformation())
                }
                starValue.text = item.stargazersCount.toString()
                branchValue.text = item.forksCount.toString()
                ownerValue.text = item.repositoryOwner
                repoName.text = item.repositoryName
                description.text = item.repositoryDescription
                language.text = item.repositoryLanguage
            }
        }


        override fun onClick(p0: View?) {
            onRepoClickListener.onRepositoryClicked(adapterPosition)
        }

    }
}