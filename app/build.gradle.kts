plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs")
    id("dagger.hilt.android.plugin")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.amineaytac.widgetexamplewithxml"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.amineaytac.widgetexamplewithxml"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
    }

    sourceSets{
        getByName("debug").res.srcDirs("$rootDir/navigation-shared/src/main/sharedRes")
    }
}

dependencies {

    implementation(project(":core:common"))
    implementation(project(":core:data"))
    implementation(project(":core:domain"))
    implementation(project(":core:localization"))
    implementation(project(":core:network"))
    implementation(project(":core:presentation"))
    implementation(project(":feature:home"))
    implementation(project(":feature:splash"))
    implementation(project(":feature:widget"))
    implementation(project(":navigation-shared"))

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    // view model ktx
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")

    // fragment - by view models
    implementation("androidx.fragment:fragment-ktx:1.8.6")

    // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")

    //Material
    implementation("com.google.android.material:material:1.12.0-alpha03")
    implementation("com.google.android.material:material:1.4.0")

    //SSP & SDP
    implementation("com.intuit.ssp:ssp-android:1.1.0")
    implementation("com.intuit.sdp:sdp-android:1.1.0")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.47")
    ksp("com.google.dagger:hilt-compiler:2.47")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
}