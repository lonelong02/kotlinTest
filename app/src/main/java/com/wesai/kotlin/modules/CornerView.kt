package com.wesai.kotlin.modules

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.Gravity
import android.view.View

/**
 * 圆角视图
 * Created by long
 * on 2017/12/20.
 */
class CornerView : View {
    var radius = 30.0f; //圆角半径
    var location = Gravity.TOP or Gravity.LEFT //位置
    var bgColor = Color.BLACK
    var opacity = 1; //透明度
    var paint = Paint();

    var path = Path();

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        init()
    }


    private fun init() {

        paint.alpha = opacity
        paint.style = Paint.Style.FILL
        paint.isAntiAlias = true //抗锯齿
        paint.color = bgColor
    }

    fun setGravity(gravity: Int) {
        location = gravity;
        invalidate()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)


    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        path.reset();
        //左上
        path.moveTo(0.0f, 0.0f);
        path.lineTo(0.0f, radius);
        path.arcTo(RectF(0.0f, 0.0f, radius * 2, radius * 2), 180.0f, 90.0f, true);
        path.lineTo(0.0f, 0.0f)
        path.close()
        canvas?.drawPath(path, paint);

        //右上
        path.reset()
        path.moveTo(width - radius, 0.0f);
        path.arcTo(RectF(width - radius * 2, 0.0f, width.toFloat(), radius * 2), 270.0f, 90.0f, true);
        path.lineTo(width.toFloat(), 0.0f)
        path.close()
        canvas?.drawPath(path, paint);
    }
}