package com.example.hw3

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile_content_table")
data class ContentData(
    @PrimaryKey(autoGenerate = true)
    var profileid : Long=0L,

    @ColumnInfo(name = "your_name")
    var name : String="",

    @ColumnInfo(name = "your_nickname")
    var nickname : String="",

    @ColumnInfo(name = "about_you")
    var aboutyou : String=""
)
