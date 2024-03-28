package io.github.xiaobaicz.log

private val logList by lazy { loadSpi<Log>() }

fun log(obj: Any?) {
    logList.forEach { it.log(Log.tag, obj) }
}

fun log(format: String, vararg args: Any?) {
    logList.forEach { it.log(Log.tag, format, *args) }
}

fun log(t: Throwable) {
    logList.forEach { it.log(Log.tag, t) }
}

fun log(t: Throwable, format: String, vararg args: Any?) {
    logList.forEach { it.log(Log.tag, t, format, *args) }
}

fun Tag.log(obj: Any?) {
    logList.forEach { it.log(this, obj) }
}

fun Tag.log(format: String, vararg args: Any?) {
    logList.forEach { it.log(this, format, *args) }
}

fun Tag.log(t: Throwable) {
    logList.forEach { it.log(this, t) }
}

fun Tag.log(t: Throwable, format: String, vararg args: Any?) {
    logList.forEach { it.log(this, t, format, *args) }
}

fun tag(tag: String): Tag = Tag(tag)

fun tagScope(tag: String, block: Tag.() -> Unit) {
    tag(tag).block()
}
