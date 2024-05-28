package com.example.trabalhonarak

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Maineditobpt : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_maineditobpt)

        val button1 = findViewById<ImageButton>(R.id.imageButton15)
        val button2 = findViewById<Button>(R.id.button16)

        button1.setOnClickListener() {
            TrocarTela1()
        }
        button2.setOnClickListener(){
            TrocarTela2()
        }

        val pesquisa = findViewById<EditText>(R.id.editTextText)
        pesquisa.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                pesquisa.hint = ""
            } else {
                pesquisa.hint = "Nome da Obra"
            }
        }
    }

    private fun TrocarTela1() {
        val intent1 = Intent(this, Mainpt::class.java)
        startActivity(intent1)
    }

    private fun TrocarTela2(){
        val intent2 = Intent(this, Maineditobpt2::class.java)
        startActivity(intent2)
    }
}
