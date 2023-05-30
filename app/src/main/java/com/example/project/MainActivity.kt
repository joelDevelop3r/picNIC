package com.example.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var RecyclerView: RecyclerView
    private lateinit var tareas :MutableList<String>
    private lateinit var  layout : RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tareas = getJob()// cree un funcion que simula los dato a resivir del json
        RecyclerView= findViewById(R.id.recyclerView)
        layout = LinearLayoutManager(this)

    }

    //Lista mutable con las tareas a realizar
    private fun getJob(): MutableList<String>{
        return  object  : ArrayList<String>(){
            init{
                add("Leer")
                add("Jugar")
                add("Escribir")
                add("Escuchar musica")
                add("Practicar")
                add("Correr")
                add("Cenar")
                add("Ir al cine ")
                add("Salir")
                add("Gym")
            }
        }
    }
}