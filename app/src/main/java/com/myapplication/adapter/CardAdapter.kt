package com.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.myapplication.R
import com.myapplication.models.Card
import com.myapplication.ui.CardDetailActivity
import kotlinx.android.synthetic.main.item_home.view.*

class CardAdapter(val context: Context, private val cardList: ArrayList<Card>):
    RecyclerView.Adapter<CardAdapter.Holder>() {

    private val user = FirebaseAuth.getInstance().currentUser
    private var uid = user?.uid.toString()
    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    var isFavorite: String = "false"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false)
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

                // 관심목록에 있는지 유무 확인
                val favorite = database.reference.child("users").child(uid).child("favorite")
                favorite.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for(dataSnapshot1 in dataSnapshot.children) {
                            Log.d("ddd", dataSnapshot1.key.toString())
                            if(card.id == dataSnapshot1.key) {
                                isFavorite = "true"
                                break
                            }
                            isFavorite = "false"
                        }
                    }
                    override fun onCancelled(databaseError: DatabaseError) {}
                })
                Log.d("isFavorite2", isFavorite)

                itemView.context.startActivity(

                    Intent(itemView.context,CardDetailActivity::class.java)
                        .putExtra("cardTitle", card.title)
                        .putExtra("cardWriter", card.writer)
                        .putExtra("cardPrice", card.price)
                        //.putExtra("cardImage", image)
                        .putExtra("cardContext", card.context)
                        .putExtra("cardCategory", card.category)
                        .putExtra("cID", card.id)
                        .putExtra("isFavorite", isFavorite)
                )
            }
            //itemView.cardImage.setImageResource(card.image)
            itemView.cardTitle.text = card.title
            itemView.cardCategory.text = card.category
            itemView.cardWriter.text = card.writer
            itemView.cardPrice.text = "${card.price}원"
            itemView.cardID.text = card.id
        }
    }

    override fun getItemCount() = cardList.size

}