package com.azat_sabirov.messenger_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.azat_sabirov.messenger_kotlin.databinding.ActivityWelcomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding
    var fireBaseUser: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBtns()
    }



    override fun onStart() {
        super.onStart()

        fireBaseUser = FirebaseAuth.getInstance().currentUser
        if (fireBaseUser != null){
            val intent = Intent(this@WelcomeActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun initBtns() {
        binding.apply {
            welcomeLoginBtn.setOnClickListener {
                val intent = Intent(this@WelcomeActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }

            welcomeRegisterBtn.setOnClickListener {
                val intent = Intent(this@WelcomeActivity, RegisterActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}