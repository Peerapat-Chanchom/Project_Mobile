package com.example.project_mobile

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.project_mobile.databinding.ActivityMainBinding
import androidx.navigation.NavController
import androidx.navigation.NavDestination

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        // ตั้งค่า NavController
        navController = findNavController(R.id.nav_host_fragment_activity_main)

        // ตั้งค่า AppBarConfiguration
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )

        // ตั้งค่า ActionBar และ NavController
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // เพิ่ม listener เพื่อตรวจสอบ destination
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_login -> {
                    // ซ่อน BottomNavigationView เมื่ออยู่ในหน้า Login
                    navView.visibility = View.GONE
                }R.id.signUpFragment -> {
                // ซ่อน BottomNavigationView เมื่ออยู่ในหน้า Login
                navView.visibility = View.GONE
            }
                R.id.navigation_home -> {
                    // แสดง BottomNavigationView เมื่ออยู่ในหน้า Home
                    navView.visibility = View.VISIBLE
                }
                // เพิ่มเงื่อนไขอื่นๆ ตามต้องการ
                else -> {
                    // แสดง BottomNavigationView สำหรับหน้าอื่นๆ
                    navView.visibility = View.VISIBLE
                }
            }
        }
    }
}