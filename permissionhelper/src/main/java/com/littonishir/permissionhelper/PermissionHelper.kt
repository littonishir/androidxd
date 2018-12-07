package com.littonishir.permissionhelper

import android.app.Activity
import android.content.pm.PackageManager

/**
 * 动态权限帮助类
 */
class PermissionHelper(private val mActivity: Activity, private val mPermissionInterface: PermissionInterface) {

    /**
     * 开始请求权限。
     * 方法内部已经对Android M 或以上版本进行了判断，外部使用不再需要重复判断。
     * 如果设备还不是M或以上版本，则也会回调到requestPermissionsSuccess方法。
     */
    fun requestPermissions() {
        val deniedPermissions = PermissionUtil.getDeniedPermissions(mActivity, mPermissionInterface.permissions)
        if (deniedPermissions != null && deniedPermissions.isNotEmpty()) {
            PermissionUtil.requestPermissions(mActivity, deniedPermissions, mPermissionInterface.permissionCode)
        } else {
            mPermissionInterface.permissionSuccess()
        }
    }

    /**
     * 在Activity中的onRequestPermissionsResult中调用
     * @param requestCode
     * @param permissions
     * @param grantResults
     * @return true 代表对该requestCode感兴趣，并已经处理掉了。false 对该requestCode不感兴趣，不处理。
     */
    fun requestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray): Boolean {
        if (requestCode == mPermissionInterface.permissionCode) {
            var isAllGranted = true//是否全部权限已授权
            for (result in grantResults) {
                if (result == PackageManager.PERMISSION_DENIED) {
                    isAllGranted = false
                    break
                }
            }
            if (isAllGranted) {
                //已全部授权
                mPermissionInterface.permissionSuccess()
            } else {
                //权限有缺失
                mPermissionInterface.permissionFail()
            }
            return true
        }
        return false
    }

}

