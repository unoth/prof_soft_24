plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.dedova.prosoft24"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.dedova.prosoft24"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

<<<<<<< HEAD
=======
//moshi
    implementation(libs.moshi.kotlin)
    implementation(libs.moshi)
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.14.0")

//retrofit
    implementation(libs.retrofit.v290)
    implementation(libs.converter.moshi.v290)
    implementation(libs.okhttp3.okhttp)
    implementation(libs.logging.interceptor)
    implementation (libs.converter.gson.v250)

    implementation("com.github.chuckerteam.chucker:library:4.0.0")

>>>>>>> github/master
}