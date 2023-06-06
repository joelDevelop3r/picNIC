package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.Actividad

class MainActivity : AppCompatActivity() {



    //Author: Joel López
    // listaActividades es la variable global de uso local en esta activitie, si deseas remplazarla,
    // hazlo, solo que tu lista sea del tipo mutableListOf<Actividad>()
    private var listaActividades = mutableListOf<Actividad>()
    private lateinit var poupmenu : ImageView
    private lateinit var adapter : MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nuevaActividad = Actividad("aa", "ruta", "klo", "kk", 1, true,true)

        // Agregar la nuevaActividad a la lista del objeto singleton
        singleton.agregarActividad(nuevaActividad)


        val recyclerView= findViewById<RecyclerView>(R.id.recyclerView)
        val adapter =  MyAdapter()


        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


    }


    override fun onResume() {
        super.onResume()

        //Author: Joel López
        //Este codigo reupera la lista de actividades actualizadas e imprime (opcional)
        listaActividades = singleton.obtenerListaActividades() as MutableList<Actividad>
        notifyDataSetChanged()
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
    override fun onCreateContextMenu(menu : ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_contextual, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.Edit -> {
                // Acción para eliminar la imagen seleccionada
                return true
            }
            R.id.Delete -> {
                // Acción para compartir la imagen seleccionada
                AlertDialog()
                return true
            }
            else -> return super.onContextItemSelected(item)
        }
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

    fun mostrar_mensaje(msj:String) : Boolean {
        val toast = Toast.makeText(this,msj, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.BOTTOM or Gravity.CENTER ,0,0)
        toast.show()
        return true
    }

    private  fun deleteName(posicion: Int){
        listaActividades.removeAt(posicion)
        adapter.notifyItemRemoved(posicion)
    }

    fun AlertDialog () {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Eliminar")
        builder.setMessage("¿Estás seguro de que deseas eliminar este elemento?")
        builder.setPositiveButton("Eliminar") { dialog, _ ->
            // Acción para eliminar el elemento seleccionado
            dialog.dismiss()
        }
        builder.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()


    }
}