package com.qdjiaotong.yujiabao.fragment.Service

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.qdjiaotong.yujiabao.R
import com.qdjiaotong.yujiabao.baseview.ServiceButton
import com.qdjiaotong.yujiabao.databinding.FragmentServiceBinding
import com.qdjiaotong.yujiabao.mytangkou.MyTangKouActivity


class ServiceFragment : Fragment() {

    private var _binding: FragmentServiceBinding? = null
    private val binding get() = _binding!!

//    lateinit var phoneBn: ServiceButton
//    lateinit var fankuiBn: ServiceButton

//    lateinit var recyclerView: RecyclerView

    private val items= listOf<String>("dddddddddddd","aaaaaaaaaaaaa","cccccccccccccc","dddddddddddd","aaaaaaaaaaaaa","cccccccccccccc","dddddddddddd","aaaaaaaaaaaaa","cccccccccccccc","dddddddddddd","aaaaaaaaaaaaa","cccccccccccccc")
    private val adapter=ServiceAdapter()

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

        binding.serviceRecyclerview.isNestedScrollingEnabled=false

        binding.serviceRecyclerview.layoutManager=LinearLayoutManager(context)

        binding.serviceRecyclerview.adapter=adapter


        adapter.setNewData(items)



    }


}