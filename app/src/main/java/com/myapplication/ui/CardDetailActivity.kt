package com.myapplication.ui

import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.myapplication.R
import kotlinx.android.synthetic.main.activity_card_detail.*

class CardDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_detail)

        // string 받아옴
        text_card_detail_title.text = intent.getStringExtra("cardTitle")
        text_card_detail_writer.text = intent.getStringExtra("cardWriter")
        text_card_detail_price.text = intent.getStringExtra("cardPrice")
        text_card_detail_context.text = intent.getStringExtra("cardContext")



//        // image 받아옴
//        val bytes: ByteArray = intent.getByteArrayExtra("cardImage")
//        val cardImage = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
//        text_card_detail_image.setImageBitmap(cardImage)

        // 툴바 사용하기
        val toolbar = findViewById<Toolbar>(R.id.card_detail_toolbar)
        setSupportActionBar(toolbar)
        val ab = supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)
        ab.setDisplayHomeAsUpEnabled(true)

        val ch = intent.getStringExtra("cardCategory")

        // 카테고리 한글로 변경
        if (ch == "digital") {
            text_card_detail_category.text = "디지털/가전"
        } else if (ch == "funiture") {
            text_card_detail_category.text = "가구/인테리어"
        } else if (ch == "child") {
            text_card_detail_category.text = "유아동/유아도서"
        } else if (ch == "clothes") {
            text_card_detail_category.text = "의류/잡화"
        } else if (ch == "life") {
            text_card_detail_category.text = "생활/가공식품"
        } else if (ch == "beauty") {
            text_card_detail_category.text = "뷰티/미용"
        } else if (ch == "sports") {
            text_card_detail_category.text = "스포츠/레저"
        } else if (ch == "game") {
            text_card_detail_category.text = "게임/취미"
        } else if (ch == "book") {
            text_card_detail_category.text = "도서/티켓/음반"
        } else if (ch == "pet") {
            text_card_detail_category.text = "반려동물용품"
        } else if (ch == "ect") {
            text_card_detail_category.text = "기타 중고용품"
        }

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
