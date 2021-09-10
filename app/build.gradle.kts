import com.herdin.depend.plugin.*;
plugins {
    id ("com.android.application")
    id ("kotlin-android")
}

android {
    compileSdk =  BuildConfig.compileSdk

    defaultConfig {
        applicationId =  "com.herdin.android.gradlekts"
        minSdk = BuildConfig.minSdk
        targetSdk = BuildConfig.targetSdk
        versionCode = BuildConfig.versionCode
        versionName = BuildConfig.versionName

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

dependencies {

    implementation (AndroidX.ktx)
    implementation (AndroidX.appcompat)
    implementation (AndroidX.constraintlayout)
    implementation (Google.material)

    implementation (project(mapOf("path" to ":appLib")))
//    implementation (project(":appLib"))


    testImplementation (AndroidTest.junit)
    androidTestImplementation (AndroidTest.ext_junit)
    androidTestImplementation (AndroidTest.espresso_core)
}