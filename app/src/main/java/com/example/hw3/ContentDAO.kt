package com.example.hw3

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContentDAO{

    @Insert
    fun insert(ProViewModel:ContentData)

    @Update
    fun update(ProViewModel:ContentData)

    @Query("SELECT * from profile_content_table WHERE profileid = :key")
    fun get(key: Long): ContentData?

    @Query("SELECT * FROM profile_content_table ORDER BY profileid DESC LIMIT 1")
    fun getTonight(): ContentData?

}