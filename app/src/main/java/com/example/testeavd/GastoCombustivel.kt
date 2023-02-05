package com.example.testeavd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.testeavd.databinding.ActivityGastoCombustivelBinding
import java.text.DecimalFormat

lateinit var binding: ActivityGastoCombustivelBinding

class GastoCombustivel : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGastoCombustivelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //botão Calcular
        binding.btnCalcular.setOnClickListener {

            var distancia = binding?.tilDistancia2?.text.toString()
            var preco = binding?.tilPreco2?.text.toString()
            var autonomia = binding?.tilAutonomia2?.text.toString()

            if ((distancia.isBlank() || distancia == null) || (preco.isBlank() || preco == null) || (autonomia.isBlank() || autonomia == null)) {
                Toast.makeText(baseContext, "Favor preencher todos os dados!", Toast.LENGTH_SHORT).show()
            } else {

                var distanciaNew = distancia.toFloat()
                var precoNew = preco.toFloat()
                var autonomiaNew = autonomia.toFloat()

                binding.tvResultado.text = calculoCombustivel(distanciaNew, precoNew, autonomiaNew)
                binding.tvResultado.visibility = View.VISIBLE

                if (binding.cb2.isChecked) {
                    binding.tvResultado.text = "R$ ${"%.2f".format((calculoCombustivelFloat(distanciaNew, precoNew, autonomiaNew).div(2)))}"
                } else if (binding.cb3.isChecked) {
                    binding.tvResultado.text = "R$ ${"%.2f".format((calculoCombustivelFloat(distanciaNew, precoNew, autonomiaNew).div(3)))}"
                } else {
                    binding.tvResultado.text = calculoCombustivel(distanciaNew, precoNew, autonomiaNew)
                }
            }
        }

        //outra forma de aplicação do metodo onclicklistener (necessário implementar o metodo onClick)
        binding.btnCalcular2.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btnCalcular2) {
            Toast.makeText(baseContext, "Funcionou!", Toast.LENGTH_SHORT).show()
        }
    }

    fun calculoCombustivel(distancia: Float, precoCombustivel: Float, autonomia: Float): String {
        val valor = ((distancia / autonomia) * precoCombustivel)
        return "R$ ${"%.2f".format(valor)}"
    }

    fun calculoCombustivelFloat(distancia: Float, precoCombustivel: Float, autonomia: Float): Float {
        val valor = ((distancia / autonomia) * precoCombustivel)
        return valor
    }
}