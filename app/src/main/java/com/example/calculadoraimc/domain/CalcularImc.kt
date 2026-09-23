package com.example.calculadoraimc.domain

fun calcularImc(peso: Double, altura: Double): Double {
    return peso / (altura * altura)
}