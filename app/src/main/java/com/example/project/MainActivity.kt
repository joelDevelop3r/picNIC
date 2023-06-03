package com.example.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView= findViewById<RecyclerView>(R.id.recyclerView)
        val adapter =  MyAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

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