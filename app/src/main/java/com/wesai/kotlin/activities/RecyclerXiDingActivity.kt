package com.wesai.kotlin.activities

import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.wesai.kotlin.BaseActivity
import com.wesai.kotlin.R
import kotlinx.android.synthetic.main.activity_recycler_xiding.*

/**
 * Created by long
 * on 2018/3/30.
 */
class RecyclerXiDingActivity : BaseActivity() {
    private var mData: ArrayList<HashMap<String, Any>> = ArrayList();
    private var mAdapter: RecyclerView.Adapter<ViewHolder>? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_xiding);
        initData();
        initRecyclerView();
    }

    private fun initData() {
        var top = "ABCDEFGHILKLMNOPQRSTUWXYZ";
        for (value in top) {
            var row = HashMap<String, Any>();
            row.put("isTitle", true);
            row.put("value", value.toString());
            mData.add(row);
            for (index: Int in 1..10) {
                var row = HashMap<String, Any>();
                row.put("isTitle", false);
                row.put("value", "${value}行${index}");
                mData.add(row);
            }
        }
    }

    private fun initRecyclerView() {
        mAdapter = ViewAdapter(mData);
        recyclerView.adapter = mAdapter;
        recyclerView.layoutManager = LinearLayoutManager(this);

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy);
                var layoutManager = recyclerView?.layoutManager as LinearLayoutManager;
                var first = layoutManager.findFirstVisibleItemPosition(); //获取第一个当前可见的View的position
//                   layoutManager.findFirstCompletelyVisibleItemPosition() //获取第一个当前完全可见的View的position
                var last = layoutManager.findLastVisibleItemPosition();//获取最后一个可见的View的position

                Log.e("myDebug", "first=${first} last=${last}")

                for (index in first downTo 0) { //倒序
                    var row = mData.get(index);
                    if ((row.get("isTitle") as Boolean)) {
                        titleView.setText(row.get("value").toString());
                        break;
                    }

                }
            }
        });

    }

    inner class ViewAdapter : RecyclerView.Adapter<ViewHolder> {
        private var mData: ArrayList<HashMap<String, Any>>;

        constructor(data: ArrayList<HashMap<String, Any>>) : super() {
            this.mData = data;
        }

        override fun getItemCount(): Int {
            return mData.size;
        }

        override fun getItemViewType(position: Int): Int {
            var data = mData.get(position);
            if ((data.get("isTitle") as Boolean)) {
                return 1
            } else {
                return 0;
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
            var view = TextView(this@RecyclerXiDingActivity);
            var params = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, 100);
            view.layoutParams = params
            view.setPadding(100, 0, 0, 0);
            view.gravity = Gravity.CENTER_VERTICAL;
            if (viewType == 1) {
                view.setTextColor(Color.WHITE);
                view.setBackgroundColor(Color.RED)
            }
            var holder = ViewHolder(view);
            return holder;
        }


        override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
            var row = mData.get(position);
            holder!!.getTextView().setText(row.get("value") as String)
        }


    }

    class ViewHolder : RecyclerView.ViewHolder {
        private var mView: View;

        constructor(view: View) : super(view) {
            this.mView = view;
        }

        fun getTextView(): TextView {
            return (mView as TextView);
        }
    }

}