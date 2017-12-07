package com.wesai.kotlin.activities

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialog
import android.view.View
import android.view.Window
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import com.wesai.kotlin.BaseActivity
import com.wesai.kotlin.R
import kotlinx.android.synthetic.main.activity_bottomsheetbehavior.*

class BottomSheetBehaviorActivity : BaseActivity() {

    lateinit var behavior: BottomSheetBehavior<View>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottomsheetbehavior)
        behavior = BottomSheetBehavior.from(bottomView);
        behavior.state = BottomSheetBehavior.STATE_HIDDEN


    }

    fun myOnClick(view: View) {
        when (view.id) {
            R.id.but1 -> {
                behavior.state = if (behavior.state == BottomSheetBehavior.STATE_COLLAPSED) BottomSheetBehavior.STATE_HIDDEN else BottomSheetBehavior.STATE_COLLAPSED
//                moveTaskToBack(true)

            }

            R.id.but2 -> {
                var dialog = BottomSheetDialog(this)
                var view = View.inflate(this, R.layout.layout_bottomsheet_, null);
                var webView = view.findViewById<WebView>(R.id.webView)
                webView.webViewClient = object : WebViewClient() {
                    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
                    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                        view?.loadUrl(request?.url.toString())
                        return true
                    }
                }
                webView.loadUrl("http://www.baidu.com");
                dialog.setContentView(view);
                var bottomsheetView = dialog.delegate.findViewById<View>(R.id.bottomsheetView);
                var behavior = if (bottomsheetView != null) BottomSheetBehavior.from(bottomsheetView) else null;

                behavior?.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                    override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    }

                    override fun onStateChanged(bottomSheet: View, newState: Int) {
                        when (newState) {
                            BottomSheetBehavior.STATE_HIDDEN -> {
                                dialog.dismiss();
                                behavior.state = BottomSheetBehavior.STATE_COLLAPSED
                            }
                            BottomSheetBehavior.STATE_COLLAPSED -> {
                                behavior.peekHeight = windowManager.defaultDisplay.height * 9 / 10;
                            }
                        }

                    }

                })

                dialog.show()


            }
        }
    }


}