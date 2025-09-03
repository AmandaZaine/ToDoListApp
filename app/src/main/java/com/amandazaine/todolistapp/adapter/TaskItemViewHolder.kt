package com.amandazaine.todolistapp.adapter

import androidx.recyclerview.widget.RecyclerView
import com.amandazaine.todolistapp.databinding.TaskItemBinding
import com.amandazaine.todolistapp.model.Task

class TaskItemViewHolder(taskItemBinding: TaskItemBinding) : RecyclerView.ViewHolder(taskItemBinding.root) {
    private val binding = taskItemBinding

    fun bind(task: Task) {
        binding.textTask.text = task.description
        binding.textDate.text = task.date
    }
}