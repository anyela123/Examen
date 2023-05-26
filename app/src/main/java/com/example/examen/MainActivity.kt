package com.example.examen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.examen.ui.Clase.Clase
import com.example.examen.ui.Clase.Formulario
import com.example.examen.ui.theme.ExamenTheme
import com.example.examen.ui.Clase.CardClase as CardClase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamenTheme {
                // A surface container using the 'background' color from the theme

                //val db = Room.databaseBuilder(this, AppDataBase::class.java, "planta-beneficio").build()
                //val claseDao = db.claseDao()
                //val clase: List<Clase> = claseDao.getAllClase()
                //val cant=clase.size+1
                val listaClase = remember { mutableStateListOf<Clase>() }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Text(text="can"+cant)
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        ScreenCRUD(listaClase)
                    }

                }
            }
        }
    }
}


@Composable
fun ScreenCRUD(listaClase: MutableList<Clase>) {
    var id by remember { mutableStateOf(" "+listaClase.size) }
    var nombre by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var isEditando by remember { mutableStateOf(false) }
    var textButton by remember { mutableStateOf("Agregar Clase") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(12.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
        ) {
            Formulario(
                id = id,
                funId = {id = " "+listaClase.size},
                nombre = nombre,
                funNombre = { nombre = it },
                descripcion = descripcion,
                funDescripcion = { descripcion = it },

                isEditando = isEditando,
                funIsEditando = { isEditando = false },
                textButton = textButton,
                funTextButton = { textButton = it },

                listaClase = listaClase,
                funResetCampos = {
                    id = " "+listaClase.size
                    nombre = ""
                    descripcion = ""
                }
            )
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    items (listaClase){ clase->

                        CardClase(
                            funId = {id = it},
                            funNombre = { nombre = it },
                            funDescripcion = {descripcion = it},
                            clase = clase,
                            funTextButton = { textButton = it },
                            funIsEditando = { isEditando = it },
                            funBorrarClase = {borrarClase (it, listaClase)}
                        )
                    }
                }
            }
        }
    }
}
fun agregarClase(
    id: String,
    nombre: String,
    descripcion: String,
    listaClase: MutableList<Clase>) {
    listaClase.add(Clase(""+listaClase.size, nombre, descripcion))
}

fun editarClase(id: String,
                nombre: String,
                descripcion: String,
                listaClase: MutableList<Clase>) {
    listaClase.forEach { clase ->
        if (clase.id == id) {
            clase.nombre = nombre
            clase.descripcion = descripcion
        }
    }
}

fun borrarClase(id: String, listaClase: MutableList<Clase>) {
    listaClase.forEach { clase ->
        if (clase.id == id) {
            listaClase.remove(clase)
        }
    }
}