package com.example.project;

//Author: Joel López
// Esta es la clase que define a cada tarea, la lista de tareas debe almacenar objetos de esta clase
public class Actividad {
    private String nombre;
    private String descripcion;
    private String fecha;
    private String hora;
    private int dificultad;
    private boolean favorita;

    public Actividad(String nombre, String descripcion, String fecha, String hora, int dificultad, boolean favorita) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.dificultad = dificultad;
        this.favorita = favorita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public boolean isFavorita() {
        return favorita;
    }

    public void setFavorita(boolean favorita) {
        this.favorita = favorita;
    }
}
