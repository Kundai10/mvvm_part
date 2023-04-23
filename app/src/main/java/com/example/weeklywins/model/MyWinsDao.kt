package com.example.weeklywins.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MyWinsDao {

    @Query("SELECT * FROM wins_table")
    fun getWins(): Flow<List<MyWinsItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWin(win: MyWinsItem){}

    @Delete
    suspend fun deleteWin(win: MyWinsItem){}



}