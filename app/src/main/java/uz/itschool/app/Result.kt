package uz.itschool.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_math.*
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.activity_sign_in_registration.*

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val user_name=intent.getStringExtra(setData.name)

        val score=intent.getStringExtra(setData.score)
        val totalQuestion=intent.getStringExtra("total size")


        congratulation_text.text="Congratulations ${user_name} !!"
        Score.text="${score} / ${totalQuestion}"
        button.setOnClickListener {
            startActivity(Intent(this,Select_cardviews::class.java))
            finish()
        }
        b.setOnClickListener {
                var intent=Intent(this, MainActivity::class.java)
                startActivity(intent)
        }
    }
}