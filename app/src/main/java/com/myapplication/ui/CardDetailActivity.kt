package com.myapplication.ui

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.myapplication.R
import kotlinx.android.synthetic.main.activity_card_detail.*
import kotlinx.android.synthetic.main.item_home.*

class CardDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_detail)

        // string 받아옴
        text_card_detail_title.text = intent.getStringExtra("cardTitle")
        text_card_detail_writer.text = intent.getStringExtra("cardWriter")
        text_card_detail_price.text = intent.getStringExtra("cardPrice")
        text_card_detail_context.text = intent.getStringExtra("cardContext")
        text_card_detail_category.text = intent.getStringExtra("cardCategory")

        // image 받아옴
        val bytes: ByteArray = intent.getByteArrayExtra("cardImage")
        val cardImage = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
        text_card_detail_image.setImageBitmap(cardImage)
    }
}
