package com.example.cleanarchitecturegitsample.presentation.user_info.adapter.commit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.anthony.net.sample.github.domain.entity.user_info.Commit
import com.example.cleanarchitecturegitsample.databinding.ItemCommitBinding


class CommitItemAdapter(commitItemCallback: CommitItemCallback) :
    ListAdapter<Commit, CommitItemAdapter.ViewHolder>(commitItemCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            ItemCommitBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item = getItem(position))
    }


    inner class ViewHolder(private val binding: ItemCommitBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Commit) {
            binding.apply {
                date.text = item.date
                userName.text = item.userName
                message.text = item.message
            }
        }

    }

}