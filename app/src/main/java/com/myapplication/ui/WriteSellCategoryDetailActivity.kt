package com.myapplication.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myapplication.R
import kotlinx.android.synthetic.main.activity_write_sell_category_detail.*

class WriteSellCategoryDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_sell_category_detail)

        // 카테고리 선택시 해당하는 카테고리 값 가져오기
        category_card_digital.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", "digital")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        category_card_funiture.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", "funiture")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        category_card_clothes.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", "clothes")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        category_card_life.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", "life")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        category_card_beauty.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", "beauty")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        category_card_sports.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", "sports")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        category_card_game.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", "game")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        category_card_book.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", "book")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        category_card_pet.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", "pet")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        category_card_etc.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", "ect")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
