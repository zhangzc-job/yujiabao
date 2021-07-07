package com.zzc.chaobaselibrary.utils

import android.util.Log

object LogUtil {

    private var TAG = "LogUtil"
    private var IS_LOG = false
    private const val MAX_LENGTH = 4000

    /**
     * 设置是否开启打印
     */
    fun setIsLog(isLog: Boolean) {
        IS_LOG = isLog
    }

    fun setIsLog(isLog: Boolean, tag: String) {
        TAG = tag
        IS_LOG = isLog
    }

    fun i(msg: String) {
        if (IS_LOG) {
            val info = autoJumpLogInfo
            val msgLength = msg.length
            var start = 0
            var end = MAX_LENGTH
            for (i in 0..99) {
                if (msgLength > end) {
                    Log.i(TAG, info[0] + info[2] + "--->>" + msg.substring(start, end))
                    start = end
                    end += MAX_LENGTH
                } else {
                    Log.i(TAG, info[1] + info[2] + "--->>" + msg.substring(start, msgLength))
                    break
                }
            }
        }
    }


    fun i(tag: String?, msg: String) {
        if (IS_LOG) {
            val info = autoJumpLogInfo
            val msgLength = msg.length
            var start = 0
            var end = MAX_LENGTH
            for (i in 0..99) {
                if (msgLength > end) {
                    Log.i(tag, info[1] + info[2] + "--->>" + msg.substring(start, end))
                    start = end
                    end += MAX_LENGTH
                } else {
                    Log.i(tag, info[1] + info[2] + "--->>" + msg.substring(start, msgLength))
                    break
                }
            }
        }
    }

    fun d(msg: String) {
        if (IS_LOG) {
            val info = autoJumpLogInfo
            val msgLength = msg.length
            var start = 0
            var end = MAX_LENGTH
            for (i in 0..99) {
                if (msg.length > end) {
                    Log.d(TAG, info[1] + info[2] + "--->>" + msg.substring(start, end))
                    start = end
                    end += MAX_LENGTH
                } else {
                    Log.d(TAG, info[1] + info[2] + "--->>" + msg.substring(start, msgLength))
                    break
                }
            }
        }
    }

    fun d(tag: String?, msg: String) {
        if (IS_LOG) {
            val info = autoJumpLogInfo
            val msgLength = msg.length
            var start = 0
            var end = MAX_LENGTH
            for (i in 0..99) {
                if (msgLength > end) {
                    Log.d(tag, info[1] + info[2] + " --->> " + msg.substring(start, end))
                    start = end
                    end += MAX_LENGTH
                } else {
                    Log.d(tag, info[1] + info[2] + " --->> " + msg.substring(start, msgLength))
                    break
                }
            }
        }
    }

    fun e(msg: String) {
        if (IS_LOG) {
            val info = autoJumpLogInfo
            val msgLength = msg.length
            var start = 0
            var end = MAX_LENGTH
            for (i in 0..99) {
                if (msgLength > end) {
                    Log.e(TAG, info[1] + info[2] + " --->> " + msg.substring(start, end))
                    start = end
                    end += MAX_LENGTH
                } else {
                    Log.e(TAG, info[1] + info[2] + " --->> " + msg.substring(start, msgLength))
                    break
                }
            }
        }
    }

    fun e(tag: String?, msg: String) {
        if (IS_LOG) {
            val info = autoJumpLogInfo
            val msgLength = msg.length
            var start = 0
            var end = MAX_LENGTH
            for (i in 0..99) {
                if (msgLength > end) {
                    Log.e(tag, info[1] + info[2] + " --->> " + msg.substring(start, end))
                    start = end
                    end += MAX_LENGTH
                } else {
                    Log.e(tag, info[1] + info[2] + " --->> " + msg.substring(start, msgLength))
                    break
                }
            }
        }
    }

    /**
     * 获取打印信息所在的方法名，行号等信息
     */
    private val autoJumpLogInfo: Array<String>
        get() {
            val info = arrayOf("", "", "")
            val elements = Thread.currentThread().stackTrace
            info[0] = elements[4].className.substring(elements[4].className.lastIndexOf(".") + 1)
            info[1] = elements[4].methodName
            info[2] = "(" + elements[4].fileName + ":" + elements[4].lineNumber + ")"
            return info
        }

}