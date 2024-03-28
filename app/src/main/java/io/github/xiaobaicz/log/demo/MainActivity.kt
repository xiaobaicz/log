package io.github.xiaobaicz.log.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.xiaobaicz.log.Log
import io.github.xiaobaicz.log.log
import io.github.xiaobaicz.log.tag
import io.github.xiaobaicz.log.tagScope

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.setTag("AAA")

        log(666)
        log("hello %s", "xiaobai")
        log(RuntimeException("888"))
        log(RuntimeException("888"), "error: %s", "001")

        tag("BBB").log("????")

        tagScope("CCC") {
            log(9999)
            log("hi %s", "xiaobai")
            log(RuntimeException("234"))
            log(RuntimeException("234"), "error: %s", "007")
        }

    }

}