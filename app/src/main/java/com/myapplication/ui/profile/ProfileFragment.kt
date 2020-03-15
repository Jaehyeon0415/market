package com.myapplication.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.myapplication.LoginActivity
import com.myapplication.R
import com.myapplication.ui.WriteSellDetailActivity
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*
import kotlinx.android.synthetic.main.fragment_profile.view.profile_user_nickname

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val user = FirebaseAuth.getInstance().currentUser

        if (user != null) {
            view.profile_user_nickname.text = user.displayName
            view.profile_user_id.text = user.email
            if (user.photoUrl == null){

            } else {

            }
        }

        view.profile_user_sell.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, WriteSellDetailActivity::class.java)
                    .putExtra("category","sell")
            )
        }
        view.profile_user_buylist.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, WriteSellDetailActivity::class.java)
                    .putExtra("category","buylist")
            )
        }
        view.profile_user_interest.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, WriteSellDetailActivity::class.java)
                    .putExtra("category","interest")
            )
        }
        view.profile_notice.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, WriteSellDetailActivity::class.java)

            )
        }

        view.logout_google.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            view.context.startActivity(
                Intent(view.context, LoginActivity::class.java)
            )

            Toast.makeText(context, "로그아웃에 성공하였습니다.", Toast.LENGTH_SHORT).show()
        }

        return view
    }

}