package com.everymarket

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*


class SignUpActivity: AppCompatActivity() {

    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        auth_user_email.setOnClickListener {
            registerNewUser()
        }
    }

    private fun registerNewUser() {

        auth_progress.visibility = View.VISIBLE

        val email = auth_user_email.text.toString()

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "이메일을 작성해 주세요!", Toast.LENGTH_SHORT).show()
            return
        }

        mAuth.createUserWithEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(applicationContext, "인증에 성공했습니다!", Toast.LENGTH_LONG).show()
                    auth_progress.visibility = View.GONE
                    startActivity(Intent(this, LoginActivity::class.java))
                } else {
                    Toast.makeText(
                        applicationContext, "인증에 실패하였습니다. 다시 시도해 주세요", Toast.LENGTH_LONG).show()
                    auth_progress.visibility = View.GONE
                }
            }

    }
}