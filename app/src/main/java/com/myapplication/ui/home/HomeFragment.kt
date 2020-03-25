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

//        // cardList 초기화
//        cardList.clear()
//
//        // sample data
//cardList.add(Card(getString(R.string.title01),"digital",getString(R.string.writer01),getString(R.string.price01),R.drawable.airpod,"실사용 3개월, 상태 A급입니다.", false))
//        cardList.add(Card(getString(R.string.title01), "digital", getString(R.string.writer01), getString(R.string.price01), R.drawable.airpod, "실사용 3개월, 상태 A급입니다.", false))
//        cardList.add(Card(getString(R.string.title02), "digital", getString(R.string.writer02), getString(R.string.price02), R.drawable.applepencil, "실사용 4개월, 상태 A급입니다.",false))
//        cardList.add(Card(getString(R.string.title03), "life", getString(R.string.writer03), getString(R.string.price03), R.drawable.ballantine, "먹을려다 그냥 팔겠음",false))
//        cardList.add(Card(getString(R.string.title04), "sports", getString(R.string.writer04), getString(R.string.price04), R.drawable.bike, "실사용 3개월, 상태 A급입니다.",false))
//        cardList.add(Card(getString(R.string.title05), "life", getString(R.string.writer05), getString(R.string.price05), R.drawable.bottle, "선물받은건데 안써서 팔음",false))
//        cardList.add(Card(getString(R.string.title06), "life", getString(R.string.writer06), getString(R.string.price06), R.drawable.coffee, "선물받은건데 안써서 팔음",false))
//        cardList.add(Card(getString(R.string.title07), "life", getString(R.string.writer07), getString(R.string.price07), R.drawable.banana, "직접 바나나 재배한거 받았는데 팔음",false))
//        cardList.add(Card(getString(R.string.title08), "funiture", getString(R.string.writer08), getString(R.string.price08), R.drawable.chair, "실사용 3개월, 상태 A급입니다.",false))
//        cardList.add(Card(getString(R.string.title09), "digital", getString(R.string.writer09), getString(R.string.price09), R.drawable.imac, "실사용 3개월, 상태 A급입니다.",false))
//        cardList.add(Card(getString(R.string.title10), "funiture", getString(R.string.writer10), getString(R.string.price10), R.drawable.table, "실사용 3개월, 상태 A급입니다.",false))
//        cardList.add(Card(getString(R.string.title11), "digital", "이재환", "150000", R.drawable.tv, "실사용 3개월, 상태 A급입니다.",false))
//        cardList.add(Card(getString(R.string.title01), "digital", getString(R.string.writer01), getString(R.string.price01), R.drawable.airpod, "실사용 3개월, 상태 A급입니다.", false))
//        cardList.add(Card(getString(R.string.title02), "digital", getString(R.string.writer02), getString(R.string.price02), R.drawable.applepencil, "실사용 4개월, 상태 A급입니다.",false))
//        cardList.add(Card(getString(R.string.title03), "life", getString(R.string.writer03), getString(R.string.price03), R.drawable.ballantine, "먹을려다 그냥 팔겠음",false))
//        cardList.add(Card(getString(R.string.title04), "sports", getString(R.string.writer04), getString(R.string.price04), R.drawable.bike, "실사용 3개월, 상태 A급입니다.",false))
//        cardList.add(Card(getString(R.string.title05), "life", getString(R.string.writer05), getString(R.string.price05), R.drawable.bottle, "선물받은건데 안써서 팔음",false))
//        cardList.add(Card(getString(R.string.title06), "life", getString(R.string.writer06), getString(R.string.price06), R.drawable.coffee, "선물받은건데 안써서 팔음",false))
//        cardList.add(Card(getString(R.string.title07), "life", getString(R.string.writer07), getString(R.string.price07), R.drawable.banana, "직접 바나나 재배한거 받았는데 팔음",false))
//        cardList.add(Card(getString(R.string.title08), "funiture", getString(R.string.writer08), getString(R.string.price08), R.drawable.chair, "실사용 3개월, 상태 A급입니다.",false))
//        cardList.add(Card(getString(R.string.title09), "digital", getString(R.string.writer09), getString(R.string.price09), R.drawable.imac, "실사용 3개월, 상태 A급입니다.",false))
//        cardList.add(Card(getString(R.string.title10), "funiture", getString(R.string.writer10), getString(R.string.price10), R.drawable.table, "실사용 3개월, 상태 A급입니다.",false))
//        cardList.add(Card(getString(R.string.title11), "digital", "이재환", "150000", R.drawable.tv, "실사용 3개월, 상태 A급입니다.",false))
//        cardList.add(Card(getString(R.string.title01), "digital", getString(R.string.writer01), getString(R.string.price01), R.drawable.airpod, "실사용 3개월, 상태 A급입니다.", false))
//        cardList.add(Card(getString(R.string.title02), "digital", getString(R.string.writer02), getString(R.string.price02), R.drawable.applepencil, "실사용 4개월, 상태 A급입니다.",false))
//        cardList.add(Card(getString(R.string.title03), "life", getString(R.string.writer03), getString(R.string.price03), R.drawable.ballantine, "먹을려다 그냥 팔겠음",false))
//        cardList.add(Card(getString(R.string.title04), "sports", getString(R.string.writer04), getString(R.string.price04), R.drawable.bike, "실사용 3개월, 상태 A급입니다.",false))
//        cardList.add(Card(getString(R.string.title05), "life", getString(R.string.writer05), getString(R.string.price05), R.drawable.bottle, "선물받은건데 안써서 팔음",false))
//        cardList.add(Card(getString(R.string.title06), "life", getString(R.string.writer06), getString(R.string.price06), R.drawable.coffee, "선물받은건데 안써서 팔음",false))
//        cardList.add(Card(getString(R.string.title07), "life", getString(R.string.writer07), getString(R.string.price07), R.drawable.banana, "직접 바나나 재배한거 받았는데 팔음",false))
//        cardList.add(Card(getString(R.string.title08), "funiture", getString(R.string.writer08), getString(R.string.price08), R.drawable.chair, "실사용 3개월, 상태 A급입니다.",false))
//        cardList.add(Card(getString(R.string.title09), "digital", getString(R.string.writer09), getString(R.string.price09), R.drawable.imac, "실사용 3개월, 상태 A급입니다.",false))
//        cardList.add(Card(getString(R.string.title10), "funiture", getString(R.string.writer10), getString(R.string.price10), R.drawable.table, "실사용 3개월, 상태 A급입니다.",false))
//        cardList.add(Card(getString(R.string.title11), "digital", "이재환", "150000", R.drawable.tv, "실사용 3개월, 상태 A급입니다.",false))