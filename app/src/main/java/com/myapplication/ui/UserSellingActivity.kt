package com.myapplication.ui

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.myapplication.R
import com.myapplication.adapter.CardEditAdapter
import com.myapplication.models.Card
import kotlinx.android.synthetic.main.activity_user_selling.*


class UserSellingActivity : AppCompatActivity() {

    val list = ArrayList<Card>()

    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var myRef = database.reference.child("card")
    private val user = FirebaseAuth.getInstance().currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_selling)

        // 툴바 사용하기
        val toolbar = findViewById<Toolbar>(R.id.user_selling_toolbar)
        setSupportActionBar(toolbar)
        val ab = supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)
        ab.setDisplayHomeAsUpEnabled(true)

        // 툴바 타이틀 설정
        user_selling_toolbar_text.text = getString(R.string.profile01)

        // 사용자가 등록한 게시물만 보여주기
        val filter = user?.uid
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for(dataSnapshot1 in dataSnapshot.children){

                    val value = dataSnapshot1.getValue(Card::class.java)
                    if (value != null) {
                        if (filter == dataSnapshot1.child("id").value && "false" == dataSnapshot1.child("option").value) {
                            list.add(value)
                        }
                        recyclerView.adapter?.notifyDataSetChanged()
                    }
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {}
        })

        // 판매완료 버튼 클릭 시 판매완료목록으로 이동

        recyclerView.adapter = CardEditAdapter(this,list)
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
