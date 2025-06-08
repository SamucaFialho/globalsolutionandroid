package com.github.samucafialho.globalsolutionhenriquesamuel

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.github.samucafialho.globalsolutionhenriquesamuel.model.EventosExtremosModel
import com.github.samucafialho.globalsolutionhenriquesamuel.viewmodel.EventosExtremosAdapter
import com.github.samucafialho.globalsolutionhenriquesamuel.viewmodel.EventosExtremosViewModel
import com.github.samucafialho.globalsolutionhenriquesamuel.viewmodel.EventosViewModelFactory

class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: EventosExtremosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Lista de Eventos Extremos"


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val eventosExtremosAdapter = EventosExtremosAdapter { evento ->
            viewModel.removeItem(evento)
        }
        recyclerView.adapter = eventosExtremosAdapter


        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)
        val editTipo = findViewById<EditText>(R.id.editTextTipo)
        val editImpacto = findViewById<EditText>(R.id.editTextImpacto)
        val editAfetados = findViewById<EditText>(R.id.editTextAfetados)
        val editData = findViewById<EditText>(R.id.editTextData)

        button.setOnClickListener {
            val nome = editText.text.toString()
            val tipo = editTipo.text.toString()
            val impacto = editImpacto.text.toString()
            val data = editData.text.toString()
            val afetados = editAfetados.text.toString().toIntOrNull() ?: 0

            if (editText.text.isEmpty()) {
                editText.error = "Preencha com um local"
                return@setOnClickListener
            }
            if (editTipo.text.isEmpty()) {
                editText.error = "Preencha com um tipo"
                return@setOnClickListener
            }
            if (editImpacto.text.isEmpty()) {
                editText.error = "Preencha com um impacto(leve, moderado ou severo"
                return@setOnClickListener
            }
            if (editData.text.isEmpty()) {
                editText.error = "Preencha com uma data válida"
                return@setOnClickListener
            }
            if (editAfetados.text.isEmpty()) {
                editText.error = "Preencha com o número aproximado de pessoas afetadas"
                return@setOnClickListener
            }

            val evento = EventosExtremosModel(local = nome, tipo = tipo,
                impacto = impacto, data = data, afetados = afetados)
            viewModel.addEvento(evento)
            editText.text.clear()
            editTipo.text.clear()
            editImpacto.text.clear()
            editData.text.clear()
            editAfetados.text.clear()
        }

        val viewModelFactory = EventosViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(EventosExtremosViewModel::class.java)

        viewModel.itemsLiveData.observe(this) { items ->
            eventosExtremosAdapter.updateItems(items)
        }
    }
}
