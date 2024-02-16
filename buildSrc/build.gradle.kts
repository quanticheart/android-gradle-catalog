plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(gradleApi())
    implementation(libs.gradle)
    implementation(libs.gradleApi)
    implementation(libs.kotlinAllPpen)
    implementation(libs.kotlinGradlePlugin)
}
