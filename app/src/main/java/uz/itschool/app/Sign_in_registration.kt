package uz.itschool.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_in_registration.*

class Sign_in_registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_registration)

        back_to_button.setOnClickListener {
            var intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        register.setOnClickListener {
            Toast.makeText(this,"Succesfully registered", Toast.LENGTH_SHORT).show()
            var intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}