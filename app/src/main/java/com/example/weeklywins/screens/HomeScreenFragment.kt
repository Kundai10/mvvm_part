package com.example.weeklywins.screens

import android.graphics.ColorSpace
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weeklywins.MyAdapter
import com.example.weeklywins.R
import com.example.weeklywins.model.MyWinsDao
import com.example.weeklywins.model.MyWinsRepository
import com.example.weeklywins.model.MyWinsViewModel
import com.example.weeklywins.model.WinItemModelFactory
import java.util.zip.Inflater

class HomeScreenFragment : Fragment() {
    private lateinit var myWinsViewModel: MyWinsViewModel
    private lateinit var adapter: MyAdapter




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //val activity = requireActivity()


        val rootview = inflater.inflate(R.layout.fragment_home_screen, container, false)
        val recyclerView = rootview.findViewById<RecyclerView>(R.id.recycler_view)
        //recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)

        // Set up adapter
        adapter = MyAdapter(emptyList())
        recyclerView.adapter = adapter

        // Set up viewmodel
        myWinsViewModel = ViewModelProvider(this).get(MyWinsViewModel::class.java)

        myWinsViewModel.winItems.observe(viewLifecycleOwner,{ wins->
            adapter = MyAdapter(wins)
            recyclerView.adapter = adapter
            recyclerView.layoutManager= LinearLayoutManager(activity)
        })


        return rootview
    }
   


}