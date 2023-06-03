package com.example.project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder?>() {

    private var title = arrayOf("Leer" ,"Jugar","Escribir" ,"Escuchar musica" ,"Practicar" ,"Correr" ,"Cenar","Ir al cine ","Salir" ,"Gym")
    private var Description = arrayOf("leer media hora","lol","practicar","por 30 minutos","el ingles","corre 30 min","preparala","ver the flash","ir a la tienda","ir por 1 hora")
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
        viewHolder.txtViewDescrip.text = title[position]
        viewHolder.txtViewDescrip.text = Description[position]
        viewHolder.checkwork
        viewHolder.imglog
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
}

