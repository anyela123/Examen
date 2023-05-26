package com.example.examen.ui.Clase

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.room.Room
import com.example.examen.ui.AppDataBase

@Composable
fun CardClase(
    funId: (String) -> Unit,
    funNombre: (String) -> Unit,
    funDescripcion: (String) -> Unit,
    funTextButton: (String) -> Unit,
    funIsEditando: (Boolean) -> Unit,
    clase: Clase,
    funBorrarClase: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            Arrangement.Center
        ) {
            Text(
                text = clase.id.toString(),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = clase.nombre.toString(),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = clase.descripcion.toString(),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                    onClick = {
                        funId(clase.id.toString())
                        funNombre(clase.nombre.toString())
                        funDescripcion(clase.descripcion.toString())
                        funTextButton("Editar Clase")
                        funIsEditando(true)
                    }
                ) {
                    Text(
                        color = Color.White,
                        text = "Editar"
                    )
                }
                Button(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                    onClick = {
                        funBorrarClase(clase.id.toString())
                    }
                ) {
                    Text(
                        color = Color.White,
                        text = "Borrar"
                    )
                }
            }
        }
    }
}