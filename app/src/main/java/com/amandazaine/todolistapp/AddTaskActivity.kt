package com.amandazaine.todolistapp

import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.amandazaine.todolistapp.database.TaskDAO
import com.amandazaine.todolistapp.databinding.ActivityAddTaskBinding
import com.amandazaine.todolistapp.model.Task

class AddTaskActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityAddTaskBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var task: Task? = null
        val bundle = intent.extras

        if (bundle != null) {
            task = bundle.getSerializable("task") as Task
            binding.editAddTask.setText(task.description)
            binding.textAddTask.text = "Edit Task"
            binding.btSaveTask.text = "Edit"
        }

        binding.btSaveTask.setOnClickListener {
            val description = binding.editAddTask.text

            if (description.isNotEmpty() && description.isNotBlank()) {
                if (task != null) {
                    editTask(task, description)
                } else {
                    saveTask(description)
                }
            } else {
                Toast.makeText(this, "Empty field! Write a task!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun editTask(
        task: Task,
        description: Editable?
    ) {
        task.description = description.toString()
        val success = TaskDAO(this).update(task)

        if (success) {
            Toast.makeText(this, "Success in editing the task!", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(this, "Failed to edit task!", Toast.LENGTH_SHORT).show()
        }
    }

    fun saveTask(description: Editable?) {
        val task = Task(-1, description.toString(), "default")

        val taskDAO = TaskDAO(this)

        if (taskDAO.save(task)) {
            Toast.makeText(this, "Success in saving the task!", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(this, "Failed to save task!", Toast.LENGTH_SHORT).show()
        }
    }
}