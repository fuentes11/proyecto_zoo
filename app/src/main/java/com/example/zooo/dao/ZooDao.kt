package com.example.zooo.dao

import androidx.room.*
import com.example.zooo.data.Zoo
import kotlinx.coroutines.flow.Flow

@Dao
interface ZooDao {
    @Query("SELECT * FROM Zoo_table ORDER BY name ASC")
    fun getAlphabetizedZoo(): Flow<List<Zoo>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(zoo: Zoo)
    @Query("Delete From zoo_table where id =:id")
    suspend fun deleteById(id: Int)
    @Query("UPDATE Zoo_table SET name = :name, route = :route WHERE id =:id")
    suspend fun update(name: String?, route: String?, id: Int)
}