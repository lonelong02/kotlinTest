package com.wesai.kotlin.utils

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog

/**
 * Created by long on 2017/11/16.
 */

object PermissionUtils {

    /*写权限*/
    val WRITE_EXTERNAL_STORAGE = "Manifest.permission.WRITE_EXTERNAL_STORAGE"

    /**
     *SD卡权限申请
     */
    fun requestSdPermission(context: Context): Boolean {
        if (!requestPermission(context, WRITE_EXTERNAL_STORAGE)) {
            AlertDialog.Builder(context).setTitle("存储权限申请").setMessage("请在-应用设置-权限-中，允许使用存储权限来保存用户数据")
                    .setPositiveButton("立即开启", { dialog: DialogInterface?, which: Int ->
                        dialog?.dismiss();
                        var intent = Intent();
                        intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                        intent.data = Uri.fromParts("package", context.packageName, null)
                        context.startActivity(intent)
                        return@setPositiveButton
                    }).setNegativeButton("取消", { dialogInterface: DialogInterface, i: Int ->
                dialogInterface.dismiss()
                return@setNegativeButton
            }).setCancelable(false).show()
            return false
        } else {
            return true
        }

    }

    /*请求权限*/
    private fun requestPermission(context: Context, perm: String): Boolean {
        if (Build.VERSION.SDK_INT <= 23) {
            return true;
        }
        return PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(context, WRITE_EXTERNAL_STORAGE)
    }

    private fun showDialog(context: Context, title: String, msg: String) {

    }

}
