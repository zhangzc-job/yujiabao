package com.zzc.chaobaselibrary.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonParseException
import com.zzc.chaobaselibrary.http.ApiException
import com.zzc.chaobaselibrary.utils.LogUtil
import com.zzc.chaobaselibrary.utils.ToastUtils
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

typealias Block<T> = suspend (CoroutineScope) -> T
typealias Error = suspend (Exception) -> Unit
typealias Cancel = suspend (Exception) -> Unit

open class BaseViewModel : ViewModel() {

    val needLogin = MutableLiveData<Boolean>().apply {
        value = false
    }

    /**
     * 创建并执行协程 Coroutines
     * @param block 协程中执行
     * @param error 错误时执行
     * @param cancel 取消时执行
     * @param showErrorToast 是否弹出错误吐司
     * @return Job API 文档 https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines/-job/index.html
     *
     * CoroutineScope.launch 函数返回的是一个 Job 对象，代表一个异步的任务。
     * viewModelScope 也是继承 CoroutineScope的
     * Job 具有生命周期并且可以取消。
     * Job 还可以有层级关系，一个Job可以包含多个子Job，当父Job被取消后，所有的子Job也会被自动取消；
     * 当子Job被取消或者出现异常后父Job也会被取消。
     */
    protected fun launch(
        block: Block<Unit>,
        error: Error? = null,
        cancel: Cancel? = null,
        showErrorToast: Boolean = true
    ): Job {
        return viewModelScope.launch {
            try {
                block.invoke(this)
            } catch (e: Exception) {
                when (e) {
                    is CancellationException -> {
                        cancel?.invoke(e)
                    }
                    else -> {
                        onError(e, showErrorToast)
                        error?.invoke(e)
                    }
                }
            }
        }
    }


    private fun onError(e: java.lang.Exception, showErrorToast: Boolean) {
        when (e) {
            is ApiException -> {
                when (e.code) {
                    -1001 -> {
                        if (showErrorToast) ToastUtils.show(e.message)
                        needLogin.value = true
                    }
                    //其他错误
                    else -> {
                        if (showErrorToast) ToastUtils.show(e.message)
                    }
                }
                LogUtil.e(e.message)
            }
            //网络请求失败
            is ConnectException, is SocketTimeoutException, is UnknownHostException, is HttpException -> {
                if (showErrorToast) ToastUtils.show("网络请求失败")
                LogUtil.e("网络请求失败" + e.message)
            }

            //数据解析错误
            is JsonParseException -> {
                if (showErrorToast) ToastUtils.show("数据解析错误")
                LogUtil.e("数据解析错误" + e.message)
            }

            else -> {
                if (showErrorToast) ToastUtils.show(e.message ?: return)
                LogUtil.e(e.message ?: return)
            }
        }
    }

}