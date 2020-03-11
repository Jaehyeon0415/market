package com.myapplication.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.myapplication.R
import com.myapplication.ui.SellDetailActivity
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        view.profile_user_sell.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, SellDetailActivity::class.java)
                    .putExtra("category","sell")
            )
        }
        view.profile_user_buylist.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, SellDetailActivity::class.java)
                    .putExtra("category","buylist")
            )
        }
        view.profile_user_interest.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, SellDetailActivity::class.java)
                    .putExtra("category","interest")
            )
        }
        view.profile_notice.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, SellDetailActivity::class.java)

            )
        }

        return view
    }

}