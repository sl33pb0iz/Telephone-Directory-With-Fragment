package com.example.telephonedirectoryfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toolbar
import androidx.fragment.app.Fragment

class ListFragment: Fragment() {
    lateinit var listView: ListView
    lateinit var items: ArrayList<Information>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listView = view.findViewById(R.id.list_view)

        items = arrayListOf()
        repeat(20) {
            items.add(Information("ID$it", "Quynh Anh", "0987654321", "qa@gmail.com"))
        }

        listView.adapter = ListViewAdapter(requireContext(), items)

        listView.setOnItemClickListener { parent, view, position, id ->
            val item = items[position]
            if (activity is ItemClickListener)
                (activity as ItemClickListener).ItemClicked(item)
        }
    }

    fun AddItem(item: Information){
        var id = items.size
        item.id = "ID$id"
        items.add(item)
    }
}
