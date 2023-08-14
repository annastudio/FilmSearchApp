package com.vodoleylan.studio

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.vodoleylan.studio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        menuButtons()
    }

    private fun menuButtons() {
        binding.buttonSettings.setOnClickListener {
            Toast.makeText(this, "Меню", Toast.LENGTH_SHORT).show()
        }
    }
}