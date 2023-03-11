package com.egmvdev.preferencias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.egmvdev.preferencias.databinding.ActivityRegistroBinding

class registro : AppCompatActivity() {
    private lateinit var binding: ActivityRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRegistar.setOnClickListener {
            if(binding.etContraseA.text.isNotEmpty() && binding.etCorreo.text.isNotEmpty() && binding.etNombre.text.isNotEmpty()){
                val sharPref = getSharedPreferences("PrefenciasCompartidas", MODE_PRIVATE).edit()
                sharPref.putString("Nombre",binding.etNombre.text.toString())
                sharPref.putString("Correo",binding.etCorreo.text.toString())
                sharPref.putString("Contraseña",binding.etContraseA.text.toString())
                    .commit()
                Toast.makeText(this,"Se registro correctamente el usuario", Toast.LENGTH_LONG).show()
                finish()
                var intent: Intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                this.finish()

            }
            else{
                Toast.makeText(this,"Error los campos vacios", Toast.LENGTH_LONG).show()
            }
            true
        }
    }
}