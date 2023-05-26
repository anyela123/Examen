package com.example.examen.ui.Planta

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Planta {
    @PrimaryKey()
    val id: String?
    @ColumnInfo
    val nombre: String?
    @ColumnInfo
    val id_clase: Int
    @ColumnInfo
    val id_usuario: Int
    @ColumnInfo
    val beneficios: String?
    @ColumnInfo
    val enfermedad: String?

    constructor(id: String?, nombre: String?, id_clase: Int, id_usuario: Int, beneficios: String?, enfermedad: String?
    ) {
        this.id = id
        this.nombre = nombre
        this.id_clase = id_clase
        this.id_usuario = id_usuario
        this.beneficios = beneficios
        this.enfermedad = enfermedad
    }
}