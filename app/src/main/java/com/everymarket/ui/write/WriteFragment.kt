package com.everymarket.ui.write

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.everymarket.R
import com.everymarket.ui.WriteBuyDetailActivity
import com.everymarket.ui.WriteSellDetailActivity
import kotlinx.android.synthetic.main.fragment_write.view.*


class WriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_write, container, false)

        // 툴바 TITLE
        view.write_toolbar_title.text = getString(R.string.title_write)

        // 중고물품 판매
        view.write_sell.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, WriteSellDetailActivity::class.java)

            )
        }

        // 중고물품 구매
        view.write_buy.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, WriteBuyDetailActivity::class.java)

            )
        }

        return view
    }

}