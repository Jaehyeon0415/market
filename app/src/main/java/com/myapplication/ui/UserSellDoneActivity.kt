package com.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.myapplication.R
import com.myapplication.adapter.CardAdapter
import com.myapplication.adapter.CardDeleteAdapter
import com.myapplication.models.Card
import kotlinx.android.synthetic.main.activity_user_sell_done.*
import kotlinx.android.synthetic.main.activity_user_selling.recyclerView

class UserSellDoneActivity : AppCompatActivity() {

    val list = ArrayList<Card>()

    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var myRef = database.reference.child("card")
    private val user = FirebaseAuth.getInstance().currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_sell_done)

        // 툴바 사용하기
        val toolbar = findViewById<Toolbar>(R.id.user_sell_done_toolbar)
        setSupportActionBar(toolbar)
        val ab = supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)
        ab.setDisplayHomeAsUpEnabled(true)

        // 툴바 타이틀 설정
        user_sell_done_toolbar_text.text = getString(R.string.profile02)

        // 사용자가 등록한 게시물만 보여주기
        val filter = user?.uid
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for(dataSnapshot1 in dataSnapshot.children){

                    val value = dataSnapshot1.getValue(Card::class.java)
                    if (value != null) {
                        if (filter == dataSnapshot1.child("uid").value && "true" == dataSnapshot1.child("option").value) {
                            list.add(value)
                        }
                        recyclerView.adapter?.notifyDataSetChanged()
                    }
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {}
        })


        recyclerView.adapter = CardDeleteAdapter(this,list)
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
