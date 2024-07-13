package com.dedova.prosoft24.hw2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dedova.prosoft24.R

const val EXTRA_TEXT_VIEW = "text_view"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn = findViewById<Button>(R.id.btn_to_second_activity)
        val textView = getString(R.string.text_activity)
        btn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra(EXTRA_TEXT_VIEW, textView)
            }
            startActivity(intent)
        }
    }
}