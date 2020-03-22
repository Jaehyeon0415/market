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
import com.google.firebase.database.*
import com.myapplication.R
import com.myapplication.models.Card
import kotlinx.android.synthetic.main.activity_write_sell_detail.*


class WriteSellDetailActivity : AppCompatActivity() {

    private var database: DatabaseReference = FirebaseDatabase.getInstance().reference

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
            val myRef = database.child("message")
            myRef.push().setValue("123123123")
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
                    write_sell_category_text.text = data?.getStringExtra("category").toString()
                }
            }
        }
    }
}
