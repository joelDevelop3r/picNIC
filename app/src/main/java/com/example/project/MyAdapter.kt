package com.example.project

import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder?>() {

    private var title = mutableListOf<String>("Leer" ,"Jugar","Escribir" ,"Escuchar musica" ,"Practicar" ,"Correr" ,"Cenar","Ir al cine ","Salir" ,"Gym")
    private var Description = mutableListOf<String>("leer media hora","lol","practicar","por 30 minutos","el ingles","corre 30 min","preparala","ver the flash","ir a la tienda","ir por 1 hora")
    private var listaActividades: List<Actividad> =singleton.obtenerListaActividades() as List<Actividad>

    fun actualizarLista(nuevaLista: List<Actividad>){
        listaActividades=nuevaLista
        notifyDataSetChanged()
    }
    interface OnItemClikListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler ,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return title.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        listaActividades =singleton.obtenerListaActividades()
        if(position<listaActividades.size){
            viewHolder.txtViewWork.text = listaActividades[position].getNombre()
            viewHolder.txtViewDescrip.text = "hi"
            viewHolder.checkwork
            viewHolder.imglog

            viewHolder.imglog.setOnCreateContextMenuListener { menu, _, _ ->
                val inflater  = MenuInflater(viewHolder.imglog.context)
                inflater.inflate(R.menu.menu_contextual, menu)
            }
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtViewWork: TextView
        var txtViewDescrip: TextView
        var imglog: ImageView
        var checkwork: CheckBox

        init {
            txtViewWork = itemView.findViewById(R.id.NameWork)
            txtViewDescrip = itemView.findViewById(R.id.Descricion)
            imglog = itemView.findViewById(R.id.img1)
            checkwork = itemView.findViewById(R.id.CheckWork)
        }

        fun bind(item: Int, listener: OnItemClikListener){
            itemView.setOnClickListener{
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }

    fun Eliminar () {


    }
}

