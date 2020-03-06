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
    var cardList = arrayListOf<Card>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container,false)
        val mCardAdapter = CardAdapter(view.context, cardList)

        cardList.add(Card(getString(R.string.title01), getString(R.string.writer01), getString(R.string.price01), R.drawable.ic_launcher_foreground))
        cardList.add(Card(getString(R.string.title02), getString(R.string.writer02), getString(R.string.price02), R.drawable.ic_launcher_foreground))
        cardList.add(Card(getString(R.string.title03), getString(R.string.writer03), getString(R.string.price03), R.drawable.ic_launcher_foreground))
        cardList.add(Card(getString(R.string.title04), getString(R.string.writer04), getString(R.string.price04), R.drawable.ic_launcher_foreground))
        cardList.add(Card(getString(R.string.title05), getString(R.string.writer05), getString(R.string.price05), R.drawable.ic_launcher_foreground))
        cardList.add(Card(getString(R.string.title06), getString(R.string.writer06), getString(R.string.price06), R.drawable.ic_launcher_foreground))
        cardList.add(Card(getString(R.string.title07), getString(R.string.writer07), getString(R.string.price07), R.drawable.ic_launcher_foreground))
        cardList.add(Card(getString(R.string.title08), getString(R.string.writer08), getString(R.string.price08), R.drawable.ic_launcher_foreground))
        cardList.add(Card(getString(R.string.title09), getString(R.string.writer09), getString(R.string.price09), R.drawable.ic_launcher_foreground))
        cardList.add(Card(getString(R.string.title10), getString(R.string.writer10), getString(R.string.price10), R.drawable.ic_launcher_foreground))







        view.recyclerView.adapter = mCardAdapter

        val lm = LinearLayoutManager(view.context)
        view.recyclerView.layoutManager = lm
        view.recyclerView.setHasFixedSize(true)

        return view
    }
}