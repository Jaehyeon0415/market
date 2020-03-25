package com.myapplication.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.myapplication.R
import com.myapplication.models.Card
import kotlinx.android.synthetic.main.activity_write_sell_detail.*


class WriteSellDetailActivity : AppCompatActivity() {


    private var database: DatabaseReference = FirebaseDatabase.getInstance().reference

    private val user = FirebaseAuth.getInstance().currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_sell_detail)

        write_sell_category.setOnClickListener {
            val intent = Intent(this, WriteSellCategoryDetail:: class.java)
            startActivityForResult(intent, 100);
        }

        // 툴바 사용하기
        val toolbar = findViewById<Toolbar>(R.id.write_sell_toolbar)
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

    // 툴바 옵션 반응
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> {
            finish()
            true
        }
        R.id.write_done -> {
            addCard()
            Toast.makeText(this, "게시물이 등록되었어요!", Toast.LENGTH_LONG).show()
            finish()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    // 카테고리 데이터 가져오기
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                100 -> {
                    write_sell_category_text.visibility = View.VISIBLE
                    write_sell_category_text.text = data?.getStringExtra("category")
//                    when (value) {
//                        "digital" -> {
//                            write_sell_category_text.text = getString(R.string.category01)
//                        }
//                        "funiture" -> {
//                            write_sell_category_text.text = getString(R.string.category02)
//                        }
//                        "child" -> {
//                            write_sell_category_text.text = getString(R.string.category03)
//                        }
//                        "clothes" -> {
//                            write_sell_category_text.text = getString(R.string.category04)
//                        }
//                        "life" -> {
//                            write_sell_category_text.text = getString(R.string.category05)
//                        }
//                        "beauty" -> {
//                            write_sell_category_text.text = getString(R.string.category06)
//                        }
//                        "sports" -> {
//                            write_sell_category_text.text = getString(R.string.category07)
//                        }
//                        "game" -> {
//                            write_sell_category_text.text = getString(R.string.category08)
//                        }
//                        "book" -> {
//                            write_sell_category_text.text = getString(R.string.category09)
//                        }
//                        "pet" -> {
//                            write_sell_category_text.text = getString(R.string.category10)
//                        }
//                        "etc" -> {
//                            write_sell_category_text.text = getString(R.string.category11)
//                        }
//                        "buy" -> {
//                            write_sell_category_text.text = getString(R.string.category12)
//                        }
//                    }
                }
            }
        }
    }

    // 게시물 등록
    private fun addCard() {
        val uid = user?.uid
        val myRef = database.child("card").push()

        myRef.child("title").setValue(write_sell_textTitle.text.toString())
        myRef.child("category").setValue(write_sell_category_text.text)
        if (user != null) {
            myRef.child("writer").setValue(user.displayName.toString())
        }
        myRef.child("price").setValue(write_sell_price.text.toString())
        //myRef?.child("image")?.setValue()
        myRef.child("context").setValue(write_sell_context.text.toString())
        myRef.child("option").setValue("false")
        myRef.child("id").setValue(uid.toString())
    }
}
