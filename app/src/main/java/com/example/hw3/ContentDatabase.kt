package com.example.hw3

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ContentData::class], version = 1,  exportSchema = false)
abstract  class ContentDatabase : RoomDatabase(){
    abstract val contentdao : ContentDAO

    companion object {
        @Volatile
        private var INSTANCE: ContentDatabase? = null

        fun getInstance(context: Context): ContentDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ContentDatabase::class.java,
                        "content_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                        INSTANCE = instance
                }
                return instance
            }
        }
    }

}