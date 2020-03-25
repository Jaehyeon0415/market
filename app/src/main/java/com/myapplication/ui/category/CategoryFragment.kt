package com.myapplication.ui.category;

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.myapplication.R
import com.myapplication.ui.CategoryDetailActivity
import kotlinx.android.synthetic.main.fragment_category.view.*

class CategoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_category, container, false)

        // 툴바 TITLE
        view.category_toolbar_title.text = getString(R.string.title_category)

        view.category_card_digital.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, CategoryDetailActivity::class.java)
                    .putExtra("category","digital")
            )
        }
        view.category_card_funiture.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, CategoryDetailActivity::class.java)
                    .putExtra("category","funiture")
            )
        }
        view.category_card_child.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, CategoryDetailActivity::class.java)
                    .putExtra("category","child")
            )
        }
        view.category_card_clothes.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, CategoryDetailActivity::class.java)
                    .putExtra("category","clothes")
            )
        }
        view.category_card_life.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, CategoryDetailActivity::class.java)
                    .putExtra("category","life")
            )
        }
        view.category_card_beauty.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, CategoryDetailActivity::class.java)
                    .putExtra("category","beauty")
            )
        }
        view.category_card_sports.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, CategoryDetailActivity::class.java)
                    .putExtra("category","sports")
            )
        }
        view.category_card_game.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, CategoryDetailActivity::class.java)
                    .putExtra("category","game")
            )
        }
        view.category_card_book.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, CategoryDetailActivity::class.java)
                    .putExtra("category","book")
            )
        }
        view.category_card_pet.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, CategoryDetailActivity::class.java)
                    .putExtra("category","pet")
            )
        }
        view.category_card_etc.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, CategoryDetailActivity::class.java)
                    .putExtra("category","etc")
            )
        }
        view.category_card_buy.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, CategoryDetailActivity::class.java)
                    .putExtra("option","buy")
            )
        }

        return view
    }
}
