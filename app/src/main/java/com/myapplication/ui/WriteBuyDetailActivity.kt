package com.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.myapplication.R
import kotlinx.android.synthetic.main.activity_write_buy_detail.*

class WriteBuyDetailActivity : AppCompatActivity() {

    private val database: DatabaseReference = FirebaseDatabase.getInstance().reference
    private val user = FirebaseAuth.getInstance().currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_buy_detail)

        val toolbar = findViewById<Toolbar>(R.id.write_buy_toolbar)
        setSupportActionBar(toolbar)
        val ab = supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)
        ab.setDisplayHomeAsUpEnabled(true)
    }

    // 툴바 옵션 생성
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.write, menu)
        return true
    }

    // 툴바에 뒤로가기 버튼
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> {
            finish()
            true
        }
        R.id.write_done -> {
            addCard()
            Toast.makeText(this, "게시물이 등록되었어요!", Toast.LENGTH_SHORT).show()
            finish()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    // 게시물 등록
    private fun addCard() {
        val uid = user?.uid
        val myRef = database.child("card").push()
        val key = myRef.key
        val userRef = database.child("users").child(uid.toString())

        myRef.child("title").setValue(write_buy_textTitle.text.toString())
        myRef.child("category").setValue("buy")
        myRef.child("writer").setValue(user?.displayName.toString())
        myRef.child("price").setValue(write_buy_price.text.toString())
        //myRef.child("image")?.setValue()
        myRef.child("context").setValue(write_buy_context.text.toString())
        myRef.child("option").setValue("false")
        myRef.child("uid").setValue(uid.toString())
        myRef.child("id").setValue(key)

        userRef.child("myCard").child(key.toString()).child("option").setValue("false")
    }
}
