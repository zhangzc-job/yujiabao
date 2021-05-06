package com.qdjiaotong.yujiabao.fragment.Service

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.qdjiaotong.yujiabao.activity.mytangkou.MyTangKouActivity
import com.qdjiaotong.yujiabao.databinding.FragmentServiceBinding


class ServiceFragment : Fragment() {

    private var _binding: FragmentServiceBinding? = null
    private val binding get() = _binding!!

//    lateinit var phoneBn: ServiceButton
//    lateinit var fankuiBn: ServiceButton

//    lateinit var recyclerView: RecyclerView

    private var items = listOf<String>(
        "方法1",
        "方法2",
        "方法3",
        "咨询信息1",
        "咨询信息2",
        "咨询信息3",
        "咨询信息4",
        "咨询信息5",
        "咨询信息6",
        "咨询信息7",
        "咨询信息77",
        "咨询信息55",
        "咨询信息5555",
        "咨询信息444",
        "咨询信息3333333"
    ).toMutableList()
    private val adapter = ServiceAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentServiceBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
//        phoneBn = binding.sbPhone
//        fankuiBn = binding.sbFanKui

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.sbPhone.setOnCListener(View.OnClickListener {
            startActivity(Intent(context, MyTangKouActivity::class.java))
        })

        binding.sbFanKui.setOnClickListener {
            startActivity(Intent(context, MyTangKouActivity::class.java))
        }

        binding.serviceRecyclerview.isNestedScrollingEnabled = false

        binding.serviceRecyclerview.layoutManager = LinearLayoutManager(context)

        binding.serviceRecyclerview.adapter = adapter


        adapter.setNewInstance(items)


    }


}