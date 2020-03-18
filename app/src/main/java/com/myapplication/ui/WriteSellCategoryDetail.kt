package com.myapplication.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myapplication.R
import kotlinx.android.synthetic.main.activity_write_sell_category_detail.*
import kotlinx.android.synthetic.main.activity_write_sell_detail.*

class WriteSellCategoryDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_sell_category_detail)

        // 카테고리 선택시 해당하는 카테고리 값 가져오기
        category_card_digital.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", category_digital.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        category_card_funiture.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", category_funiture.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        category_card_child.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", category_child.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        category_card_clothes.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", category_clothes.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        category_card_life.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", category_life.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        category_card_beauty.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", category_beauty.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        category_card_sports.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", category_sports.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        category_card_game.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", category_game.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        category_card_book.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", category_book.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        category_card_pet.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", category_pet.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        category_card_etc.setOnClickListener {
            val intent = Intent()
            intent.putExtra("category", category_etc.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}