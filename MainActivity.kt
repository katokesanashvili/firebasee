package com.example.homework6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        password = findViewById(R.id.password)
        button = findViewById(R.id.button)
        email = findViewById(R.id.email)


        button.setOnClickListener{
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email.text.toString(),password.text.toString())
                .addOnCompleteListener {task->
                    if (task.isSuccessful){
                        Toast.makeText(this,"წარმატებით შეიქმნა",Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}