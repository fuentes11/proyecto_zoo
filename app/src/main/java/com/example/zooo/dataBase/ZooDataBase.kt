package com.example.zooo.dataBase

import androidx.room.Database
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.zooo.dao.ZooDao
import com.example.zooo.data.Zoo

@Database(entities = [Zoo::class], version = 1, exportSchema = false)
abstract class ZooDataBase : RoomDatabase() {
    abstract fun ZooDao(): ZooDao

    companion object {
        @Volatile
        private var INSTANCE: ZooDataBase? = null
        fun getDatabase(context: Context): ZooDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ZooDataBase::class.java,
                    "Zoo_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
