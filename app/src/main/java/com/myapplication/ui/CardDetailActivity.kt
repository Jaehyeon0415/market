package com.myapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.myapplication.R
import kotlinx.android.synthetic.main.activity_card_detail.*

class CardDetailActivity : AppCompatActivity() {

    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val user = FirebaseAuth.getInstance().currentUser
    private var uid = user?.uid.toString()
    private val myRef = database.reference.child("users").child(uid)
    private val favoriteRef = myRef.child("favorite")

    var option: String = ""
    var cID: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_detail)

        // 툴바 사용하기
        val toolbar = findViewById<Toolbar>(R.id.card_detail_toolbar)
        setSupportActionBar(toolbar)
        val ab = supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)
        ab.setDisplayHomeAsUpEnabled(true)

        // string 받아옴
        text_card_detail_title.text = intent.getStringExtra("cardTitle")
        text_card_detail_writer.text = intent.getStringExtra("cardWriter")
        text_card_detail_price.text = "${intent.getStringExtra("cardPrice")}원"
        text_card_detail_context.text = intent.getStringExtra("cardContext")
        text_card_detail_category.text = intent.getStringExtra("cardCategory")
        cID = intent.getStringExtra("cID")

        Log.d("cID", cID.toString())
        // 관심목록 유무확인
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (data in dataSnapshot.children) {
                    if ("favorite" == data.key) {
                        if (data.child(cID.toString()).child("option").value.toString() == "false") {
                            option = "1"
                            break
                        } else {
                            option = "2"
                            break
                        }
                    } else {
                        option = "0"
                        break
                    }
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {}
        })

        // 영어에서 한글로 변환
        when(intent.getStringExtra("cardCategory")) {
            "digital" -> {
                text_card_detail_category.text = getString(R.string.category01)
            }
            "funiture" -> {
                text_card_detail_category.text = getString(R.string.category02)
            }
            "clothes" -> {
                text_card_detail_category.text = getString(R.string.category04)
            }
            "life" -> {
                text_card_detail_category.text = getString(R.string.category05)
            }
            "beauty" -> {
                text_card_detail_category.text = getString(R.string.category06)
            }
            "sports" -> {
                text_card_detail_category.text = getString(R.string.category07)
            }
            "game" -> {
                text_card_detail_category.text = getString(R.string.category08)
            }
            "book" -> {
                text_card_detail_category.text = getString(R.string.category09)
            }
            "pet" -> {
                text_card_detail_category.text = getString(R.string.category10)
            }
            "etc" -> {
                text_card_detail_category.text = getString(R.string.category11)
            }
            "buy" -> {
                text_card_detail_category.text = getString(R.string.category12)
            }
        }

//        // image 받아옴
//        val bytes: ByteArray = intent.getByteArrayExtra("cardImage")
//        val cardImage = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
//        text_card_detail_image.setImageBitmap(cardImage)

    }

    // 툴바 옵션 생성
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.interest_border, menu)
        return true
    }

    // 툴바에 뒤로가기 버튼
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> {
            finish()
            true
        }
        R.id.interest -> {
            isFavorite()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    // 관심목록 추가, 삭제
    private fun isFavorite() {
        if (option == "0") {
            favoriteRef.child(cID.toString()).child("option").setValue("true")
            Toast.makeText(this, "관심목록에 추가했어요!", Toast.LENGTH_SHORT).show()
        } else if (option == "1") {
            favoriteRef.child(cID.toString()).child("option").setValue("true")
            Toast.makeText(this, "관심목록에 추가했어요!", Toast.LENGTH_SHORT).show()
        } else if (option == "2") {
            favoriteRef.child(cID.toString()).ref.removeValue()
            Toast.makeText(this, "관심목록에서 삭제했어요!", Toast.LENGTH_SHORT).show()
        }
    }

}
