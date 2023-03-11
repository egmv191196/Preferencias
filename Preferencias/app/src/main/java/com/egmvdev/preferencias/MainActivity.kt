package com.egmvdev.preferencias

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.egmvdev.preferencias.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val sharPref = getSharedPreferences("PrefenciasCompartidas", MODE_PRIVATE)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.setTitle("Inicio de sesion")

        var sesionActiva = sharPref.getBoolean("sesionActiva", false)
        if (sesionActiva == true){
            var intent: Intent = Intent(this, principal::class.java)
            startActivity(intent)
            this.finish()
        }else{
            //Toast.makeText(this,"La sesion activa es nula",Toast.LENGTH_LONG).show()

        }
        binding.btnInicio.setOnClickListener {
            if(binding.etContraseA.text.isNotEmpty() && binding.etCorreo.text.isNotEmpty()) {
                val correo = sharPref.getString("Correo", "")
                val contraseña = sharPref.getString("Contraseña", "")
                if (binding.etContraseA.text.toString() == contraseña && binding.etCorreo.text.toString() == correo) {
                    if (binding.chBox.isChecked) {
                        sharPref.edit().putBoolean("sesionActiva", true).commit()
                    }
                    var intent: Intent = Intent(this, principal::class.java)
                    startActivity(intent)
                    this.finish()
                } else {
                    Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_LONG).show()
                }
            }
        }


        binding.btnRegistro.setOnClickListener {
            var intent: Intent = Intent(this, registro::class.java)
            startActivity(intent)
            this.finish()
        }


    }
}