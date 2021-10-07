package com.example.zooo.repository

import android.content.Context
import com.example.zooo.dao.ZooDao
import com.example.zooo.dataBase.ZooDataBase
import com.example.zooo.data.Zoo
import kotlinx.coroutines.flow.Flow

class ZooRepository (private val ZooDao: ZooDao) {
    companion object {
        private var INSTANCE : ZooRepository? = null
        fun getRepository(context: Context) : ZooRepository {
            return INSTANCE ?: synchronized(this) {
                val database = ZooDataBase.getDatabase(context)
                val instance = ZooRepository(database.ZooDao())
                INSTANCE = instance
                instance
            }
        }
    }

    val allZoo: Flow<List<Zoo>> = ZooDao.getAlphabetizedZoo()
    // By default Room runs suspend queries off the main thread, therefore, we don't need to
// implement anything else to ensure we're not doing long running database work
// off the main thread.
    suspend fun insert(vehicle: Zoo) {
        ZooDao.insert(vehicle)
    }
    suspend fun deleteById(id:Int){
        ZooDao.deleteById(id)
    }
}
