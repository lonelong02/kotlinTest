package com.wesai.kotlin.activities

import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.wesai.kotlin.BaseActivity
import com.wesai.kotlin.R
import kotlinx.android.synthetic.main.activity_nestedscroll.*

class NestedScrollActivity : BaseActivity() {
    var mData = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nestedscroll)
        initRecyclerView();
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        for (i in 1..200) {
            mData.add("行 " + i)
        }
        recyclerView.adapter = object : RecyclerView.Adapter<MyVH>() {
            override fun onBindViewHolder(holder: MyVH?, position: Int) {
                var str = mData.get(position);
                (holder?.view as TextView).setText(str)
            }

            override fun getItemCount(): Int {
                return mData.size
            }

            override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyVH {
                var view = TextView(this@NestedScrollActivity);
                view.gravity = Gravity.CENTER
                view.setTextColor(Color.WHITE);
                view.setPadding(0, 20, 0, 20)
                return MyVH(view)
            }
        }

    }

    class MyVH(view: View) : RecyclerView.ViewHolder(view) {
        var view: View;

        init {
            this.view = view;
        }

    }
}