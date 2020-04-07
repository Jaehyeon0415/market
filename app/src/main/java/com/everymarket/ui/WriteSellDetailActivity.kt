package com.everymarket.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.everymarket.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ServerValue
import kotlinx.android.synthetic.main.activity_write_sell_detail.*


class WriteSellDetailActivity : AppCompatActivity() {

    private var database: DatabaseReference = FirebaseDatabase.getInstance().reference
    private val user = FirebaseAuth.getInstance().currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_sell_detail)

        write_sell_category.setOnClickListener {
            val intent = Intent(this, WriteSellCategoryDetailActivity:: class.java)
            startActivityForResult(intent, 100);
        }

        // 툴바 사용하기
        val toolbar = findViewById<Toolbar>(R.id.write_sell_toolbar)
        setSupportActionBar(toolbar)
        val ab = supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)
        ab.setDisplayHomeAsUpEnabled(true)

        // price 최대 값 설정
        val edit = findViewById<EditText>(R.id.write_sell_price)
        val FilterArray = arrayOfNulls<InputFilter>(1)
        FilterArray[0] = LengthFilter(8)
        edit.filters = FilterArray


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
            Toast.makeText(this, "게시물이 등록되었어요!", Toast.LENGTH_SHORT).show()
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
                    when (data?.getStringExtra("category")){
                        "digital" -> {
                            write_sell_category_text.text = "디지털/가전"
                        }
                        "funiture" -> {
                            write_sell_category_text.text = "가구/인테리어"
                        }
                        "clothes" -> {
                            write_sell_category_text.text = "의류/잡화"
                        }
                        "life" -> {
                            write_sell_category_text.text = "생활/가공식품"
                        }
                        "beauty" -> {
                            write_sell_category_text.text = "뷰티/미용"
                        }
                        "sports" -> {
                        write_sell_category_text.text = "스포츠/레저"
                        }
                        "game" -> {
                            write_sell_category_text.text = "게임/취미"
                        }
                        "book" -> {
                            write_sell_category_text.text = "도서/티켓/음반"
                        }
                        "pet" -> {
                            write_sell_category_text.text = "반려동물용품"
                        }
                        "ect" -> {
                            write_sell_category_text.text = "기타 중고용품"
                        }
                    }
                }
            }
        }
    }

    // 게시물 등록
    private fun addCard() {

        val uid = user?.uid
        val myRef = database.child("card").push()
        val key = myRef.key
        val userRef = database.child("users").child(uid.toString())

        when (write_sell_category_text.text){
            "디지털/가전" -> {
                write_sell_category_text.text = getString(R.string.categoryE01)
            }
            "가구/인테리어" -> {
                write_sell_category_text.text = getString(R.string.categoryE02)
            }
            "의류/잡화" -> {
                write_sell_category_text.text = getString(R.string.categoryE04)
            }
            "생활/가공식품" -> {
                write_sell_category_text.text = getString(R.string.categoryE05)
            }
            "뷰티/미용" -> {
                write_sell_category_text.text = getString(R.string.categoryE06)
            }
            "스포츠/레저" -> {
                write_sell_category_text.text = getString(R.string.categoryE07)
            }
            "게임/취미" -> {
                write_sell_category_text.text = getString(R.string.categoryE08)
            }
            "도서/티켓/음반" -> {
                write_sell_category_text.text = getString(R.string.categoryE09)
            }
            "반려동물용품" -> {
                write_sell_category_text.text = getString(R.string.categoryE10)
            }
            "기타 중고용품" -> {
                write_sell_category_text.text = getString(R.string.categoryE11)
            }
        }

        myRef.child("title").setValue(write_sell_textTitle.text.toString())
        myRef.child("category").setValue(write_sell_category_text.text)
        myRef.child("writer").setValue(user?.displayName.toString())
        myRef.child("price").setValue(write_sell_price.text.toString())
        //myRef?.child("image")?.setValue()
        myRef.child("context").setValue(write_sell_context.text.toString())
        myRef.child("option").setValue("false")
        myRef.child("uid").setValue(uid.toString())
        myRef.child("id").setValue(key)
        myRef.child("time").setValue(ServerValue.TIMESTAMP)

        userRef.child("myCard").child(key.toString()).child("option").setValue("false")

    }
}
