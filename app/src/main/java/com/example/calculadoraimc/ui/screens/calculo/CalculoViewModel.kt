package com.example.calculadoraimc.ui.screens.calculo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calculadoraimc.domain.calcularImc
import com.example.calculadoraimc.domain.classificarImc
import com.example.calculadoraimc.domain.model.CalculoImc
import com.example.calculadoraimc.domain.repository.CalculoImcRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CalculoViewModel @Inject constructor(
    private val repository: CalculoImcRepository
) : ViewModel() {
    var state by mutableStateOf(CalculoUiState())
        private set

    fun onPesoChange(peso: String) {
        state = state.copy(
            peso = peso,
            pesoInvalido = false
        )
    }

    fun onAlturaChange(altura: String) {
        state = state.copy(
            altura = altura,
            alturaInvalida = false
        )
    }

    fun calcular() {
        val pesoNumero = state.peso.replace(",", ".").toDoubleOrNull()
        val alturaNumero = state.altura.replace(",", ".").toDoubleOrNull()

        val pesoInvalido = pesoNumero == null || pesoNumero <= 0
        val alturaInvalida = alturaNumero == null || alturaNumero <= 0

        if (pesoInvalido || alturaInvalida) {
            state = state.copy(
                pesoInvalido = pesoInvalido,
                alturaInvalida = alturaInvalida
            )

            return
        }

        val imc = calcularImc(
            peso = pesoNumero,
            altura = alturaNumero
        )

        val classificacao = classificarImc(imc)

        state = state.copy(
            imc = imc,
            classificacao = classificacao,
            pesoInvalido = false,
            alturaInvalida = false
        )

        viewModelScope.launch {
            repository.inserir(
                CalculoImc(
                    peso = pesoNumero,
                    altura = alturaNumero,
                    imc = imc,
                    classificacao = classificacao,
                    dataHora = System.currentTimeMillis()
                )
            )
        }
    }
}