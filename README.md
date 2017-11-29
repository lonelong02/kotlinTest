# kotlinTest
一、kotlin语言练习
二、公共的ViewPager组件：实现视图与数据绑定的剥离
/**
 *提供View与绑定数据操作接口
 * Created by long on 2017/11/29.
 */
abstract class TypeCall<T> {
    /**
     * 提供视图
     */
    abstract fun getView(): View;

    /**
     * 绑定数据
     */
    abstract fun onBind(view: View?, mData: T?);
}

使用：
     viewPager.setData(list, object : TypeCall<String>() {
            override fun onBind(view: View?, mData: String?) {
                if (view is TextView) {
                    view.setText(mData)
                    view.setTextColor(Color.WHITE)
                    view.gravity = Gravity.CENTER
                }
            }
            override fun getView(): View {
                var view = TextView(this@AnimAndViewsActivity);
                return view
            }


        })

