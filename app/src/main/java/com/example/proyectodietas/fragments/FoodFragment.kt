package com.example.proyectodietas.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectodietas.R
import com.example.proyectodietas.adapters.AdapterClass
import com.example.proyectodietas.databinding.FragmentFoodBinding
import com.example.proyectodietas.modelo.entidades.DataClass

class FoodFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    lateinit var titleList: Array<String>

    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFoodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        titleList = arrayOf(
            "Malvina",
            "Lucien",
            "Erroll",
            "Rock",
            "Allard",
            "Tyrus",
            "Timothea",
            "Hayward",
            "Elissa",
            "Ainslie",
            "West",
            "Zora"
        )

        recyclerView = view.findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf<DataClass>()
        getData()
    }

    private fun getData() {
        for (i in titleList.indices) {
            val dataClass = DataClass(titleList[i])
            dataList.add(dataClass)
        }

        recyclerView.adapter = AdapterClass(dataList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}