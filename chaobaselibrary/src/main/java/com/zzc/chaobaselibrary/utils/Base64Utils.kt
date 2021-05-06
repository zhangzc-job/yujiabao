package com.zzc.chaobaselibrary.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.nio.charset.StandardCharsets
import java.util.Base64.getEncoder

object Base64Utils {

    @RequiresApi(Build.VERSION_CODES.O)
    fun stringToBase64(str: String): String = getEncoder().encodeToString(
        str.toByteArray(
            StandardCharsets.UTF_8
        )
    )


}