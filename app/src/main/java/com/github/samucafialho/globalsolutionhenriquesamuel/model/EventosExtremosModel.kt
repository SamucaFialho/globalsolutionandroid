package com.github.samucafialho.globalsolutionhenriquesamuel.model

import androidx.room.Entity
import androidx.room.PrimaryKey

    @Entity
    data class EventosExtremosModel(

        @PrimaryKey(autoGenerate = true)
        val id: Int = 0,
        val local: String,
        val tipo: String,
        val impacto: String,
        val data: String,
        val afetados: Int

    )
