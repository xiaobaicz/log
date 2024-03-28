package io.github.xiaobaicz.log.android

import io.github.xiaobaicz.log.Log
import io.github.xiaobaicz.log.Tag
import android.util.Log as ALog

class AndroidLog : Log {

    override fun log(tag: Tag, obj: Any?) {
        ALog.d(tag.value, obj.toString())
    }

    override fun log(tag: Tag, format: String, vararg args: Any?) {
        ALog.d(tag.value, String.format(format, *args))
    }

    override fun log(tag: Tag, t: Throwable) {
        ALog.e(tag.value, t.message, t)
    }

    override fun log(tag: Tag, t: Throwable, format: String, vararg args: Any?) {
        ALog.e(tag.value, String.format(format, *args), t)
    }

}