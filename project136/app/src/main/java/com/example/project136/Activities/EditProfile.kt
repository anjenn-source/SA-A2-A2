package com.example.project136.Activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project136.R

class EditProfile : AppCompatActivity() {

    private lateinit var updateUsernameEditText: EditText
    private lateinit var updatePasswordEditText: EditText
    private lateinit var changeButton: Button
    private lateinit var logoutButton: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_profile)

        updateUsernameEditText = findViewById(R.id.updateusername)
        updatePasswordEditText = findViewById(R.id.updatepassword)
        changeButton = findViewById(R.id.changeButton)
        logoutButton = findViewById(R.id.logout_btn)

        changeButton.setOnClickListener {
            updateProfile()
        }

        // Set OnClickListener for the "Logout" text view
        logoutButton.setOnClickListener {
            logout()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun updateProfile() {
        val updatedUsername = updateUsernameEditText.text.toString()
        val updatedPassword = updatePasswordEditText.text.toString()

        val sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("username", updatedUsername)
        editor.putString("password", updatedPassword)
        editor.apply()

        Toast.makeText(this, "Profile Updated Successfully!", Toast.LENGTH_SHORT).show()
    }

    private fun logout() {

        startActivity(Intent(this, Login::class.java))
        finish()
    }
}
