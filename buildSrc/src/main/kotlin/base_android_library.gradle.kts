plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = Config.compileSdk
    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.compileSdk
//        archivesBaseName = "${parent?.name}-$archivesBaseName"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments += "listener" to "leakcanary.FailTestOnLeakRunListener"
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
//    implementation(Kotlin.jdk8)
//    implementation(Rx.java)
//    implementation(Rx.kotlin)
//    implementation(DataBinding.lint)
//    implementation(Hilt.android)
//    kapt(Hilt.compiler)
//    implementation(Hilt.AndroidX.viewModel)
//    kapt(Hilt.AndroidX.compiler)
//    debugImplementation(LeakCanary.android)
//
//    testImplementation(Test.junit)
//    testImplementation(Test.mockito)
//    testImplementation(Test.mockitoInline)
//    kaptTest(DataBinding.compiler)
//
//    androidTestImplementation(Test.junit)
//    androidTestImplementation(LeakCanary.instrumentation)
}
