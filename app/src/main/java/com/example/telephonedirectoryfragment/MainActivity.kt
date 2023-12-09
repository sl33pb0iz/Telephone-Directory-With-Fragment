package com.example.telephonedirectoryfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

class MainActivity : AppCompatActivity(), ItemClickListener {
    val listFragment = ListFragment()
    val detailFragment = DetailFragment()
    val addItemFragment = AddItemFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, listFragment)
            .add(R.id.fragment, detailFragment)
            .add(R.id.fragment, addItemFragment)
            .hide(detailFragment)
            .hide(addItemFragment)
            .commit()
    }

    override fun ItemClicked(item: Information) {
        detailFragment.UpdateContent(item)
        supportFragmentManager.beginTransaction()
            .hide(listFragment)
            .show(detailFragment)
            .commit()
    }

    override fun ButtonClicked(btn_name: String) {
        when(btn_name){
            "Back button" -> supportFragmentManager.beginTransaction()
                                .hide(detailFragment)
                                .show(listFragment)
                                .commit()
            "Add button" -> supportFragmentManager.beginTransaction()
                                .hide(listFragment)
                                .hide(detailFragment)
                                .show(addItemFragment)
                                .commit()
        }
    }

    override fun SubmitClicked(item: Information) {
        listFragment.AddItem(item)
        supportFragmentManager.beginTransaction()
            .hide(addItemFragment)
            .show(listFragment)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.fragment_list_option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.add_contact -> {
                ButtonClicked("Add button")
                true
            }
            else -> false;
        }
    }
}