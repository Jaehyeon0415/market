package com.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.myapplication.R
import com.myapplication.models.Card
import com.myapplication.ui.CardDetailActivity
import kotlinx.android.synthetic.main.item_home.view.cardCategory
import kotlinx.android.synthetic.main.item_home.view.cardPrice
import kotlinx.android.synthetic.main.item_home.view.cardTitle
import kotlinx.android.synthetic.main.item_home.view.cardWriter
import kotlinx.android.synthetic.main.item_sell_done.view.*
import kotlinx.android.synthetic.main.item_selling.view.cardId

class CardDeleteAdapter(val context: Context, private val cardList: ArrayList<Card>):
    RecyclerView.Adapter<CardDeleteAdapter.Holder>() {

    private val user = FirebaseAuth.getInstance().currentUser
    private val uid = user?.uid.toString()
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val myRef = database.reference
    private val userRef = myRef.child("users")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_sell_done, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(cardList[position], context)
    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        fun bind (card: Card, context: Context) {
            //itemView.
            itemView.setOnClickListener {
//                // image 넘겨줌
//                val bitmap = ((itemView.cardImage).drawable as BitmapDrawable).bitmap
//                val stream = ByteArrayOutputStream()
//                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
//                val image = stream.toByteArray()

                itemView.context.startActivity(
                    Intent(itemView.context,CardDetailActivity::class.java)
                        .putExtra("cardTitle", card.title)
                        .putExtra("cardWriter", card.writer)
                        .putExtra("cardPrice", card.price)
                        //.putExtra("cardImage", image)
                        .putExtra("cardContext", card.context)
                        .putExtra("cardCategory", card.category)
                        .putExtra("cID", card.id)

                )
            }
            //itemView.cardImage.setImageResource(card.image)
            itemView.cardTitle.text = card.title
            itemView.cardCategory.text = card.category
            itemView.cardWriter.text = card.writer
            itemView.cardPrice.text = "${card.price}원"
            itemView.cardId.text = card.id

            // 판매완료 버튼을 눌렀을 때 해당되는 Item이 판매완료 목록으로 이동
            itemView.deleteButton.setOnClickListener {
                myRef.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for(data in dataSnapshot.children){
                            if ("card" == data.key) {
                                Log.d("bbbb222", data.child(card.id).child("id").value.toString())
                                if (card.id == data.child(card.id).child("id").value) {
                                    data.child(card.id).ref.removeValue()
                                }
                            } else
                            if ("users" == data.key) {
                                deleteCard(card.id)
                            }
                        }
                        cardList.clear()
                    }
                    override fun onCancelled(databaseError: DatabaseError) {}
                })
                Toast.makeText(context,"판매내역에서 삭제했어요!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount() = cardList.size

    fun deleteCard(cID: String) {
        userRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for(data in dataSnapshot.children){
                    val userID = data.key.toString()
                    Log.d("bbbb5555", data.child("favorite").key.toString())

                    userRef.child(userID).addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(p0: DataSnapshot) {
                            for (data2 in p0.children) {
                                Log.d("bbbb9999", data2.key.toString())
                                if (data2.key == "favorite") {
                                    userRef.child(userID).child("favorite").addValueEventListener(object : ValueEventListener {
                                        override fun onDataChange(dataSnapshot2: DataSnapshot) {
                                            for (data3 in dataSnapshot2.children) {
                                                Log.d("bbbbb6666", data3.key.toString())
                                                if (data3.key == cID) {
                                                    userRef.child(userID).child("favorite").child(cID).ref.removeValue()
                                                }
                                            }
                                        }
                                        override fun onCancelled(databaseError: DatabaseError) {}
                                    })
                                }
                                if (data2.key == "myCard") {
                                    userRef.child(userID).child("myCard").addValueEventListener(object : ValueEventListener {
                                        override fun onDataChange(dataSnapshot2: DataSnapshot) {
                                            for (data4 in dataSnapshot2.children) {
                                                Log.d("bbbbb6666", data4.key.toString())
                                                if (data4.key == cID) {
                                                    userRef.child(userID).child("myCard").child(cID).ref.removeValue()
                                                }
                                            }
                                        }
                                        override fun onCancelled(databaseError: DatabaseError) {}
                                    })
                                }
                            }
                        }
                        override fun onCancelled(p0: DatabaseError) {}
                    })
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }
}