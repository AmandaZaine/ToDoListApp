package com.amandazaine.todolistapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amandazaine.todolistapp.databinding.TaskItemBinding
import com.amandazaine.todolistapp.model.Task

class TaskItemAdapter(
    val onClickDelete: (Int) -> Unit,
    val onClickEdit: (Task) -> Unit
) : RecyclerView.Adapter<TaskItemViewHolder>() {
    private var taskList: List<Task> = emptyList()

    fun setTasks(newTaskList: List<Task>) {
        this.taskList = newTaskList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val taskItemBinding = TaskItemBinding.inflate(layoutInflater, parent, false)

        return TaskItemViewHolder(taskItemBinding)
    }

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val task = taskList[position]
        holder.bind(task, onClickDelete, onClickEdit)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
}