package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.Actividad

class MainActivity : AppCompatActivity() {

    private lateinit var RecyclerView: RecyclerView
    private lateinit var tareas :MutableList<String>
    private lateinit var  layout : RecyclerView.LayoutManager

    //Author: Joel López
    // listaActividades es la variable global de uso local en esta activitie, si deseas remplazarla,
    // hazlo, solo que tu lista sea del tipo mutableListOf<Actividad>()
    private var listaActividades = mutableListOf<Actividad>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tareas = getJob()// cree un funcion que simula los dato a resivir del json
        RecyclerView= findViewById(R.id.recyclerView)
        layout = LinearLayoutManager(this)


        listaActividades = singleton.obtenerListaActividades() as MutableList<Actividad>



    }

    override fun onResume() {
        super.onResume()

        //Author: Joel López
        //Este codigo reupera la lista de actividades actualizadas e imprime (opcional)
        listaActividades = singleton.obtenerListaActividades() as MutableList<Actividad>

        for (actividad in listaActividades) {
            // Imprimir otros campos de la actividad según sea necesario
            Log.d("MainActivity", "Nombre: ${actividad.getNombre()}")
            Log.d("MainActivity", "Descripción: ${actividad.getDescripcion()}")
            Log.d("MainActivity", "Fecha: ${actividad.getFecha()}")
            Log.d("MainActivity", "Hora: ${actividad.getHora()}")
            Log.d("MainActivity", "Dificultad: ${actividad.getDificultad()}")
            Log.d("MainActivity", "Favorita: ${actividad.isFavorita()}")

        }


    }




    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.activity_main_menu, menu)
        return true;
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.new_activity -> navegar("Nueva actividad desde Menú de Opciones")
            else -> super.onOptionsItemSelected(item)
        }
    }


    fun navegar(msj: String) : Boolean {
        val toast = Toast.makeText(this, msj, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.BOTTOM or Gravity.CENTER, 0, 0)
        toast.show()
        val intent = Intent(this, AddActivity::class.java)
        startActivity(intent)
        return true
    }

    fun debug(msj: String) : Boolean {
        val toast = Toast.makeText(this, msj, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.BOTTOM or Gravity.CENTER, 0, 0)
        toast.show()
        return true
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