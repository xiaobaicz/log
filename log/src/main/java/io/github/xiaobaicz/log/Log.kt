package io.github.xiaobaicz.log

interface Log {

    fun log(tag: Tag, obj: Any?)

    fun log(tag: Tag, format: String, vararg args: Any?)

    fun log(tag: Tag, t: Throwable)

    fun log(tag: Tag, t: Throwable, format: String, vararg args: Any?)

    companion object {
        internal var tag: Tag = Tag("Debug")
        fun setTag(tag: String) {
            Log.tag = Tag(tag)
        }
    }

}
