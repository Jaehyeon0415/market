package com.myapplication.ui.write

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.myapplication.R
import com.myapplication.ui.BuyDetailActivity
import com.myapplication.ui.SellDetailActivity
import kotlinx.android.synthetic.main.activity_write_popup.view.*

class WriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_write, container, false)

//        view.write_sell.setOnClickListener {
//            view.context.startActivity(
//                Intent(view.context, SellDetailActivity::class.java)
//                    .putExtra("option", "sell")
//            )
//        }

        return view
    }

}