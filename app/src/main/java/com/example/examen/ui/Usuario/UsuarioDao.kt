package com.example.examen.ui.Usuario

import androidx.room.*
import com.example.examen.ui.Planta.Planta

@Dao
interface UsuarioDao {
    @Query("SELECT * FROM Usuario")
    fun getAllUsuario(): List<Usuario>

    @Query("SELECT * FROM Usuario WHERE id=:usuarioId")
    fun getUsuario(usuarioId: Int): Usuario

    @Insert
    fun addUsuario(usuario: Usuario)

    @Delete
    fun deleteUsuario(usuario:Usuario)

    @Update
    fun updateUsuario(usuario:Usuario)

}