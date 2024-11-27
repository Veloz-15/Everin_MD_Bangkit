package com.dicoding.myapplication.view.Main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dicoding.myapplication.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    loadFragment(HomeFragment())
                    true
                }

                R.id.navigation_add -> {
                    loadFragment(AddFragment())
                    true
                }
                R.id.navigation_status -> {
                    loadFragment(StatusFragment())
                    true
                }

                R.id.navigation_profile -> {
                    loadFragment(ProfileFragment())
                    true
                }

                else -> false
            }
        }
        if (savedInstanceState == null) {
            loadFragment(HomeFragment()) // Default fragment
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}