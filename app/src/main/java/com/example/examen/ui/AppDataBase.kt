package com.example.examen.ui

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.examen.ui.Clase.Clase
import com.example.examen.ui.Clase.ClaseDao
import com.example.examen.ui.Planta.Planta
import com.example.examen.ui.Planta.PlantaDao
import com.example.examen.ui.Usuario.Usuario
import com.example.examen.ui.Usuario.UsuarioDao

@Database(entities = [Usuario::class, Planta::class, Clase::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
    abstract fun plantaDao(): PlantaDao
    abstract fun claseDao(): ClaseDao
}