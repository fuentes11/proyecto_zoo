package com.example.zooo.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Zoo_table")
data class Zoo(
        @PrimaryKey(autoGenerate = true)
        val id: Int = 0,
        @ColumnInfo(name = "name")
        val name: String,
        @ColumnInfo(name = "route")
        val route: String,
        )
