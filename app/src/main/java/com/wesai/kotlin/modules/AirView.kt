package com.wesai.kotlin.modules

import android.animation.*
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator

/**
 * Created by long on 2017/11/15.
 */
class AirView : View {
    var backColor = 0xFFDC143C.toInt(); //背景颜色
    val panNum = 15; //扇叶的个数
    val panGap = 10;//扇页的间隔角度
    val panH = 60.0F;//扇叶所在矩形的高度px
    //动画参数
    var startAnim = 0.0f; //扇叶的启动角度
    val time = 10 * 1000L//一分钟
    var maxValue = 500 //pm2.5的初始值
        set(value) {
            field = value;
            invalidate()//动画更新
        }


    /*背景颜色*/
    val mode1Color = intArrayOf(
            0xFFDC143C.toInt(),
            0xFF8A2BE2.toInt(),
            0xFF00CED1.toInt(),
            0xFF87CEFA.toInt(),
            0xFF1E90FF.toInt()
    )

    constructor(cxt: Context) : this(cxt, null) {}
    constructor(cxt: Context, attr: AttributeSet?) : super(cxt, attr) {
    }

    /*启动动画*/
    fun startAnim() {

//        var holder = PropertyValuesHolder.ofInt("maxValue", maxValue, 0)
//        var holder2 = PropertyValuesHolder.ofFloat("startAnim", startAnim, 360.0F)
//        var anim = ObjectAnimator.ofPropertyValuesHolder(this, holder, holder2);
//        anim.duration = time;
//        anim.interpolator = LinearInterpolator()
//        anim.start()

        maxValue = 500
        startAnim = 0.0f
        val anim1 = ObjectAnimator.ofInt(this, "maxValue", maxValue, 0);
        val anim2 = ObjectAnimator.ofFloat(this, "startAnim", startAnim, 360.0F)
        anim1.duration = time;
        val tem = 5
        anim2.repeatCount = tem;
        anim2.duration = time / tem
        val animSet = AnimatorSet();
        animSet.playTogether(anim1, anim2)
        animSet.interpolator = LinearInterpolator()
        animSet.start()
        anim1.setEvaluator(object : TypeEvaluator<Int> {
            override fun evaluate(fraction: Float, startValue: Int?, endValue: Int?): Int {
                var result = (startValue!! + (endValue!! - startValue) * fraction).toInt()
                when (result) {//背景色改变
                    in 400..500 -> backColor = mode1Color[0]
                    in 300..400 -> backColor = mode1Color[1]
                    in 200..300 -> backColor = mode1Color[2]
                    in 100..200 -> backColor = mode1Color[3]
                    in 0..100 -> backColor = mode1Color[4]
                }
                return result;
            };

        })


    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas == null)
            return
        //绘制背景
        canvas.drawColor(backColor);
        /*绘制圆*/
        drawCircle(canvas);
    }

    /*绘制圆*/
    private fun drawCircle(canvas: Canvas) {
        var r = Math.min(width, height) * 70 / 200.0f;
        var cx = width / 2.0f;
        var cy = height / 2.0f;
        var paint = Paint();
        paint.color = Color.WHITE
        paint.strokeWidth = 10.0f
        paint.style = Paint.Style.STROKE
        //绘制圆形
        canvas.drawCircle(cx, cy, r, paint);

        val path = Path();
        path.moveTo(0.0f, cy);
        path.lineTo(width.toFloat(), cy);
        var msg = maxValue.toString();
        paint.strokeWidth = 5.0f
        paint.style = Paint.Style.FILL
        paint.textSize = 100.0f
        /*字体居中*/
        paint.textAlign = Paint.Align.CENTER
        /*绘制中间值*/
        canvas.drawTextOnPath(msg, path, 0f, 0f, paint);

        /*扇形风页*/
        paint.reset()
        paint.style = Paint.Style.STROKE;
        paint.strokeWidth = panH;
        paint.color = Color.WHITE;
        var panAngle = (360.0f - panNum * panGap) / panNum;
        var rectF = RectF(cx - r + panH / 2, cy - r + panH / 2, cx + r - panH / 2, cy + r - panH / 2);
        var curAngle = startAnim
        while (curAngle < 360 + startAnim) {
            canvas.drawArc(rectF, curAngle, panAngle, false, paint)
            curAngle += panAngle + panGap;
        }
    }

}