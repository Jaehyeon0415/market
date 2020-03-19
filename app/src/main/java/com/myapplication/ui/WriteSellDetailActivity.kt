package com.myapplication.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.myapplication.R
import kotlinx.android.synthetic.main.activity_write_sell_detail.*


class WriteSellDetailActivity : AppCompatActivity() {

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
        menuInflater.inflate(R.menu.write_done, menu)
        return true
    }

    // 툴바 옵션 반응
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> {
            finish()
            true
        }
        R.id.write_done -> {
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
                    write_sell_category_text.text = data!!.getStringExtra("category").toString()
                }
            }
        }
    }
}
