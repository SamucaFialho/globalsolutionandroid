package com.github.samucafialho.globalsolutionhenriquesamuel.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.samucafialho.globalsolutionhenriquesamuel.R
import com.github.samucafialho.globalsolutionhenriquesamuel.data.EventoDAO
import com.github.samucafialho.globalsolutionhenriquesamuel.model.ItemModel


    class ItemsAdapter(private val onItemRemoved: (ItemModel) -> Unit) :
        RecyclerView.Adapter<ItemsAdapter.EventoViewHolder>() {

        private var eventos = listOf<ItemModel>()


        inner class EventoViewHolder(view: View) : RecyclerView.ViewHolder(view) {


            val textView = view.findViewById<TextView>(R.id.textViewItem)
            val excluir = view.findViewById<ImageButton>(R.id.imageButton)

            fun bind(evento: ItemModel) {
                textView.text ="Local: ${evento.local}, Tipo: ${evento.tipo}, Impacto: ${evento.impacto}," +
                        "Data: ${evento.data}, Afetados: ${evento.afetados}"
                excluir.setOnClickListener {
                    onItemRemoved(evento)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventoViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout, parent, false)
            return EventoViewHolder(view)
        }

        override fun getItemCount(): Int = eventos.size

        override fun onBindViewHolder(holder: EventoViewHolder, position: Int) {
            val item = eventos[position]
            holder.bind(item)
        }

        fun updateItems(novosEventos: List<ItemModel>) {
            eventos = novosEventos
            notifyDataSetChanged()
        }
    }
