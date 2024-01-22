package com.example.proyectodietas.modelo.daos.daoAlimento

import com.example.proyectodietas.modelo.conexion.BDFicheroAlimentos
import com.example.proyectodietas.modelo.conexion.ConexionBD
import com.example.proyectodietas.modelo.daos.interfaces.InterfaceDaoAlimento
import modelo.entidades.Alimento

class DaoAlimentos: InterfaceDaoAlimento {

    lateinit var conexion: BDFicheroAlimentos

    fun createConexion(con: ConexionBD) {
        conexion = con as BDFicheroAlimentos
    }

    override fun addAlimento(al: Alimento) {
        // Asegúrate de que 'conexion' esté inicializada antes de usarla
        if (!::conexion.isInitialized) {
            throw IllegalStateException("La propiedad conexion no ha sido inicializada.")
        }

        val lista = conexion.leer()
        lista.add(al)
        conexion.escribir(lista)
    }

    override fun getAlimentos(): MutableList<Alimento> {
        // Asegúrate de que 'conexion' esté inicializada antes de usarla
        if (!::conexion.isInitialized) {
            throw IllegalStateException("La propiedad conexion no ha sido inicializada.")
        }
        return conexion.leer()
    }

    override fun getAlimentos(tipo: String): MutableList<Alimento> {
        // Asegúrate de que 'conexion' esté inicializada antes de usarla
        if (!::conexion.isInitialized) {
            throw IllegalStateException("La propiedad conexion no ha sido inicializada.")
        }
        val lista = conexion.leer()
        return lista.filter { it.tipo == tipo } as MutableList<Alimento>
    }

    /*override fun getAlimento(al: Alimento): Alimento {

    }

    override fun updateAlimento(al: Alimento) {

    }

    override fun deleteAlimento(al: Alimento) {

    }*/
}