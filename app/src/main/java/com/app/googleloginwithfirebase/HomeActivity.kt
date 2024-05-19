package com.app.googleloginwithfirebase

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.app.googleloginwithfirebase.databinding.ActivityHomeBinding
import com.app.googleloginwithfirebase.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)

            .requestIdToken(getString(R.string.Clientid)).requestEmail().build()

        auth = FirebaseAuth.getInstance()

        binding.Logout.setOnClickListener {

            var go =  GoogleSignIn.getClient(this,gso)
            go.signOut()
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        var email = intent.getStringExtra("email")
        var name = intent.getStringExtra("name")

        binding.UserName.text = name
        binding.UserEmail.text = email

    }
}