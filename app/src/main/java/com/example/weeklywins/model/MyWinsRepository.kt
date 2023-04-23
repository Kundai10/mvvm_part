package com.example.weeklywins.model

import kotlinx.coroutines.flow.Flow

class MyWinsRepository(private val myWinsDao: MyWinsDao) {

    val getWins : Flow<List<MyWinsItem>> = myWinsDao.getWins()

    suspend fun insertWin(win:MyWinsItem) = myWinsDao.insertWin(win)

    suspend fun deleteWin(win:MyWinsItem) = myWinsDao.deleteWin(win)





}