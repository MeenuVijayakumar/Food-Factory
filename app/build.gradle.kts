plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.applab.foodfactory"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.applab.foodfactory"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        val API_KEY = "51343491-1c1ae3a22f48d84ecea695dcf"
        buildConfigField("String", "API_KEY", "\"$API_KEY\"")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        ndk {
            abiFilters += listOf("arm64-v8a")
        }
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        viewBinding = true
        buildConfig = true
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.material)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.runner)
    implementation(libs.androidx.junit.ktx)
    implementation(libs.androidx.activity)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation (libs.androidx.core.testing)

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // Retrofit core
    implementation (libs.retrofit)

    // JSON converters (choose one)
    implementation (libs.converter.gson)
    implementation ("com.squareup.okhttp3:logging-interceptor:4.12.0")

    //hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)

    implementation("androidx.room:room-runtime:2.7.2")
    ksp("androidx.room:room-compiler:2.7.2")
    implementation("com.github.bumptech.glide:glide:4.16.0")

    // Local Unit Tests
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.10.2")
    testImplementation("androidx.arch.core:core-testing:2.2.0")
//    implementation ("androidx.test:core: 1.2.0" )
//    testImplementation ("junit:junit:4.13")
//    testImplementation ("org.hamcrest:hamcrest-all:1.3")
//    testImplementation ("androidx.arch.core:core-testing:2.1.0")
//    testImplementation ("org.robolectric:robolectric:4.3.1")
//    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.2.1")
    testImplementation ("com.google.truth:truth:1.0.1")
    testImplementation ("org.mockito:mockito-core:2.21.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.10.2")
// Instrumented Unit Tests
    //androidTestImplementation ("junit:junit:4.13")
//    androidTestImplementation (libs.junit)
    androidTestImplementation ("com.linkedin.dexmaker:dexmaker-mockito:2.28.5")
//    androidTestImplementation ("org-jetbrains.kotlinx:kotlinx-coroutines-test:1.2.1")
    androidTestImplementation ("androidx.arch.core:core-testing:2.2.0")
    androidTestImplementation ("com.google.truth:truth:1.4.4")
   // androidTestImplementation ("androidx.test.ext:junit:1.1.1") ex
   // androidTestImplementation ("androidx.test.espresso:espresso-core: 3.2.0")ex
    androidTestImplementation ("org.mockito:mockito-core:5.18.0")

    androidTestImplementation ("com.google.dagger:hilt-android-testing:2.56.2")
    ksp ("com.google.dagger:hilt-android-compiler:2.56.2")
    debugImplementation ("androidx.fragment:fragment-testing:1.8.8")
    androidTestImplementation ("androidx.test.espresso:espresso-contrib:3.6.1")




}