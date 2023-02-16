package uz.itschool.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var sharedpreferences = getSharedPreferences("reg", MODE_PRIVATE)
        var edit = sharedpreferences.edit()
        var gson = Gson()
        var userList = mutableListOf<User>()
        var type = object : TypeToken<List<User>>() {}.type


        button_next.setOnClickListener{
            var users = sharedpreferences.getString("users", "")
            var pos = false

            if (users == "") {
                Toast.makeText(this, "Enter empty blanks!", Toast.LENGTH_SHORT).show()

            } else {
                userList = gson.fromJson(users, type)
                for (i in userList) {
                    if (i.name == input.text.toString() && i.passwpord == editTextTextPassword2.text.toString()) {
                        pos = true
                        break
                    } else {
                        pos = false
                    }
                }

                if (pos == true) {
                    var intent = Intent(this, Select_cardviews::class.java)
                    intent.putExtra("${setData.name}", input.text.toString())
                    intent.putExtra("username_for_Score",input.text.toString())
                    intent.putExtra("user_password_for_Score",editTextTextPassword2.text.toString())
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "You did not registered yet!", Toast.LENGTH_SHORT).show()
                }
            }
            /*if(input.text.toString().isEmpty()){
                Toast.makeText(this, "Enter your name", Toast.LENGTH_SHORT).show()
            }
            else{
                var intent = Intent(this,MainActivity2::class.java)
                intent.putExtra("${setData.name}", input.text.toString())
                intent.putExtra("username_for_Score",input.text.toString())
                intent.putExtra("user_password_for_Score",input.text.toString())
                startActivity(intent)
                finish()*/
        }
        sing_up_button.setOnClickListener {
            var intent = Intent(this, Sign_in_registration::class.java)
            startActivity(intent)
        }

    }
}