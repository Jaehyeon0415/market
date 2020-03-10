package com.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.myapplication.R
import com.myapplication.adapter.CardAdapter
import com.myapplication.models.Card
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {
    companion object{
        val cardList = arrayListOf<Card>()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container,false)
        val mCardAdapter = CardAdapter(view.context, cardList)

        // sample data
        cardList.add(Card(getString(R.string.title01), "digital", getString(R.string.writer01), getString(R.string.price01), R.drawable.airpod, "실사용 3개월, 상태 A급입니다."))
        cardList.add(Card(getString(R.string.title02), "digital", getString(R.string.writer02), getString(R.string.price02), R.drawable.applepencil, "실사용 4개월, 상태 A급입니다."))
        cardList.add(Card(getString(R.string.title03), "생활/식품", getString(R.string.writer03), getString(R.string.price03), R.drawable.ballantine, "먹을려다 그냥 팔겠음"))
        cardList.add(Card(getString(R.string.title04), "스포츠/레저", getString(R.string.writer04), getString(R.string.price04), R.drawable.bike, "실사용 3개월, 상태 A급입니다."))
        cardList.add(Card(getString(R.string.title05), "생활/식품", getString(R.string.writer05), getString(R.string.price05), R.drawable.bottle, "선물받은건데 안써서 팔음"))
        cardList.add(Card(getString(R.string.title06), "생활/식품", getString(R.string.writer06), getString(R.string.price06), R.drawable.coffee, "선물받은건데 안써서 팔음"))
        cardList.add(Card(getString(R.string.title07), "생활/식품", getString(R.string.writer07), getString(R.string.price07), R.drawable.banana, "직접 바나나 재배한거 받았는데 팔음"))
        cardList.add(Card(getString(R.string.title08), "가구/인테리어", getString(R.string.writer08), getString(R.string.price08), R.drawable.chair, "실사용 3개월, 상태 A급입니다."))
        cardList.add(Card(getString(R.string.title09), "digital", getString(R.string.writer09), getString(R.string.price09), R.drawable.imac, "실사용 3개월, 상태 A급입니다."))
        cardList.add(Card(getString(R.string.title10), "가구/인테리어", getString(R.string.writer10), getString(R.string.price10), R.drawable.table, "실사용 3개월, 상태 A급입니다."))
        cardList.add(Card(getString(R.string.title11), "digital", "이재환", "150000", R.drawable.tv, "실사용 3개월, 상태 A급입니다."))


        view.recyclerView.adapter = mCardAdapter

        val lm = LinearLayoutManager(view.context)
        view.recyclerView.layoutManager = lm
        view.recyclerView.setHasFixedSize(true)

        return view
    }
}