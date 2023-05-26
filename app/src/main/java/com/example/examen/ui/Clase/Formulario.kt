package com.example.examen.ui.Clase

import android.content.Context
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.room.Room
import com.example.examen.agregarClase
import com.example.examen.editarClase
import com.example.examen.ui.AppDataBase
import com.example.examen.ui.Usuario.Usuario

@Composable
fun Formulario(
    id: String,
    nombre: String,
    descripcion: String,

    funId: (String) -> Unit,
    funNombre: (String) -> Unit,
    funDescripcion: (String) -> Unit,

    isEditando: Boolean,
    funIsEditando: () -> Unit,
    textButton: String,
    funTextButton: (String) -> Unit,
    //bd: AppDataBase,
    listaClase: MutableList<Clase>,
    funResetCampos: () -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = id,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funId(it) },
        label = { Text(text = " "+listaClase.size) },
        enabled = false
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = nombre,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funNombre(it) },
        label = { Text(text = "Nombre") },
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = descripcion,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funDescripcion(it) },
        label = { Text(text = "Descripcion") }
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    Button(modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
        onClick = {
            if (isEditando) {
                editarClase(id, nombre, descripcion, listaClase)
                funTextButton("Agregar Usuario")
                funIsEditando()

            } else {
                agregarClase(" "+listaClase.size, nombre, descripcion, listaClase)
            }
            funResetCampos()
        }
    ) {
        Text(
            color = Color.White,
            text = textButton
        )
    }
}