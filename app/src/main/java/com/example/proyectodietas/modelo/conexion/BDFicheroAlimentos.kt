package com.example.proyectodietas.modelo.conexion

import modelo.entidades.Alimento
import android.content.Context
import java.io.*


class BDFicheroAlimentos(private val context: Context): ConexionBD() {

    val nombre="alimentos.dat"

    fun escribir(lista:MutableList<Alimento>,nombreArchivo: String=nombre) {
        try {
            val fileOutputStream = context.openFileOutput(nombreArchivo, Context.MODE_PRIVATE)
            val objectOutputStream = ObjectOutputStream(fileOutputStream)
            objectOutputStream.writeObject(lista)
            objectOutputStream.close()
            fileOutputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun leer():MutableList<Alimento> {
        var lista: MutableList<Alimento>? = null
        try {
            val fileInputStream = context.openFileInput(nombre)
            val objectInputStream = ObjectInputStream(fileInputStream)
            lista = objectInputStream.readObject() as MutableList<Alimento>
            objectInputStream.close()
            fileInputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
        return lista ?: mutableListOf()
    }

    override fun borrarArchivos() {
        val archivo = context.getFileStreamPath(nombre)
        if (archivo.exists()) {
            archivo.delete()
        }
    }
}


