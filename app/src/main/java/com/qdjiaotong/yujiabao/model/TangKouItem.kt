package com.qdjiaotong.yujiabao.model

import java.io.Serializable
import java.util.*

data class TangKouItemItem(
    val createBy: String,
    val createDate: String,
    val fishpondId: String,
    val id: String,
    val isNewRecord: Boolean,
    val updateBy: String,
    val updateDate: String,
    val user: User,
    val userId: String,
    val yjhFishpond: YjhFishpond
)


data class YjhFishpond(
    val code: String,
    val createBy: String,
    val createDate: String,
    val id: String,
    val isNewRecord: Boolean,
    val name: String,
    val oxygenUnit: String,
    val oxygenVal: Double,
    val remarks: String,
    val sort: Int,
    val status: String,
    val temperatureUnit: String,
    val temperatureVal: Double,
    val updateBy: String,
    val updateDate: String
)

data class TangKouItem(
    val id: String = "aaa",
    val fishpondId: String = "bbbb",
    val yjhFishpond: yjhFish
) : Serializable {
    fun getStartTime(): Date = Date()


}

data class yjhFish(
    val id: String = "666",
    val createDate: String = "777",
    val code: String = "888",
    val name: String = "999"
) : Serializable {

}