package com.github.samucafialho.globalsolutionhenriquesamuel.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.samucafialho.globalsolutionhenriquesamuel.model.ItemModel


class ItemDatabase {

    @Database(entities = [ItemModel::class], version = 1)
    abstract class ItemDatabase : RoomDatabase() {
        abstract fun eventoDAO(): EventoDAO
    }

}