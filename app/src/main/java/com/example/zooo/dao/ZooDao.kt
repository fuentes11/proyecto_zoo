package com.example.zooo.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.zooo.data.Zoo
import kotlinx.coroutines.flow.Flow

@Dao
interface ZooDao {
    @Query("SELECT * FROM Zoo_table ORDER BY name ASC")
    fun getAlphabetizedZoo(): Flow<List<Zoo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(Zoo: Zoo)

    @Query("Delete From zoo_table where id =:id")
    suspend fun deleteById(id: Int)
}