package com.example.proyectodietas.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectodietas.R
import com.example.proyectodietas.modelo.entidades.DataClass
import modelo.entidades.Alimento

/*class AdapterClass(private val dataList: ArrayList<DataClass>): RecyclerView.Adapter<AdapterClass.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val  itemView= LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem= dataList[position]
        holder.nombre.text=currentItem.nombre
    }

    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {
        val nombre:TextView =itemView.findViewById(R.id.title)
    }
}*/


class AdapterClass(private val alimento: ArrayList<Alimento>): RecyclerView.Adapter<AdapterClass.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val  itemView= LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
        return alimento.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem= alimento[position]
        holder.nombre.text=currentItem.nombre
        holder.tipo.text=currentItem.tipo
        holder.grHC.text=currentItem.grHC.toString()
        holder.grLip.text=currentItem.grLip.toString()
        holder.grPro.text=currentItem.grPro.toString()
    }

    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {
        val nombre:TextView =itemView.findViewById(R.id.title)
        val tipo:TextView=itemView.findViewById(R.id.tipo)
        val grHC:TextView=itemView.findViewById(R.id.grHC)
        val grLip:TextView=itemView.findViewById(R.id.grLip)
        val grPro:TextView=itemView.findViewById(R.id.grPro)
    }
}