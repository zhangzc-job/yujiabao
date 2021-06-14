package com.qdjiaotong.yujiabao.model

import com.google.gson.annotations.SerializedName

data class DeviceItem(
    val code: String,
    val createBy: String,
    val createDate: String,
    val deviceTypeId: String,
    val fishpondId: String,
    val id: String,
    val isNewRecord: Boolean,
    val name: String,
    val status: String,
    val updateBy: String,
    val updateDate: String,
    val yjhDeviceType: YjhDeviceType,
    val yjhFishpond: YjhFishpond,
    val `val`:Double
)

data class YjhDeviceType(
    val code: String,
    val createBy: String,
    val createDate: String,
    val id: String,
    val isNewRecord: Boolean,
    val name: String,
    val remarks: String,
    val unit: String,
    val updateBy: String,
    val updateDate: String
)

