package com.example.proyectodietas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectodietas.adapters.AdapterClass
import com.example.proyectodietas.databinding.ActivityMainBinding
import com.example.proyectodietas.fragments.FoodFragment
import com.example.proyectodietas.fragments.HomeFragment
import com.example.proyectodietas.fragments.IngredientesFragment
import com.example.proyectodietas.fragments.MenuFragment
import com.example.proyectodietas.fragments.RecetaFragment
import com.example.proyectodietas.modelo.entidades.DataClass
import com.google.android.material.navigation.NavigationView
import modelo.entidades.Alimento

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding: ActivityMainBinding

    /*private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    lateinit var titleList: Array<String>*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.nav_open, R.string.nav_close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navigationDrawer.setNavigationItemSelectedListener(this)

        binding.bottomNavigation.background=null
        binding.bottomNavigation.setOnItemSelectedListener{
            item->when(item.itemId){
            R.id.bottom_home->openFragment(HomeFragment())
            R.id.bottom_food->openFragment(FoodFragment())
            R.id.bottom_menu->openFragment(MenuFragment())
            R.id.bottom_ingredientes->openFragment(IngredientesFragment())
            R.id.bottom_receta->openFragment(RecetaFragment())
            }
            true
        }
        fragmentManager= supportFragmentManager
        openFragment(HomeFragment())

        /*binding.fab.setOnClickListener{
            Toast.makeText(this, "Nuevo", Toast.LENGTH_LONG).show()
        }*/

        /*titleList = arrayOf(
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
                "Zora")

        recyclerView=findViewById(R.id.recycler)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        dataList= arrayListOf<DataClass>()
        getData()*/

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home->openFragment(HomeFragment())
            R.id.nav_food->openFragment(FoodFragment())
            R.id.nav_menu->openFragment(MenuFragment())
            R.id.nav_ingrediente->openFragment(IngredientesFragment())
            R.id.nav_receta->openFragment(RecetaFragment())
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)

        }else{
            super.onBackPressed()
        }
    }

    private fun openFragment(fragment: Fragment){
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }

    /*private fun getData(){
        for (i in titleList.indices){
            val dataClass=DataClass(titleList[i])
            dataList.add(dataClass)
        }

        recyclerView.adapter=AdapterClass(dataList)
    }*/
}