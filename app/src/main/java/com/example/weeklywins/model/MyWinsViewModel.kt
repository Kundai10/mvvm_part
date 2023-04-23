package com.example.weeklywins.model


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.asLiveData


class MyWinsViewModel(private val repository: MyWinsRepository): ViewModel() {

    var winItems: LiveData<List<MyWinsItem>> = repository.getWins.asLiveData()

    fun getAllItems():LiveData<List<MyWinsItem>>{
         return repository.getWins.asLiveData()
    }

    fun addEditWinItem(newWin: MyWinsItem) = viewModelScope.launch {
        repository.insertWin(newWin)
    }

    fun deleteWinItem(oldWin: MyWinsItem) = viewModelScope.launch{
        repository.deleteWin(oldWin)
    }
}

class WinItemModelFactory(private val repository: MyWinsRepository) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T
    {
        if (modelClass.isAssignableFrom(MyWinsViewModel::class.java))
            return MyWinsViewModel(repository) as T

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}