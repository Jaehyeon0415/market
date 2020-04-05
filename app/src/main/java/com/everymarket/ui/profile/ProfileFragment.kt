package com.everymarket.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.everymarket.LoginActivity
import com.everymarket.R
import com.everymarket.ui.UserFavoriteActivity
import com.everymarket.ui.UserSellDoneActivity
import com.everymarket.ui.UserSellingActivity
import kotlinx.android.synthetic.main.fragment_profile.view.*
import kotlinx.android.synthetic.main.fragment_profile.view.profile_user_nickname

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // 툴바 TITLE
        view.profile_toolbar_title.text = getString(R.string.title_profile)

        // 유저 정보 가져오기
        val user = FirebaseAuth.getInstance().currentUser

        // 사진 유무 확인
        if (user != null) {
            view.profile_user_nickname.text = user.displayName
            view.profile_user_id.text = user.email
            if (user.photoUrl == null){

            } else {

            }
        }

        // 판매완료
        view.profile_user_sell_done.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, UserSellDoneActivity::class.java)

            )
        }
        // 판매중
        view.profile_user_selling.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, UserSellingActivity::class.java)

            )
        }
        // 관심목록
        view.profile_user_interest.setOnClickListener {
            view.context.startActivity(
                Intent(view.context, UserFavoriteActivity::class.java)

            )
        }
        // 구글 로그아웃
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