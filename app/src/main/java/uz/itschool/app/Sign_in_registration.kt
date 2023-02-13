package uz.itschool.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_sign_in_registration.*
import uz.itschool.app.setData.name

class Sign_in_registration : AppCompatActivity() {
    var pos:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_registration)

        back_to_button.setOnClickListener {
            var intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        var sharedpreferences=getSharedPreferences("reg", MODE_PRIVATE)
        var edit=sharedpreferences.edit()
        var gson=Gson()
        var userList= mutableListOf<User>()
        var type = object : TypeToken<List<User>>(){}.type
        /*register.setOnClickListener {
            var users=sharedpreferences.getString("users","")
            userList=gson.fromJson(users,type)
        }*/
        register.setOnClickListener {
            var users=sharedpreferences.getString("users","")
            if(users==""){
                userList= mutableListOf()

            }
            else{
                userList=gson.fromJson(users,type)
                Log.d("TAG", users.toString())
            }

            for (i in userList) {
                if (i.name == editTextTextPersonName_username.text.toString() && i.passwpord == editTextTextPassword_password.text.toString()) {
                    Toast.makeText(this, "Please change inputs!", Toast.LENGTH_SHORT).show()
//                    var intent = Intent(this, MainActivity::class.java)
//                    startActivity(intent)
                    pos = false
                } else {
                    userList.add(
                        User(
                            editTextTextPersonName_username.text.toString(),
                            editTextTextPassword_password.text.toString()
                        )
                    )
                    var str = gson.toJson(userList)
                    edit.putString("users", str).commit()
                    Toast.makeText(this, "Succesfully registered", Toast.LENGTH_SHORT).show()
                    pos = true
                    var intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                }
            }

            pos=false
        }
    }
}