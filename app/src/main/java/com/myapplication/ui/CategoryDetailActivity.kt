package com.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.myapplication.R
import com.myapplication.adapter.CardAdapter
import com.myapplication.models.Card
import com.myapplication.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_category_detail.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class CategoryDetailActivity : AppCompatActivity() {

    val list = ArrayList<Card>()

    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var myRef = database.reference.child("card")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_detail)

        // 툴바 사용하기
        val toolbar = findViewById<Toolbar>(R.id.card_detail_toolbar)
        setSupportActionBar(toolbar)
        val ab = supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)
        ab.setDisplayHomeAsUpEnabled(true)

        Log.d("categoryList", intent.getStringExtra("category"))
        when(intent.getStringExtra("category")) {
            "디지털/가전" -> {

//                val filter = "digital"
//                myRef.addValueEventListener(object : ValueEventListener {
//                    override fun onDataChange(dataSnapshot: DataSnapshot) {
//
//                        for(dataSnapshot1 in dataSnapshot.children){
//                            val data = dataSnapshot1.child("category").getValue(Card::class.java)
//                            Log.d("equals", data.toString())
//
//                            val value = dataSnapshot1.getValue(Card::class.java)
//                            Log.d("CardValue", value.toString())
//                            if (value != null) {
//                                if (filter.equals(dataSnapshot1.child("category").getValue(Card::class.java))) {
//                                    list.add(value)
//                                }
//
//                                recyclerView.adapter?.notifyDataSetChanged()
//                            }
//                        }
//                    }
//
//                    override fun onCancelled(databaseError: DatabaseError) {}
//                })
            }
            "가구/인테리어" -> {
                val filter = "funiture"
                for (data in HomeFragment.cardList){
                    if(data.category == filter){
                        list.add(data)
                    }
                }

            }
            "유아동/유아도서" -> {
                val filter = "child"
                for (data in HomeFragment.cardList){
                    if(data.category == filter){
                        list.add(data)
                    }
                }
            }
            "의류/잡화" -> {
                val filter = "clothes"
                for (data in HomeFragment.cardList){
                    if(data.category == filter){
                        list.add(data)
                    }
                }
            }
            "생활/가공식품" -> {
                val filter = "life"
                for (data in HomeFragment.cardList){
                    if(data.category == filter){
                        list.add(data)
                    }
                }
            }
            "뷰티/미용" -> {
                val filter = "beauty"
                for (data in HomeFragment.cardList){
                    if(data.category == filter){
                        list.add(data)
                    }
                }
            }
            "스포츠/레저" -> {
                val filter = "sports"
                for (data in HomeFragment.cardList){
                    if(data.category == filter){
                        list.add(data)
                    }
                }
            }
            "게임/취미" -> {
                val filter = "game"
                for (data in HomeFragment.cardList){
                    if(data.category == filter){
                        list.add(data)
                    }
                }
            }
            "도서/티켓/음반" -> {
                val filter = "book"
                for (data in HomeFragment.cardList){
                    if(data.category == filter){
                        list.add(data)
                    }
                }
            }
            "반려동물용품" -> {
                val filter = "pet"
                for (data in HomeFragment.cardList){
                    if(data.category == filter){
                        list.add(data)
                    }
                }
            }
            "기타 중고용품" -> {
                val filter = "etc"
                for (data in HomeFragment.cardList){
                    if(data.category == filter){
                        list.add(data)
                    }
                }
            }
        }

        recyclerView.adapter = CardAdapter(this,list)

        val lm = LinearLayoutManager(this)
        recyclerView.layoutManager = lm
        recyclerView.setHasFixedSize(true)

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
