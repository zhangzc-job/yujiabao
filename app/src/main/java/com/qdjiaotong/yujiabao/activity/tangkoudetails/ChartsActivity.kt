package com.qdjiaotong.yujiabao.activity.tangkoudetails

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.Legend.LegendForm
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis.AxisDependency
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.qdjiaotong.yujiabao.BaseActivity
import com.qdjiaotong.yujiabao.databinding.ActivityChartsBinding
import com.qdjiaotong.yujiabao.model.ChartsItem
import com.zzc.chaobaselibrary.base.ZBaseActivity
import com.zzc.chaobaselibrary.kotlinding.showToast
import java.util.*

class ChartsActivity : ZBaseActivity() {


    lateinit var viewModel: ChartsViewModel
    lateinit var cBinding: ActivityChartsBinding
    lateinit var chart: LineChart
    var id: String = ""

    override fun initView() {
        cBinding = ActivityChartsBinding.inflate(layoutInflater)
        id = intent.getStringExtra("id").toString()
        viewModel = ViewModelProvider(this).get(ChartsViewModel::class.java)
        chart = cBinding.chart1

    }

    override fun getLayoutView(): View {
        return cBinding.root
    }

    override fun initListener() {

        viewModel.charts.observe(this, androidx.lifecycle.Observer<ChartsItem> {
            if (it.seriesData.isNotEmpty() && it.xData.isNotEmpty()) {
                showData(it)
            } else {
                "暂无数据".showToast(this)
            }
        })

        viewModel.getDetails(id)
    }

    fun showData(item: ChartsItem) {

        val xData = item.xData
        val d1 = item.seriesData[0].data
        val d2 = item.seriesData[1].data

        chart.description.isEnabled = false
        chart.setTouchEnabled(true)

        chart.dragDecelerationFrictionCoef = 1f
        chart.isDragEnabled = true
        chart.setScaleEnabled(true)
        chart.setDrawGridBackground(false)
        chart.isHighlightPerDragEnabled = true
        // if disabled, scaling can be done on x- and y-axis separately
        chart.setPinchZoom(true)
        // set an alternative background color
        chart.setBackgroundColor(Color.WHITE)
        chart.animateX(1500)
        // get the legend (only possible after setting data)  获取图例（仅在设置数据后才可能）
        val l = chart.legend
        l.form = LegendForm.LINE
//        l.typeface = tfLight
        l.textSize = 11f
        l.textColor = Color.BLACK
        l.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.LEFT
        l.orientation = Legend.LegendOrientation.HORIZONTAL
        l.setDrawInside(false)
//        l.setYOffset(11f);
        val xAxis = chart.xAxis
//        xAxis.typeface = tfLight
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.textSize = 8f
        xAxis.granularity = 1f
        xAxis.isGranularityEnabled = true
        xAxis.textColor = Color.BLACK
        xAxis.setDrawGridLines(false)
        xAxis.setDrawAxisLine(false)
        xAxis.labelRotationAngle = 10f
        xAxis.valueFormatter = object : ValueFormatter() {
            override fun getAxisLabel(value: Float, axis: AxisBase?): String {
                Log.i("ddddddd", value.toString())
                return "       " + xData[value.toInt()] + "             "
            }
        }

        val leftAxis = chart.axisLeft
//        leftAxis.typeface = tfLight
        leftAxis.textColor = ColorTemplate.getHoloBlue()
        leftAxis.axisMaximum = 100f
        leftAxis.axisMinimum = -30f
        leftAxis.setDrawGridLines(true)
        leftAxis.isGranularityEnabled = true

        val rightAxis = chart.axisRight
//        rightAxis.typeface = tfLight
        rightAxis.textColor = Color.RED
        rightAxis.axisMaximum = 130f
        rightAxis.axisMinimum = 0f
        rightAxis.setDrawGridLines(false)
        rightAxis.setDrawZeroLine(false)
        rightAxis.isGranularityEnabled = false

        setData(5, 30.toFloat(), d1, d2,item.legend)
//        chart.invalidate()

    }

    private fun setData(count: Int, range: Float, d1: List<Float>, d2: List<Float>,index:List<String>) {
        val values1 = ArrayList<Entry>()
//        for (i in 0 until count) {
        for (i in d1.indices) {
//            val `val` = (Math.random() * (range / 2f)).toFloat() + 50
            val `val` = d1[i] + 50 + Math.random()*10
            values1.add(Entry(i.toFloat(), `val`.toFloat()))
        }
        val values2 = ArrayList<Entry>()
//        for (i in 0 until count) {
        for (i in d2.indices) {
//            val `val` = (Math.random() * range).toFloat() + 10
            val `val` = d2[i] + 10
            values2.add(Entry(i.toFloat(), `val`))
        }
//        val values3 = ArrayList<Entry>()
//        for (i in 0 until count) {
//            val `val` = (Math.random() * range).toFloat() + 500
//            values3.add(Entry(i.toFloat(), `val`))
//        }
        val set1: LineDataSet
        val set2: LineDataSet
//        val set3: LineDataSet
        if (chart.data != null &&
            chart.data.dataSetCount > 0
        ) {
            set1 = chart.data.getDataSetByIndex(0) as LineDataSet
            set2 = chart.data.getDataSetByIndex(1) as LineDataSet
//            set3 = chart.data.getDataSetByIndex(2) as LineDataSet
            set1.values = values1
            set2.values = values2
//            set3.values = values3
            chart.data.notifyDataChanged()
            chart.notifyDataSetChanged()
        } else {
            // create a dataset and give it a type
            set1 = LineDataSet(values1, index[0])
            set1.axisDependency = AxisDependency.LEFT
            set1.color = ColorTemplate.getHoloBlue()
            set1.setCircleColor(Color.BLACK)
            set1.lineWidth = 2f
            set1.circleRadius = 3f
            set1.fillAlpha = 65
            set1.fillColor = ColorTemplate.getHoloBlue()
            set1.highLightColor = Color.rgb(244, 117, 117)
            set1.setDrawCircleHole(false)
            //set1.setFillFormatter(new MyFillFormatter(0f));
            //set1.setDrawHorizontalHighlightIndicator(false);
            //set1.setVisible(false);
            //set1.setCircleHoleColor(Color.WHITE);

            // create a dataset and give it a type
            set2 = LineDataSet(values2, index[1])
            set2.axisDependency = AxisDependency.RIGHT
            set2.color = Color.RED
            set2.setCircleColor(Color.BLACK)
            set2.lineWidth = 2f
            set2.circleRadius = 3f
            set2.fillAlpha = 65
            set2.fillColor = Color.RED
            set2.setDrawCircleHole(false)
            set2.highLightColor = Color.rgb(244, 117, 117)
            //set2.setFillFormatter(new MyFillFormatter(900f));

//            set3 = LineDataSet(values3, "金子")
//            set3.axisDependency = AxisDependency.RIGHT
//            set3.color = Color.YELLOW
//            set3.setCircleColor(Color.BLACK)
//            set3.lineWidth = 2f
//            set3.circleRadius = 3f
//            set3.fillAlpha = 65
//            set3.fillColor = ColorTemplate.colorWithAlpha(Color.YELLOW, 200)
//            set3.setDrawCircleHole(false)
//            set3.highLightColor = Color.rgb(244, 117, 117)

            // create a data object with the data sets
//            val data = LineData(set1, set2, set3)
            val data = LineData(set1, set2)
            data.setValueTextColor(Color.BLACK)
            data.setValueTextSize(9f)

            // set data
            chart.data = data
        }
    }

}