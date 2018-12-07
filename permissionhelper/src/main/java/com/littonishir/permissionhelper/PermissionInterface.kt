package com.littonishir.permissionhelper

/**
 * 权限请求接口
 */
interface PermissionInterface {

    /**
     * 请求权限请求码
     */
    val permissionCode: Int

    /**
     * 请求的权限集合
     */
    val permissions: Array<String>

    /**
     * 请求权限成功回调
     */
    fun permissionSuccess()

    /**
     * 请求权限失败回调
     */
    fun permissionFail()

}

