package io.github.xiaobaicz.log.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.xiaobaicz.log.Log
import io.github.xiaobaicz.log.log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.tag = "随便"

        log(666)

        log("hello %s", "xiaobai")

        log(RuntimeException("888"))

        log(RuntimeException("888"), "error: %s", "001")

        Log.scope("范围有效") {
            log(666)

            log("hello %s", "xiaobai")

            log(RuntimeException("888"))

            log(RuntimeException("888"), "error: %s", "001")
        }
    }

}