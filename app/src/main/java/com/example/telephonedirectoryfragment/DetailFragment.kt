package com.example.telephonedirectoryfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {
    lateinit var textID: TextView
    lateinit var textName: TextView
    lateinit var textPhone: TextView
    lateinit var textEmail: TextView
    lateinit var backBtn: Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textID = view.findViewById(R.id.text_id)
        textName = view.findViewById(R.id.text_name)
        textPhone = view.findViewById(R.id.text_phone)
        textEmail = view.findViewById(R.id.text_email)
        backBtn = view.findViewById(R.id.back_button)

        backBtn.setOnClickListener{
            if (activity is ItemClickListener)
                (activity as ItemClickListener).ButtonClicked("Back button")
        }
        val item = arguments?.getString("SELECTED_ITEM")
        if (item != null)
            textName.text = item
    }

    fun UpdateContent(item: Information) {
        textID.text = item.id
        textName.text = item.name
        textPhone.text = item.phoneNumber
        textEmail.text = item.emailAddress
    }
}