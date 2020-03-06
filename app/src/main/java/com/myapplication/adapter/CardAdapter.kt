package com.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.R
import com.myapplication.models.Card
import com.myapplication.ui.CardDetailActivity
import kotlinx.android.synthetic.main.item_home.view.*

class CardAdapter(val context: Context, private val cardList: ArrayList<Card>):
    RecyclerView.Adapter<CardAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(cardList[position], context)
    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        fun bind (card: Card, context: Context) {
            if(card.image != null) {

                itemView.cardImage.setImageResource(card.image)
            } else {
                itemView.cardImage.setImageResource(R.mipmap.ic_launcher)
            }

            //itemView.
            itemView.setOnClickListener {
                itemView.context.startActivity(

                    Intent(itemView.context,CardDetailActivity::class.java)
                        .putExtra("cardTitle", card.title)
                        .putExtra("cardWriter", card.writer)
                        .putExtra("cardPrice", card.price)


                )
            }
            itemView.cardTitle.text = card.title
            itemView.cardWriter.text = card.writer
            itemView.cardPrice.text = card.price
        }

    }

    override fun getItemCount() = cardList.size
}