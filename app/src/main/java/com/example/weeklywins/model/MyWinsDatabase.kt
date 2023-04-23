package com.example.weeklywins.model

import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weeklywins.model.MyWinsItem

@Database(entities = [MyWinsItem::class], version=2, exportSchema = false)
abstract class MyWinsDatabase: RoomDatabase() {
    abstract fun myWinDao(): MyWinsDao

    companion object{
        @Volatile
        private var INSTANCE: MyWinsDatabase? = null

        fun getDatabase(context: Context): MyWinsDatabase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyWinsDatabase::class.java,
                    "win_database",
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE= instance
                return instance
            }

        }
    }

}