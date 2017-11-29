package com.wesai.kotlin.modules

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * Created by long on 2017/11/28.
 */
class AnimView : View {


    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, att: AttributeSet) : super(context, att) {
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawFanshaped(canvas);
//        drawPathMove(canvas)
    }

    var startAngle = -180.0f
        set(value) {
            angle = Math.abs(startAngle)
            field = value
            invalidate();
        }

    var angle = 0.0f
        set(value) {
            field = value
            invalidate();
        }

    /**
     * 绘制扇形动画
     */
    fun drawFanshaped(canvas: Canvas?) {
        var paint = Paint();
        paint.strokeWidth = 10.0f;
        paint.color = Color.parseColor("#ff7b6c")
        paint.style = Paint.Style.FILL
        var fH = height / 3.0f;
        var left = (width - fH) / 2
        /*绘制扇形*/
        canvas?.drawArc(RectF(left, 0.0f, width - left, fH), startAngle, angle, true, paint);

        /*绘制扇形边线*/
        paint.color = Color.parseColor("#fbd3dc")
        paint.style = Paint.Style.STROKE
        canvas?.drawArc(RectF(left, 0.0f, width - left, fH), startAngle, angle, false, paint);


    }


    /**
     * 绘制根据Path进行移动的动画
     */
    fun drawPathMove(canvas: Canvas?) {

        var h = height / 3.0f + 50.0f;
        var path = Path();
        path.moveTo(10.0f, h);
        path.lineTo(width + 0.0f, h + 200)
        path.lineTo(width / 2.0f, h + 300)
        path.close()

        var paint = Paint();
        paint.strokeWidth = 5.0f;
        paint.color = Color.parseColor("#ff0000")
        paint.style = Paint.Style.STROKE
        canvas?.drawPath(path, paint)
    }
}