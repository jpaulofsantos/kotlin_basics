package com.example.testeavd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.testeavd.databinding.ActivityLinearTestBinding

class LinearTest : AppCompatActivity() {

    lateinit var binding: ActivityLinearTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityLinearTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCadastro.setOnClickListener {
            var mail = binding?.editMail?.text.toString()
            Toast.makeText(baseContext, "$mail", Toast.LENGTH_SHORT).show()
        }

    }
}