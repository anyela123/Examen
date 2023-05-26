package com.example.examen.ui.Usuario

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.reflect.Constructor

@Entity
class Usuario {

    @PrimaryKey()
    val id: String?
    @ColumnInfo
    val nombre: String?
    @ColumnInfo
    val usuario: String?
    @ColumnInfo
    val contrasenia: String?

    constructor (id: String?, nombre: String?, usuario: String?, contrasenia: String?) {
        this.id = id
        this.nombre = nombre
        this.usuario = usuario
        this.contrasenia = contrasenia
    }
}