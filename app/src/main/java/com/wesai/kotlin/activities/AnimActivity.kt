package com.wesai.kotlin.activities

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.Path
import android.os.Bundle
import android.view.View
import com.wesai.kotlin.BaseActivity
import com.wesai.kotlin.R
import kotlinx.android.synthetic.main.activity_anim.*
import android.os.Build
import android.support.annotation.RequiresApi


class AnimActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anim);
        testToolbar();
    }


    private fun testToolbar() {
        toolbar.inflateMenu(R.menu.toolbar_menu)
        toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.item_collect ->
                    toast("收藏")
                R.id.item_share ->
                    toast("分享")
            }
            return@setOnMenuItemClickListener false
        }

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun myOnClick(view: View) {
        var anim = ObjectAnimator.ofFloat(animView, "angle", 0.0f, 180.0f);
        var anim2 = ObjectAnimator.ofFloat(animView, "startAngle", -180.0f, 0.0f)

        var set = AnimatorSet();
        set.playSequentially(anim, anim2)
        set.duration = 3000
        set.start()


        var path = Path();
        path.moveTo(0.0f, 0.0f)
        path.lineTo(animView.width.toFloat(), 200.0f)
        path.lineTo(animView.width.toFloat() / 2, 400.0f)
        path.lineTo(0.0f, 900.0f)


        var patAnim = ObjectAnimator.ofFloat(pathView, "x", "y", path);
        patAnim.duration = 5000;
        patAnim.start()
    }
}