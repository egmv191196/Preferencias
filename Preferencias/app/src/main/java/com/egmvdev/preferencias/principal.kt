package com.egmvdev.preferencias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.egmvdev.preferencias.databinding.ActivityPrincipalBinding

class principal : AppCompatActivity() {
    private lateinit var binding: ActivityPrincipalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharPref = getSharedPreferences("PrefenciasCompartidas", MODE_PRIVATE)
        val nombre = sharPref.getString("Nombre", "")
        binding.tvSaludo.setText(binding.tvSaludo.text.toString()+" "+nombre)
        binding.btnCerrar.setOnClickListener {
            sharPref.edit().putBoolean("sesionActiva", false).commit()
            var intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }
    }
}