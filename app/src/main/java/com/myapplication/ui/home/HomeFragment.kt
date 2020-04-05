package com.myapplication.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.myapplication.R
import com.myapplication.adapter.CardAdapter
import com.myapplication.models.Card
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {

    companion object{
        val cardList: ArrayList<Card> = ArrayList()
    }

    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var myRef = database.reference.child("card")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val mCardAdapter = CardAdapter(view.context, cardList)

        // 툴바 TITLE
        view.home_toolbar_title.text = getString(R.string.app_name)

        cardList.clear()

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for(dataSnapshot1 in dataSnapshot.children){

                    val value = dataSnapshot1.getValue(Card::class.java)
                    if (value != null) {
                        if("false" == dataSnapshot1.child("option").value)
                            cardList.add(value)
                            (view.recyclerView.adapter as CardAdapter).notifyDataSetChanged()
                    }
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {}
        })

        view.recyclerView.adapter = mCardAdapter

        val lm = LinearLayoutManager(view.context)
        view.recyclerView.layoutManager = lm
        view.recyclerView.setHasFixedSize(true)

        return view
    }
}
