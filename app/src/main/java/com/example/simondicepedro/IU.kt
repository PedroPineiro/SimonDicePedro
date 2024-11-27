package com.example.simondicepedro

import MainViewModel
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState

@Composable
fun interfazColores(viewModel: MainViewModel = viewModel(), modifier: Modifier = Modifier) {
    // Obtenemos el valor del record, el color actual y el mensaje de error desde el ViewModel
    val record by viewModel.record.collectAsState()
    val currentColor by viewModel.currentColor.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Mostramos los botones de colores
            Botones(viewModel, currentColor)
            // Mostramos el record actual
            Text(
                text = "Record: ${record.record}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(50.dp)
            )
        }
        // Si hay un mensaje de error, lo mostramos en una Snackbar
        errorMessage?.let { message ->
            Snackbar(
                modifier = Modifier.padding(16.dp),
                action = {
                    Button(onClick = { viewModel.clearErrorMessage() }) {
                        Text("Dismiss")
                    }
                }
            ) {
                Text(message)
            }
        }
    }
}

@Composable
fun Botones(viewModel: MainViewModel, currentColor: Color?) {
    // Creamos una fila para mostrar los botones de colores
    Column {
        Row {
            BotonVerde(viewModel, currentColor)
            BotonRojo(viewModel, currentColor)
        }
        Row {
            BotonAzul(viewModel, currentColor)
            BotonAmarillo(viewModel, currentColor)
        }
    }
}

@Composable
fun BotonVerde(viewModel: MainViewModel, currentColor: Color?) {
    // Animamos el cambio de color de fondo si el color actual es verde
    val backgroundColor by animateColorAsState(
        targetValue = if (currentColor == Color.Green) Color.LightGray else Color.Green
    )
    Button(
        onClick = { viewModel.userInput(Color.Green) },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor)
    ) {}
}

@Composable
fun BotonRojo(viewModel: MainViewModel, currentColor: Color?) {
    // Animamos el cambio de color de fondo si el color actual es rojo
    val backgroundColor by animateColorAsState(
        targetValue = if (currentColor == Color.Red) Color.LightGray else Color.Red
    )
    Button(
        onClick = { viewModel.userInput(Color.Red) },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor)
    ) {}
}

@Composable
fun BotonAzul(viewModel: MainViewModel, currentColor: Color?) {
    // Animamos el cambio de color de fondo si el color actual es amarillo
    val backgroundColor by animateColorAsState(
        targetValue = if (currentColor == Color.Yellow) Color.LightGray else Color.Yellow
    )
    Button(
        onClick = { viewModel.userInput(Color.Yellow) },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor)
    ) {}
}

@Composable
fun BotonAmarillo(viewModel: MainViewModel, currentColor: Color?) {
    // Animamos el cambio de color de fondo si el color actual es azul
    val backgroundColor by animateColorAsState(
        targetValue = if (currentColor == Color.Blue) Color.LightGray else Color.Blue
    )
    Button(
        onClick = { viewModel.userInput(Color.Blue) },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor)
    ) {}
}