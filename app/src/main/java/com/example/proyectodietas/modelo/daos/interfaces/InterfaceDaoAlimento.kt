package com.example.proyectodietas.modelo.daos.interfaces

import com.example.proyectodietas.modelo.conexion.ConexionBD
import modelo.entidades.Alimento

interface InterfaceDaoAlimento {

    fun addAlimento(al: Alimento)
    fun getAlimentos():MutableList<Alimento>
    fun getAlimentos(tipo:String):MutableList<Alimento>
    /*fun getAlimento(al: Alimento): Alimento
    fun updateAlimento(al: Alimento)
    fun deleteAlimento(al: Alimento)*/
}