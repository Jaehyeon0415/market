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
import com.myapplication.adapter.CardEditAdapter
import com.myapplication.models.Card
import kotlinx.android.synthetic.main.activity_user_favorite.*
import kotlinx.android.synthetic.main.activity_user_favorite.recyclerView
import kotlinx.android.synthetic.main.activity_user_selling.*

class UserFavoriteActivity : AppCompatActivity() {

    val list = ArrayList<Card>()

    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val user = FirebaseAuth.getInstance().currentUser
    private val uid = user?.uid.toString()
    private var myRef = database.reference.child("card")
    private var userRef = database.reference.child("users").child(uid).child("favorite")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_favorite)

        // 툴바 사용하기
        val toolbar = findViewById<Toolbar>(R.id.user_favorite_toolbar)
        setSupportActionBar(toolbar)
        val ab = supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)
        ab.setDisplayHomeAsUpEnabled(true)

        // 툴바 타이틀 설정
        user_favorite_toolbar_text.text = getString(R.string.profile03)

        // 사용자가 등록한 게시물만 보여주기
        userRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for(dataSnapshot1 in dataSnapshot.children){
                    val value = dataSnapshot1.key.toString()
                    myRef.child(value).addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot3: DataSnapshot) {
                            val value2 = dataSnapshot3.getValue(Card::class.java)
                            if (value2 != null && "true" != value2.option) {
                                list.add(value2)
                            }
                            recyclerView.adapter?.notifyDataSetChanged()
                        }
                        override fun onCancelled(databaseError: DatabaseError) {}
                    })
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {}
        })

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
