package io.github.xiaobaicz.log

interface Log {

    fun log(obj: Any?)

    fun log(format: String, vararg args: Any?)

    fun log(t: Throwable)

    fun log(t: Throwable, format: String, vararg args: Any?)

    companion object {

        var tag: String = "Debug"

        @Synchronized
        fun scope(tag: String, block: () -> Unit) {
            val oldTag = Log.tag
            Log.tag = tag
            block()
            Log.tag = oldTag
        }
        
    }

}
