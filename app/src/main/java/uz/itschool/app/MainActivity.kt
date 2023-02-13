package uz.itschool.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_next.setOnClickListener{
            if(input.text.toString().isEmpty()){
                Toast.makeText(this, "Enter your name", Toast.LENGTH_SHORT).show()
            }
            else{
                var intent = Intent(this,Select_cardviews::class.java)
                intent.putExtra("${setData.name}", input.text.toString())
                startActivity(intent)
                finish()
            }
        }
        sing_up_button.setOnClickListener {
            var intent=Intent(this, Sign_in_registration::class.java)
            startActivity(intent)
        }

    }
}