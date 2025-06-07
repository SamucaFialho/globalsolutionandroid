package com.github.samucafialho.globalsolutionhenriquesamuel.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.github.samucafialho.globalsolutionhenriquesamuel.data.EventoDAO
import com.github.samucafialho.globalsolutionhenriquesamuel.data.ItemDatabase
import com.github.samucafialho.globalsolutionhenriquesamuel.model.ItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemsViewModel(application: Application) : AndroidViewModel(application) {

    private val EventoDAO: EventoDAO
    val itemsLiveData: LiveData<List<ItemModel>>

    init {
        val database = Room.databaseBuilder(
            getApplication(),
            ItemDatabase::class.java,
            "EventosExtremos_database"
        ).build()

        EventoDAO = database.itemDao()
        itemsLiveData = EventoDAO.getAll()
    }


    fun addEvento(evento: ItemModel) {
        viewModelScope.launch(Dispatchers.IO) {
            EventoDAO.insert(evento)
        }
    }

    fun removeItem(evento: ItemModel) {
        viewModelScope.launch(Dispatchers.IO) {
            EventoDAO.delete(evento)
        }
    }

}