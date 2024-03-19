~~~ kotlin
dependencies {
    implementation("io.github.xiaobaicz:log:0.0.1")
    debugImplementation("io.github.xiaobaicz:log-android:0.0.1")
}
~~~

~~~ kotlin
log(Any)
log(String, Any...)
log(Throwable)
log(Throwable, String, Any...)
~~~