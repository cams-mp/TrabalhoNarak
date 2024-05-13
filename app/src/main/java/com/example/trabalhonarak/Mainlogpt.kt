package com.example.trabalhonarak

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Mainlogpt : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mainlogpt)

        mAuth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        val email = "usuario@example.com"
        val password = "senhaSegura123"

        registerUser(email, password)
    }

    private fun registerUser(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "User registered successfully.", Toast.LENGTH_SHORT).show()
                    addUserToFirestore(email, password)
                } else {
                    Toast.makeText(this, "Authentication failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun addUserToFirestore(email: String, password: String) {
        val user = hashMapOf("email" to email, "password" to password)
        db.collection("login")
            .add(user)
            .addOnSuccessListener {
                Toast.makeText(this, "User added to Firestore.", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error adding user to Firestore: ${e.message}", Toast.LENGTH_LONG).show()
            }
    }
}
s