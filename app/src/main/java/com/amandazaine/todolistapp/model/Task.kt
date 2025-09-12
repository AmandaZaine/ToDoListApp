package com.amandazaine.todolistapp.model

import java.io.Serializable

data class Task(
    val id: Int,
    var description: String,
    val date: String
): Serializable