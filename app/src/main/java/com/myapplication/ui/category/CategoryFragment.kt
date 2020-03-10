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

        view.category_card_digital.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, CategoryDetailActivity::class.java)
                    .putExtra("category","digital")
            )
        }

        return view
    }
}
