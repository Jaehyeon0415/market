package com.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.R
import com.myapplication.models.Card
import com.myapplication.ui.CardDetailActivity
import kotlinx.android.synthetic.main.item_home.view.*

class CardEditAdapter(val context: Context, private val cardList: ArrayList<Card>):
    RecyclerView.Adapter<CardEditAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_selling, parent, false)
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

                )
            }
            //itemView.cardImage.setImageResource(card.image)
            itemView.cardTitle.text = card.title
            itemView.cardCategory.text = card.category
            itemView.cardWriter.text = card.writer
            itemView.cardPrice.text = "${card.price}원"
        }
    }

    override fun getItemCount() = cardList.size

}