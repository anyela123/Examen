package com.example.examen.ui.Usuario

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Usuario (
    @PrimaryKey val id: Int,
    @ColumnInfo val nombre: String?,
    @ColumnInfo val usuario: String?,
    @ColumnInfo val contrasenia: String?
)