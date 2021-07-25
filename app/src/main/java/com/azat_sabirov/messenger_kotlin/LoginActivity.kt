package com.azat_sabirov.messenger_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.azat_sabirov.messenger_kotlin.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createToolbar()
    }

    private fun createToolbar() {
        val toolbar : Toolbar = binding.toolbarLogin
        setSupportActionBar(toolbar)
        supportActionBar!!.title = getString(R.string.enter_toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            val i = Intent(this, WelcomeActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}