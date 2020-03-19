package com.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.myapplication.R
import com.myapplication.adapter.CardAdapter
import com.myapplication.models.Card
import com.myapplication.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_category_detail.*

class CategoryDetailActivity : AppCompatActivity() {

    val list = ArrayList<Card>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_detail)

        val filter = intent.getStringExtra("category")

        for (data in HomeFragment.cardList){
            if(data.category == filter){
                list.add(data)
            }
        }

        recyclerView.adapter = CardAdapter(this,list)

        val lm = LinearLayoutManager(this)
        recyclerView.layoutManager = lm
        recyclerView.setHasFixedSize(true)

        // 툴바 사용하기
        val toolbar = findViewById<Toolbar>(R.id.card_detail_toolbar)
        setSupportActionBar(toolbar)
        val ab = supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)
        ab.setDisplayHomeAsUpEnabled(true)
    }

    // 툴바에 뒤로가기 버튼
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> {
            finish()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}
