package com.example.examen.ui.Planta

import androidx.room.*
import com.example.examen.ui.Clase.Clase

@Dao
interface PlantaDao {
    @Query("SELECT * FROM Planta")
    fun getAllPlanta(): List<Planta>

    @Query("SELECT * FROM Planta WHERE id IN (:plantaId)")
    fun getPlanta(plantaId: Int): Planta

    @Query("SELECT * FROM Planta WHERE id_clase IN (:claseId)")
    fun getPlantaClase(claseId: Int): List<Planta?>

    @Query("SELECT * FROM Planta WHERE id_usuario IN (:usuarioId)")
    fun getPlantaUsuario(usuarioId: Int): List<Planta?>

    @Insert
    fun addPlanta(planta: Planta)

    @Delete
    fun deletePlanta(planta: Planta)

    @Update
    fun updatePlanta( planta: Planta)
}