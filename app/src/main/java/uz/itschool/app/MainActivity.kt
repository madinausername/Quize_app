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


        var sharedpreferences=getSharedPreferences("reg", MODE_PRIVATE)
        var edit=sharedpreferences.edit()
        var gson= Gson()
        var userList= mutableListOf<User>()
        var type = object : TypeToken<List<User>>(){}.type

        button_next.setOnClickListener {
            var users=sharedpreferences.getString("users","")
            if(users==""){
                userList= mutableListOf()
                Log.d("TAG", "str")
            }
            else{
                userList=gson.fromJson(users,type)

            }


            for(i in userList){
                if(i.name==input.text.toString() && i.passwpord==editTextTextPassword2.text.toString()){
                    userList.add(User(input.text.toString(), editTextTextPassword2.text.toString()))
                }
                else{
                    Toast.makeText(this, "You did not registered yet!", Toast.LENGTH_SHORT).show()

                }
            }
            var str=gson.toJson(userList)

            edit.putString("users",str).commit()
        }



    }
}