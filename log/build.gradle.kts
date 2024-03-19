plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    `maven-publish`
    signing
}

android {
    namespace = "io.github.xiaobaicz.log"
    compileSdk = 34

    defaultConfig {
        minSdk = 23

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "io.github.xiaobaicz"
            artifactId = "log"
            version = "0.0.1"

            afterEvaluate {
                from(components["release"])
            }

            pom {
                name = "log"
                description = "android log lib"
                url = "https://github.com/xiaobaicz/log"
                licenses {
                    license {
                        name = "The Apache License, Version 2.0"
                        url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
                    }
                }
                developers {
                    developer {
                        name = "bocheng.lao"
                        email = "xiaojinjincz@outlook.com"
                        organization = "bocheng.lao"
                        organizationUrl = "https://xiaobaicz.github.io"
                    }
                }
                scm {
                    connection = "scm:git:https://github.com/xiaobaicz/log.git"
                    developerConnection = "scm:git:https://github.com/xiaobaicz/log.git"
                    url = "https://github.com/xiaobaicz/log"
                }
            }
        }
    }
    repositories {
        maven {
            url = uri("../build/maven")
        }
    }
}

signing {
    sign(publishing.publications["release"])
}