package com.example.project

//Author: Joel López
// Este es un objeto del paradigma singleton, kotlin permite implementarlo en un  .kt
// No se necesita una instancia como en las clases, ya que en si, este archivo se convierte en un objeto único durante la ejecucion
// del programa, es accesible desde todas las activities, por ello, se utiliza como una variable global o memoria
// compartida.

object singleton {
    val listaActividades = mutableListOf<Actividad>()

    fun agregarActividad(actividad: Actividad) {
        listaActividades.add(actividad)
    }

    fun obtenerListaActividades(): List<Actividad> {
        return listaActividades
    }
}
