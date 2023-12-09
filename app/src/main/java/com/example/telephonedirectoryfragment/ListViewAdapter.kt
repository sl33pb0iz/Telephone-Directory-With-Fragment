package com.example.telephonedirectoryfragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListViewAdapter(val context: Context, val data: ArrayList<Information>): BaseAdapter() {
    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater;
    override fun getCount(): Int {
        return data.size;
    }

    override fun getItem(position: Int): Any {
        return data[position];
    }

    override fun getItemId(position: Int): Long {
        return position.toLong();
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.item_text_view, parent, false);

        val itemNameView:TextView = rowView.findViewById(R.id.item_name);
        val info = getItem(position) as Information;
        itemNameView.text = info.name;

        return rowView;
    }

}