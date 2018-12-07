package com.littonishir.androidxd

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.os.Bundle
import android.telephony.TelephonyManager
import androidx.appcompat.app.AppCompatActivity
import com.littonishir.permissionhelper.PermissionHelper
import com.littonishir.permissionhelper.PermissionInterface

class PermissionActivity : AppCompatActivity(), PermissionInterface {
    private var mPermissionHelper = PermissionHelper(this, this)

    /**
     * 请求权限请求码
     */
    override val permissionCode: Int = 1000
    /**
     * 请求的权限集合
     */
    override val permissions: Array<String> = arrayOf(Manifest.permission.READ_PHONE_STATE, Manifest.permission.RECORD_AUDIO,
            Manifest.permission.CAMERA)
    /**
     * 请求权限成功回调
     */
    override fun permissionSuccess() {}

    /**
     * 请求权限失败回调
     */
    override fun permissionFail() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)
        mPermissionHelper.requestPermissions()
        val systemService = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE) !== PERMISSION_GRANTED) {
        }
        val deviceId = systemService.deviceId

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        //权限请求结果，并已经处理了该回调
        if (mPermissionHelper.requestPermissionsResult(requestCode, permissions, grantResults)) {
            return
        }
    }
}
