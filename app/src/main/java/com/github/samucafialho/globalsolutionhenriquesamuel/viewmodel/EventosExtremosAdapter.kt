package com.github.samucafialho.globalsolutionhenriquesamuel.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.samucafialho.globalsolutionhenriquesamuel.R
import com.github.samucafialho.globalsolutionhenriquesamuel.model.EventosExtremosModel


    class EventosExtremosAdapter(private val onItemRemoved: (EventosExtremosModel) -> Unit) :
        RecyclerView.Adapter<EventosExtremosAdapter.EventoViewHolder>() {

        private var eventos = listOf<EventosExtremosModel>()


        inner class EventoViewHolder(view: View) : RecyclerView.ViewHolder(view) {


            val textView = view.findViewById<TextView>(R.id.textEvento)
            val excluir = view.findViewById<ImageButton>(R.id.imageButton)

            fun bind(evento: EventosExtremosModel) {
                textView.text ="Local: ${evento.local}, Tipo: ${evento.tipo}, Impacto: ${evento.impacto}," +
                        "Data: ${evento.data}, Afetados: ${evento.afetados}"
                excluir.setOnClickListener {
                    onItemRemoved(evento)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventoViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.eventoextremo_layout, parent, false)
            return EventoViewHolder(view)
        }

        override fun getItemCount(): Int = eventos.size

        override fun onBindViewHolder(holder: EventoViewHolder, position: Int) {
            val item = eventos[position]
            holder.bind(item)
        }

        fun updateItems(novosEventos: List<EventosExtremosModel>) {
            eventos = novosEventos
            notifyDataSetChanged()
        }
    }
