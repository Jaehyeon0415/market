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

        when(intent.getStringExtra("category")) {
            "digital" -> {
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
            "child" -> {
                val filter = "child"
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
