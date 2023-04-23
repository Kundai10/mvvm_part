package com.example.weeklywins.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wins_table")
data class MyWinsItem(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val winTitle: String,
    val winDayOfWeek: String,
    //val winContent: String,
    //val winImage: String? = null,

)
