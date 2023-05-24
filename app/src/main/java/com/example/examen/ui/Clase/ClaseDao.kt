package com.example.examen.ui.Clase

import androidx.room.*
import com.example.examen.ui.Planta.Planta

@Dao
interface ClaseDao {
    @Query("SELECT * FROM Clase")
    fun getAllClase(): List<Clase>

    @Query("SELECT * FROM Clase WHERE id IN (:claseId)")
    fun getClase(claseId: Int): Clase

    @Insert
    fun addClase(clase: Clase)

    @Delete
    fun deleteClase(clase: Clase)

    @Update
    fun updateClase( clase: Clase)
}