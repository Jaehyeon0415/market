package com.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
import kotlinx.android.synthetic.main.activity_category_detail.*

class CategoryDetailActivity : AppCompatActivity() {

    val list = ArrayList<Card>()

    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var myRef = database.reference.child("card")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_detail)

        // 툴바 사용하기
        val toolbar = findViewById<Toolbar>(R.id.category_detail_toolbar)
        setSupportActionBar(toolbar)
        val ab = supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)
        ab.setDisplayHomeAsUpEnabled(true)

        // 필터 이용하여 카테고리별로 나오게하기
        when(intent.getStringExtra("category")) {
            "digital" -> {
                // 툴바 타이틀 설정
                category_detail_toolbar_title.text = getString(R.string.category01)
                val filter = "digital"
                myRef.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for(dataSnapshot1 in dataSnapshot.children){

                            val value = dataSnapshot1.getValue(Card::class.java)
                            if (value != null) {
                                if (filter == dataSnapshot1.child("category").value) {
                                    list.add(value)
                                }
                                recyclerView.adapter?.notifyDataSetChanged()
                            }
                        }
                    }
                    override fun onCancelled(databaseError: DatabaseError) {}
                })
            }
            "funiture" -> {
                // 툴바 타이틀 설정
                category_detail_toolbar_title.text = getString(R.string.category02)
                val filter = "funiture"
                myRef.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for(dataSnapshot1 in dataSnapshot.children){
                            val value = dataSnapshot1.getValue(Card::class.java)

                            if (value != null) {
                                if (filter == dataSnapshot1.child("category").value) {
                                    list.add(value)
                                }
                                recyclerView.adapter?.notifyDataSetChanged()
                            }
                        }
                    }
                    override fun onCancelled(databaseError: DatabaseError) {}
                })
            }
            "clothes" -> {
                // 툴바 타이틀 설정
                category_detail_toolbar_title.text = getString(R.string.category04)
                val filter = "clothes"
                myRef.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for(dataSnapshot1 in dataSnapshot.children){
                            val value = dataSnapshot1.getValue(Card::class.java)

                            if (value != null) {
                                if (filter == dataSnapshot1.child("category").value) {
                                    list.add(value)
                                }
                                recyclerView.adapter?.notifyDataSetChanged()
                            }
                        }
                    }
                    override fun onCancelled(databaseError: DatabaseError) {}
                })
            }
            "life" -> {
                // 툴바 타이틀 설정
                category_detail_toolbar_title.text = getString(R.string.category05)
                val filter = "life"
                myRef.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for(dataSnapshot1 in dataSnapshot.children){
                            val value = dataSnapshot1.getValue(Card::class.java)

                            if (value != null) {
                                if (filter == dataSnapshot1.child("category").value) {
                                    list.add(value)
                                }
                                recyclerView.adapter?.notifyDataSetChanged()
                            }
                        }
                    }
                    override fun onCancelled(databaseError: DatabaseError) {}
                })
            }
            "beauty" -> {
                // 툴바 타이틀 설정
                category_detail_toolbar_title.text = getString(R.string.category06)
                val filter = "beauty"
                myRef.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for(dataSnapshot1 in dataSnapshot.children){
                            val value = dataSnapshot1.getValue(Card::class.java)

                            if (value != null) {
                                if (filter == dataSnapshot1.child("category").value) {
                                    list.add(value)
                                }
                                recyclerView.adapter?.notifyDataSetChanged()
                            }
                        }
                    }
                    override fun onCancelled(databaseError: DatabaseError) {}
                })
            }
            "sports" -> {
                // 툴바 타이틀 설정
                category_detail_toolbar_title.text = getString(R.string.category07)
                val filter = "sports"
                myRef.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for(dataSnapshot1 in dataSnapshot.children){
                            val value = dataSnapshot1.getValue(Card::class.java)

                            if (value != null) {
                                if (filter == dataSnapshot1.child("category").value) {
                                    list.add(value)
                                }
                                recyclerView.adapter?.notifyDataSetChanged()
                            }
                        }
                    }
                    override fun onCancelled(databaseError: DatabaseError) {}
                })
            }
            "game" -> {
                // 툴바 타이틀 설정
                category_detail_toolbar_title.text = getString(R.string.category08)
                val filter = "game"
                myRef.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for(dataSnapshot1 in dataSnapshot.children){
                            val value = dataSnapshot1.getValue(Card::class.java)

                            if (value != null) {
                                if (filter == dataSnapshot1.child("category").value) {
                                    list.add(value)
                                }
                                recyclerView.adapter?.notifyDataSetChanged()
                            }
                        }
                    }
                    override fun onCancelled(databaseError: DatabaseError) {}
                })
            }
            "book" -> {
                // 툴바 타이틀 설정
                category_detail_toolbar_title.text = getString(R.string.category09)
                val filter = "book"
                myRef.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for(dataSnapshot1 in dataSnapshot.children){
                            val value = dataSnapshot1.getValue(Card::class.java)

                            if (value != null) {
                                if (filter == dataSnapshot1.child("category").value) {
                                    list.add(value)
                                }
                                recyclerView.adapter?.notifyDataSetChanged()
                            }
                        }
                    }
                    override fun onCancelled(databaseError: DatabaseError) {}
                })
            }
            "pet" -> {
                // 툴바 타이틀 설정
                category_detail_toolbar_title.text = getString(R.string.category10)
                val filter = "pet"
                myRef.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for(dataSnapshot1 in dataSnapshot.children){
                            val value = dataSnapshot1.getValue(Card::class.java)

                            if (value != null) {
                                if (filter == dataSnapshot1.child("category").value) {
                                    list.add(value)
                                }
                                recyclerView.adapter?.notifyDataSetChanged()
                            }
                        }
                    }
                    override fun onCancelled(databaseError: DatabaseError) {}
                })
            }
            "etc" -> {
                // 툴바 타이틀 설정
                category_detail_toolbar_title.text = getString(R.string.category11)
                val filter = "etc"
                myRef.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for (dataSnapshot1 in dataSnapshot.children) {
                            val value = dataSnapshot1.getValue(Card::class.java)

                            if (value != null) {
                                if (filter == dataSnapshot1.child("category").value) {
                                    list.add(value)
                                }
                                recyclerView.adapter?.notifyDataSetChanged()
                            }
                        }
                    }
                    override fun onCancelled(databaseError: DatabaseError) {}
                })
            }
            "buy" -> {
                // 툴바 타이틀 설정
                category_detail_toolbar_title.text = getString(R.string.category11)
                val filter = "buy"
                myRef.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for (dataSnapshot1 in dataSnapshot.children) {
                            val value = dataSnapshot1.getValue(Card::class.java)

                            if (value != null) {
                                if (filter == dataSnapshot1.child("category").value) {
                                    list.add(value)
                                }
                                recyclerView.adapter?.notifyDataSetChanged()
                            }
                        }
                    }
                    override fun onCancelled(databaseError: DatabaseError) {}
                })
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
