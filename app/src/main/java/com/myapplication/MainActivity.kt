package com.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.myapplication.adapter.CardAdapter
import com.myapplication.models.Card
import kotlinx.android.synthetic.main.fragment_home.*


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_category, R.id.navigation_write,
                R.id.navigation_chat, R.id.navigation_profile
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


    }



//        cardList.add(Item(getString(R.string.title01), getString(R.string.writer01), getString(R.string.price01), getDrawable(R.drawable.ic_launcher_foreground)!!))
//        cardList.add(Item(getString(R.string.title02), getString(R.string.writer02), getString(R.string.price02), getDrawable(R.drawable.ic_launcher_foreground)!!))
//        cardList.add(Item(getString(R.string.title03), getString(R.string.writer03), getString(R.string.price03), getDrawable(R.drawable.ic_launcher_foreground)!!))
//        cardList.add(Item(getString(R.string.title04), getString(R.string.writer04), getString(R.string.price04), getDrawable(R.drawable.ic_launcher_foreground)!!))
//        cardList.add(Item(getString(R.string.title05), getString(R.string.writer05), getString(R.string.price05), getDrawable(R.drawable.ic_launcher_foreground)!!))
//        cardList.add(Item(getString(R.string.title06), getString(R.string.writer06), getString(R.string.price06), getDrawable(R.drawable.ic_launcher_foreground)!!))
//        cardList.add(Item(getString(R.string.title07), getString(R.string.writer07), getString(R.string.price07), getDrawable(R.drawable.ic_launcher_foreground)!!))
//        cardList.add(Item(getString(R.string.title08), getString(R.string.writer08), getString(R.string.price08), getDrawable(R.drawable.ic_launcher_foreground)!!))
//        cardList.add(Item(getString(R.string.title09), getString(R.string.writer09), getString(R.string.price09), getDrawable(R.drawable.ic_launcher_foreground)!!))
//        cardList.add(Item(getString(R.string.title10), getString(R.string.writer10), getString(R.string.price10), getDrawable(R.drawable.ic_launcher_foreground)!!))

}
