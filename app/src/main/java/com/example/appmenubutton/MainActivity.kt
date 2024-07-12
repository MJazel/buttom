package com.example.appmenubutton

import ListFragment
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // init
        init()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun init() {
        bottomNavigationView = findViewById(R.id.btnNavegator)

        changeFrame(HomeFragment())
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.btnHome -> {
                    changeFrame(HomeFragment())
                    true
                }
                R.id.btnLista -> {
                    val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
                    setSupportActionBar(toolbar)
                    changeFrame(ListFragment())
                    true
                }
                R.id.btnDb -> {
                    val dbFragment = DbFragment()
                    changeFrame(dbFragment)
                    true
                }
                R.id.btnAcerca -> {
                    changeFrame(AboutFragment())
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    fun changeFrame(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frmContenedor, fragment).commit()
    }

    // Métodos para abrir los enlaces
    fun openFacebook(view: View) {
        val url = "https://www.facebook.com/merari.urias"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    fun openTwitter(view: View) {
        val url = "https://x.com/JazelMerari"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    fun openInstagram(view: View) {
        val url = "https://www.instagram.com/m_jazel9/"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    fun openLinkedIn(view: View) {
        val url = "https://www.linkedin.com/in/merari-jazel-osuna-bueno-014659308/"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}

