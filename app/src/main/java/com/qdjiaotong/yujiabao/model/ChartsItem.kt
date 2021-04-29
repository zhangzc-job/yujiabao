package com.qdjiaotong.yujiabao.model

data class ChartsItem(
    val legend: List<String>,
    val seriesData: List<SeriesData>,
    val title: String,
    val xData: List<String>
)

data class SeriesData(
    val code: String,
    val `data`: List<Float>,
    val isNewRecord: Boolean,
    val name: String,
    val unit: String
)