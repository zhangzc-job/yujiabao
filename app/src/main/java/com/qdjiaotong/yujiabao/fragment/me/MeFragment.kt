package com.qdjiaotong.yujiabao.fragment.me

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.qdjiaotong.yujiabao.YuJiaBaoApplication
import com.qdjiaotong.yujiabao.databinding.FragmentMeBinding
import com.wildma.pictureselector.PictureBean
import com.wildma.pictureselector.PictureSelector
import com.zzc.chaobaselibrary.kotlinding.showToast

class MeFragment : Fragment() {

    private var _binding: FragmentMeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.meHomeCiv.setOnClickListener {
            "ddddd".showToast(YuJiaBaoApplication.context,Toast.LENGTH_SHORT)
            PictureSelector.create(this,PictureSelector.SELECT_REQUEST_CODE).selectPicture(true,200,200,1,1)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==PictureSelector.SELECT_REQUEST_CODE){
            if(data!=null){
                val pictureBean=data.getParcelableExtra<PictureBean>(PictureSelector.PICTURE_RESULT)
                if (pictureBean != null) {
                    if(pictureBean.isCut){
                        binding.meHomeCiv.setImageBitmap(BitmapFactory.decodeFile(pictureBean.path))
                    }else{

                    }
                }
            }
        }
    }

}