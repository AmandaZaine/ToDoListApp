package com.amandazaine.todolistapp.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.amandazaine.todolistapp.model.Task
import java.time.Clock
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.text.format

class TaskDAO(context: Context) : ITaskDAO {

    private val write = DatabaseHelper(context).writableDatabase
    private val read = DatabaseHelper(context).readableDatabase

    override fun save(task: Task): Boolean {
        val contentValues = ContentValues()
        contentValues.put("description", task.description)

        try {
            write.insert(DatabaseHelper.TABLE_TASK, null, contentValues)
            Log.i("info_db", "Success saving task")
        } catch(e: Exception) {
            e.printStackTrace()
            Log.i("info_db", "Failed to save task")
            return false
        }

        return true
    }

    override fun update(task: Task): Boolean {
        val contentValues = ContentValues()
        contentValues.put("description", task.description)

        val where = "id = ?"
        val whereArgs = arrayOf(task.id.toString())

        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val currentDate = LocalDate.now().format(formatter) // DD/MM/YYYY
        contentValues.put("creation_date", currentDate)

        try {
            write.update(DatabaseHelper.TABLE_TASK, contentValues, where, whereArgs)
            Log.i("info_db", "Success updating task")
        } catch(e: Exception) {
            e.printStackTrace()
            Log.i("info_db", "Failed to update task")
            return false
        }
        return true
    }

    override fun delete(taskId: Int): Boolean {
        val where = "id = ?"
        val whereArgs = arrayOf(taskId.toString())
        try {
            write.delete(DatabaseHelper.TABLE_TASK, where, whereArgs)
            Log.i("info_db", "Success deleting task")
        } catch(e: Exception) {
            e.printStackTrace()
            Log.i("info_db", "Failed to delete task")
            return false
        }

        return true
    }

    override fun getAll(): List<Task> {

        val tasks = mutableListOf<Task>()
        val sql = "SELECT id, description, strftime('%d/%m/%Y', creation_date) as creation_date FROM ${DatabaseHelper.TABLE_TASK};"

        try {
            val cursor: Cursor = read.rawQuery(sql, null)

            while(cursor.moveToNext()) {
                val task = Task(
                    cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                    cursor.getString(cursor.getColumnIndexOrThrow("description")),
                    cursor.getString(cursor.getColumnIndexOrThrow("creation_date"))
                )

                tasks.add(task)
            }

            cursor.close()

            Log.i("info_db", "Success getting all tasks")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("info_db", "Failed to get all tasks")
            return emptyList()
        }

        return tasks
    }
}