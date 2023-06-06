package com.example.project

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import java.util.*

class AddActivity : AppCompatActivity() {


    var añoActual=0
    var mesActual=0
    var díaActual=0
    var horaActual=0
    var minutoActual=0
    var status = true

    override fun onCreate(savedInstanceState: Bundle?) {
        //Estas variables se utilizan para mostrar fecha y hora actual al abrir los time y date picker dialog
        val calendar = Calendar.getInstance()
        añoActual = calendar.get(Calendar.YEAR)
        mesActual = calendar.get(Calendar.MONTH)
        díaActual = calendar.get(Calendar.DAY_OF_MONTH)
        horaActual = calendar.get(Calendar.HOUR_OF_DAY)
        minutoActual = calendar.get(Calendar.MINUTE)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)





        //Fecha y hora toman su valor aqui porque se usan dentro de buttonGuardar.setOnClickListener y de los pickers dialog
        val foci: TextView = findViewById(R.id.editTextFecha)
        val hora: TextView = findViewById(R.id.editTextHora)


        val buttonGuardar: Button = findViewById(R.id.buttonGuardar)

        buttonGuardar.setOnClickListener {
            // Realizar acciones de guardado aquí
            val nombre = findViewById<EditText>(R.id.editTextNombre).text.toString()
            val descripcion = findViewById<EditText>(R.id.editTextDescripcion).text.toString()
            val dificultad = when (findViewById<RadioGroup>(R.id.radioGroupDificultad).checkedRadioButtonId) {
                R.id.radioAlta -> 1
                R.id.radioMedia -> 2
                R.id.radioBaja -> 3
                else -> 0 // Valor por defecto en caso de que no se haya seleccionado ninguna opción
            }
            val favorita = findViewById<ToggleButton>(R.id.toggleFavorita).isChecked
            val nuevaActividad = Actividad(nombre, descripcion, foci.text.toString(), hora.text.toString(), dificultad, favorita,status)

            // Agregar la nuevaActividad a la lista del objeto singleton
            singleton.agregarActividad(nuevaActividad)
            //Termina actividad y la pantalla vuelve al MainActivity
            finish()
        }



        // Funciones para inflar el date y time piker dialog y escribirlos en pantalla
        val buttonSeleccionarFecha: Button = findViewById(R.id.buttonFecha)
        val buttonSeleccionarHora: Button = findViewById(R.id.buttonHora)
        buttonSeleccionarFecha.setOnClickListener {
            val datePickerDialog = DatePickerDialog(this, { _, year, month, day ->
                val fechaSeleccionada = "$day/${month + 1}/$year"
                // Asignar la fecha seleccionada a un TextView o EditText en el formulario
                foci.text = fechaSeleccionada
            }, añoActual, mesActual, díaActual)
            datePickerDialog.show()
        }
        buttonSeleccionarHora.setOnClickListener {
            val timePickerDialog = TimePickerDialog(this, { _, hourOfDay, minute ->
                val horaSeleccionada = String.format("%02d:%02d", hourOfDay, minute)
                // Asignar la hora seleccionada a un TextView o EditText en el formulario
                hora.setText(horaSeleccionada)
            }, horaActual, minutoActual, true)
            timePickerDialog.show()
        }



    }




}