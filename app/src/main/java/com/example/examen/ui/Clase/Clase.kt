package com.example.examen.ui.Clase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Clase(
    @PrimaryKey val id: Int,
    @ColumnInfo val nombre: String?,
    @ColumnInfo val lastName: String?
)