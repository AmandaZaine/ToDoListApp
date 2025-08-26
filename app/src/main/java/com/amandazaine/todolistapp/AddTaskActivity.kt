package com.amandazaine.todolistapp

import android.os.Bundle
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

    private val taskDAO = TaskDAO(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btSaveTask.setOnClickListener {
            val description = binding.editAddTask.text

            if (description.isNotEmpty() && description.isNotBlank()) {
                val task = Task(-1, description.toString(), "default")

                if(taskDAO.save(task)) {
                    Toast.makeText(this, "Success in saving the task!", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "Failed to save task!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Empty field! Write a task!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun save(task: Task) {
        TODO("Not yet implemented")
    }


}