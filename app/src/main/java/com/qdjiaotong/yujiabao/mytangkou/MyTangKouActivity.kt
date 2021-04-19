package com.qdjiaotong.yujiabao.mytangkou

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.qdjiaotong.yujiabao.R

class MyTangKouActivity : AppCompatActivity() {


    val tangKouList = ArrayList<TangKouItem>()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_tang_kou)
        initTangkou()
        val layoutManager = LinearLayoutManager(this)
        recyclerView = findViewById(R.id.tangKouRv)

        recyclerView.layoutManager = layoutManager
        val adapter = TangKouAdapter(tangKouList)
        recyclerView.adapter = adapter
    }


    private fun initTangkou() {
        repeat(2) {
            tangKouList.add(TangKouItem("2012", "99999999999999", "北京大城市"))
            tangKouList.add(TangKouItem("2012", "dddddddd99", "北京大城市"))
            tangKouList.add(TangKouItem("2012", "999966666666999999", "北京大城市"))
            tangKouList.add(TangKouItem("2012", "333333333339999999", "北京大城市"))
            tangKouList.add(TangKouItem("2012", "2222222222999999", "北京大城市"))
        }
    }


}