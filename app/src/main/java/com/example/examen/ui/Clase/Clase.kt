package com.example.examen.ui.Clase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Clase {
    @PrimaryKey()
    val id: String?
    @ColumnInfo
    var nombre: String?
    @ColumnInfo
    var descripcion: String?

    constructor(id: String?, nombre: String?, descripcion: String?) {
        this.id = id
        this.nombre = nombre
        this.descripcion = descripcion
    }

}