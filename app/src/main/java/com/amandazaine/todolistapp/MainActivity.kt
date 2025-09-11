package com.amandazaine.todolistapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.amandazaine.todolistapp.adapter.TaskItemAdapter
import com.amandazaine.todolistapp.database.TaskDAO
import com.amandazaine.todolistapp.databinding.ActivityMainBinding
import com.amandazaine.todolistapp.model.Task
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var allTasks = emptyList<Task>()
    private var taskItemAdapter: TaskItemAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Setting a Toolbar as the ActionBar
        val toolbar: Toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        //RecyclerView
        taskItemAdapter = TaskItemAdapter(
            { id -> confirmDeletion(id) }
        )

        binding.rvTasks.adapter = taskItemAdapter
        binding.rvTasks.layoutManager = LinearLayoutManager(this)

        //Button to add task
        binding.fabAddTask.setOnClickListener {
            Log.i("info_db", "Add task button clicked")

            val intent = Intent(this, AddTaskActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()

        //Update the list of tasks
        updateListTasks()
    }

    private fun confirmDeletion(id: Int) {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Confirm Deletion")
        alertDialogBuilder.setMessage("Are you sure you want to delete this task?")
        alertDialogBuilder.setPositiveButton("Yes") { _, _ ->
            val success = TaskDAO(this).delete(id)

            if (success) {
                Toast.makeText(this, "Task deleted successfully", Toast.LENGTH_SHORT).show()
                updateListTasks()
            } else {
                Toast.makeText(this, "Failed to delete task", Toast.LENGTH_SHORT).show()
            }
        }
        alertDialogBuilder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun updateListTasks() {
        allTasks = TaskDAO(this).getAll()
        taskItemAdapter?.setTasks(allTasks)
    }
}