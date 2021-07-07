package com.zzc.chaobaselibrary.http

import java.lang.RuntimeException

class ApiException(var code: Int, override var message: String) : RuntimeException() {
}