package com.example.examen.ui.Planta

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Planta (
    @PrimaryKey val id: Int,
    @ColumnInfo val nombre: String?,
    @ColumnInfo val id_clase:Int,
    @ColumnInfo val id_usuario: Int,
    @ColumnInfo val beneficios: String?,
    @ColumnInfo val enfermedad: String?
)