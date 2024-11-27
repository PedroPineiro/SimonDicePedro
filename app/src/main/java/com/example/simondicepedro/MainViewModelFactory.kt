package com.example.simondicepedro

import MainViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(
    private val repository: RecordRepository // El Factory recibe el RecordRepository para crear el ViewModel
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST") // Se suprime la advertencia por casteo no chequeado

    /**
     * Este método sobrescribe la creación del ViewModel, asegurando que si el modelClass es MainViewModel,
     * se creará una nueva instancia utilizando el RecordRepository.
     */
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T // Se devuelve el MainViewModel con el RecordRepository
        }
        throw IllegalArgumentException("Unknown ViewModel class") // Si el modelClass no es MainViewModel, se lanza una excepción.
    }
}
