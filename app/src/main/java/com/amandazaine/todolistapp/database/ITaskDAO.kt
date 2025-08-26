package com.amandazaine.todolistapp.database

import com.amandazaine.todolistapp.model.Task

interface ITaskDAO {
    fun save( task: Task): Boolean
    fun update( task: Task): Boolean
    fun delete( taskId: Int): Boolean
    fun getAll(): List<Task>
}