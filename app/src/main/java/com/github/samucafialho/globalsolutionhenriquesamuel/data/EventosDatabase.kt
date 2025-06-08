package com.github.samucafialho.globalsolutionhenriquesamuel.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.samucafialho.globalsolutionhenriquesamuel.model.EventosExtremosModel

@Database(entities = [EventosExtremosModel::class], version = 1)
abstract class EventosDatabase : RoomDatabase() {
    abstract fun eventoDAO(): EventoDAO

}