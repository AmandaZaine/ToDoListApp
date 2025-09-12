package com.amandazaine.todolistapp.adapter

import androidx.recyclerview.widget.RecyclerView
import com.amandazaine.todolistapp.databinding.TaskItemBinding
import com.amandazaine.todolistapp.model.Task

class TaskItemViewHolder(taskItemBinding: TaskItemBinding) : RecyclerView.ViewHolder(taskItemBinding.root) {
    private val binding = taskItemBinding

    fun bind(
        task: Task,
        onClickDelete: (Int) -> Unit,
        onClickEdit: (Task) -> Unit
    ) {
        binding.textTask.text = task.description
        binding.textDate.text = task.date
        binding.imBtDeleteTask.setOnClickListener {
            onClickDelete(task.id)
        }

        binding.imBtEditTask.setOnClickListener {
            onClickEdit(task)
        }
    }
}