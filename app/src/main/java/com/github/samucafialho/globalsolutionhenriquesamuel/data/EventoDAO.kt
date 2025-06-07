package com.github.samucafialho.globalsolutionhenriquesamuel.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.github.samucafialho.globalsolutionhenriquesamuel.model.ItemModel


@Dao
interface EventoDAO {

    @Query("SELECT * FROM ItemModel")
    fun getAll(): LiveData<List<ItemModel>>

    @Insert
    fun insert(evento: ItemModel)


    @Delete
    fun delete(evento: ItemModel)

}