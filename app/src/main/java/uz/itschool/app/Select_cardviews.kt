package uz.itschool.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_select_cardviews.*
import kotlinx.android.synthetic.main.activity_select_cardviews.back_to_button

class Select_cardviews : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_cardviews)

        physics_questions.setOnClickListener {
            var intent= Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        math_questions.setOnClickListener {
            var intent= Intent(this, Math_quize::class.java)
            startActivity(intent)
        }
        math_problems.setOnClickListener {
            var intent= Intent(this, MAthActivity::class.java)
            startActivity(intent)
        }

        physics_problems.setOnClickListener {
            var intent= Intent(this, Physics_problems_Activity::class.java)
            startActivity(intent)
        }
        back_to_button.setOnClickListener {
            var intent=Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}