package com.wesai.kotlin.modules

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.LinearLayout
import com.wesai.kotlin.BaseActivity

/***
 *构造方法重载
 */
class PullLinearLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0, defStyleRes: Int = 0) :
        LinearLayout(context, attrs, defStyleAttr, defStyleRes) {
    var headerPad = 0;

    init {
        initView(context)
    }

    fun initView(context: Context) {
        /*
        * @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0, defStyleRes: Int = 0)
        * 会自动的完成构造方法的重载（需要给定默认值）；
        * */
//        val p1 = PullLinearLayout(context);
//        var p2 = PullLinearLayout(context, null);
//        var p3 = PullLinearLayout(context, null, 0);
//        var p4 = PullLinearLayout(context, null, 0, 0);
        headerPad = -(context.resources.displayMetrics.density * 50 + 0.5f).toInt();
        setPadding(left, headerPad + top, right, bottom);
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        BaseActivity.log("dispatchTouchEvent");
        return super.dispatchTouchEvent(ev)
    }

    var lastY = 0.0f;
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event == null) {
            return super.onTouchEvent(event);
        }
        BaseActivity.log("event.action=" + event.action);
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                lastY = event.y;
            }
            MotionEvent.ACTION_MOVE -> {
                var d = event.y - lastY;
                if (Math.abs(d) > 10) {
                    lastY = event.y;
                    scrollBy(0, -d.toInt());
                }
            }
            MotionEvent.ACTION_UP -> {
            }
        }
        return true;
    }
}