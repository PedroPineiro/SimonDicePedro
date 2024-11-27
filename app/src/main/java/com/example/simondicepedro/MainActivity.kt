package com.example.simondicepedro

import MainViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels

class MainActivity : ComponentActivity() {
    /**
     * Aquí estamos creando el ViewModel principal, utilizando el método viewModels, el cual recibe
     * un lambda que devuelve un MainViewModelFactory, que a su vez requiere un RecordRepository.
     */
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory(RecordRepository())
    }

    /**
     * En este método, configuramos el contenido de la actividad, que es donde se muestra la interfaz
     * de usuario con los botones y la lógica del juego.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            interfazColores(mainViewModel)
        }
    }
}