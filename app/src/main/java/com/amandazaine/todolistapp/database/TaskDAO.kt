package com.amandazaine.todolistapp.database

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.amandazaine.todolistapp.model.Task

class TaskDAO(context: Context) : ITaskDAO {

    private val write = DatabaseHelper(context).writableDatabase
    private val read = DatabaseHelper(context).readableDatabase


    override fun save(task: Task): Boolean {

        val contentValues = ContentValues()
        contentValues.put("description", task.description)

        try {
            write.insert(
                DatabaseHelper.TABLE_TASK,
                null,
                contentValues
            )
            Log.i("info_db", "Success saving task")
        } catch(e: Exception) {
            e.printStackTrace()
            Log.i("info_db", "Failed to save task")
            return false
        }

        return true
    }

    override fun update(task: Task): Boolean {
        TODO("Not yet implemented")
    }

    override fun delete(taskId: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Task> {
        TODO("Not yet implemented")
    }
}