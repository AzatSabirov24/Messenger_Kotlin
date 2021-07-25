package com.azat_sabirov.messenger_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import com.azat_sabirov.messenger_kotlin.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createToolbar()
    }

    private fun createToolbar() {
        val toolbar: androidx.appcompat.widget.Toolbar = binding.toolbarRegister
        setSupportActionBar(toolbar)
        supportActionBar!!.title = getString(R.string.register)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        toolbar.setNavigationOnClickListener {
            val i = Intent(this@RegisterActivity, WelcomeActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}