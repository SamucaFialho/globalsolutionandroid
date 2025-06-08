package com.github.samucafialho.globalsolutionhenriquesamuel.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.github.samucafialho.globalsolutionhenriquesamuel.data.EventoDAO
import com.github.samucafialho.globalsolutionhenriquesamuel.data.EventosDatabase
import com.github.samucafialho.globalsolutionhenriquesamuel.model.EventosExtremosModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EventosExtremosViewModel(application: Application) : AndroidViewModel(application) {

    private val EventoDAO: EventoDAO
    val itemsLiveData: LiveData<List<EventosExtremosModel>>

    init {
        val database = Room.databaseBuilder(
            getApplication(),
            EventosDatabase::class.java,
            "EventosExtremos_database"
        ).build()

        EventoDAO = database.eventoDAO()
        itemsLiveData = EventoDAO.getAll()
    }


    fun addEvento(evento: EventosExtremosModel) {
        viewModelScope.launch(Dispatchers.IO) {
            EventoDAO.insert(evento)
        }
    }

    fun removeItem(evento: EventosExtremosModel) {
        viewModelScope.launch(Dispatchers.IO) {
            EventoDAO.delete(evento)
        }
    }

}