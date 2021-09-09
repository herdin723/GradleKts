# GradleKts
gradle脚本使用Kotlin 编写



[TOC]

# 更改原则：

- 单引号 → 双引号
- 变量 → 加等号
- 对象 → 加括弧

# 1.更改setting.gradle

```kotlin
include (":app")
include (":appLib")
```



# 2.更改build.gradle

```kotlin
  classpath ("com.android.tools.build:gradle:7.0.2")
  classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30")
```

```kotlin
tasks.register("clean", Delete::class.java){
    delete(rootProject.buildDir)
}
```



# 3.更改app的build.gradle

```kotlin
plugins {
    id ("com.android.application")
    id ("kotlin-android")
}
```



```kotlin
android {
    compileSdk =  30

    defaultConfig {
        applicationId =  "com.herdin.android.gradlekts"
        minSdk = 21
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled =  false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
```

```kotlin
dependencies {

    implementation ("androidx.core:core-ktx:1.3.2")
    implementation ("androidx.appcompat:appcompat:1.3.1")
    implementation ("com.google.android.material:material:1.4.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.0.4")

    implementation (project(mapOf("path" to ":appLib")))

    testImplementation ("junit:junit:4.+")
    androidTestImplementation ("androidx.test.ext:junit:1.1.2")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.3.0")
}
```



# 4.更改lib的build.gradle

```kotlin
plugins {
    id ("com.android.library")
    id ("kotlin-android")
}
```

```kotlin
android {
    compileSdk = 30

    defaultConfig {
        minSdk = 21
        targetSdk = 30
        //没有该字段
//        versionCode 1
//        versionName "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles ("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled =  false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
```

```kotlin
dependencies {

    implementation ("androidx.core:core-ktx:1.3.2")
    implementation ("androidx.appcompat:appcompat:1.3.1")
    implementation ("com.google.android.material:material:1.4.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.0.4")

    testImplementation ("junit:junit:4.+")
    androidTestImplementation ("androidx.test.ext:junit:1.1.2")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.3.0")
}
```

