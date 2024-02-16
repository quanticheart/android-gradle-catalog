plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = Config.compileSdk

    signingConfigs {
        create("signingConfigRelease") {
            storeFile = file(KeyHelper.getValue(KeyHelper.KEY_STORE_FILE))
            storePassword = KeyHelper.getValue(KeyHelper.KEY_STORE_PASS)
            keyAlias = KeyHelper.getValue(KeyHelper.KEY_ALIAS)
            keyPassword = KeyHelper.getValue(KeyHelper.KEY_PASS)
        }
    }

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.compileSdk
//        archivesBaseName = "${parent?.name}-$archivesBaseName"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments += "listener" to "leakcanary.FailTestOnLeakRunListener"
    }

    flavorDimensions("appType")
    productFlavors {
        create("_dev") {
            dimension = "appType"
            applicationIdSuffix = ".dev"
            versionNameSuffix = "-dev"

            manifestPlaceholders["appIcon"] = "@mipmap/ic_launcher_prod"
            manifestPlaceholders["appIconRound"] = "@mipmap/ic_launcher_prod_round"

            resValue("string", "app_name", "KotlinDslExample$versionNameSuffix")
            buildConfigField(
                "String",
                "ONESIGNAL_APP_ID",
                "\"${KeyHelper.KEY_ONESIGNAL_APP_ID_DEV}\""
            )
        }
        create("_test") {
            dimension = "appType"
            applicationIdSuffix = ".test"
            versionNameSuffix = "-test"

            manifestPlaceholders["appIcon"] = "@mipmap/ic_launcher_test"
            manifestPlaceholders["appIconRound"] = "@mipmap/ic_launcher_test_round"

            resValue("string", "app_name", "KotlinDslExample$versionNameSuffix")
            buildConfigField(
                "String",
                "ONESIGNAL_APP_ID",
                "\"${KeyHelper.KEY_ONESIGNAL_APP_ID_TEST}\""
            )
        }

        create("_prod") {
            dimension = "appType"
            applicationIdSuffix = ""
            versionNameSuffix = ""

            manifestPlaceholders["appIcon"] = "@mipmap/ic_launcher_prod"
            manifestPlaceholders["appIconRound"] = "@mipmap/ic_launcher_prod_round"

            resValue("string", "app_name", "KotlinDslExample$versionNameSuffix")
            buildConfigField(
                "String",
                "ONESIGNAL_APP_ID",
                "\"${KeyHelper.KEY_ONESIGNAL_APP_ID_PROD}\""
            )
        }
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
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

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
