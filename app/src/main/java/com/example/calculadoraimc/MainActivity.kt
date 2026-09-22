package com.example.calculadoraimc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.calculadoraimc.ui.CalculadoraImcApp
import com.example.calculadoraimc.ui.theme.CalculadoraimcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraimcTheme {
                CalculadoraImcApp()
            }
        }
    }
}