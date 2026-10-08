plugins {
    alias(libs.plugins.android.application)

}

android {
    namespace = "com.thays.pokedex"
    compileSdk {
        version = release(37) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.thays.pokedex"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("io.coil-kt.coil3:coil:3.6.3")
    implementation("io.coil-kt.coil3:coil-network-okhttp:3.6.3")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)

}