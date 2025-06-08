package com.github.samucafialho.globalsolutionhenriquesamuel.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.github.samucafialho.globalsolutionhenriquesamuel.model.EventosExtremosModel


@Dao
interface EventoDAO {

    @Query("SELECT * FROM EventosExtremosModel")
    fun getAll(): LiveData<List<EventosExtremosModel>>

    @Insert
    fun insert(evento: EventosExtremosModel)


    @Delete
    fun delete(evento: EventosExtremosModel)

}