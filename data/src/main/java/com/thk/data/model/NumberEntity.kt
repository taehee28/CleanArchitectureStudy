package com.thk.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "numbers")
data class NumberEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val value: Int
)
