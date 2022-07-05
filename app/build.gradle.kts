import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    compileSdk = Config.compileSdkVersion
    buildToolsVersion = Config.buildToolsVersion

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion
        versionCode = Releases.versionCode
        versionName = Releases.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes.onEach {
        val properties = Properties()
        properties.load(project.rootProject.file("apikey.properties").inputStream())
        val tripMapApiKey = properties.getProperty("TRIP_MAP_API_KEY", "")
        it.buildConfigField("String", "TRIP_MAP_API_KEY", tripMapApiKey)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
        compileOptions {
            sourceCompatibility(JavaVersion.VERSION_1_8)
            targetCompatibility(JavaVersion.VERSION_1_8)
        }

        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    dependencies {

        implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.4.32")
        implementation ("androidx.core:core-ktx:1.7.0")
        implementation ("androidx.appcompat:appcompat:1.3.1")
        implementation ("com.google.android.material:material:1.4.0")
        implementation ("androidx.constraintlayout:constraintlayout:2.1.1")
        implementation ("androidx.coordinatorlayout:coordinatorlayout:1.2.0")

        //Moxy
        implementation ("com.github.moxy-community:moxy:2.2.2")
        kapt ("com.github.moxy-community:moxy-compiler:2.2.0")
        implementation ("com.github.moxy-community:moxy-androidx:2.2.2")
        implementation ("com.github.moxy-community:moxy-ktx:2.2.2")

        //recycler
        implementation ("androidx.recyclerview:recyclerview:1.2.1")

        //Cicerone
        implementation("com.github.terrakok:cicerone:7.1")

        //RX
        implementation ("io.reactivex.rxjava3:rxandroid:3.0.0")
        implementation ("io.reactivex.rxjava3:rxjava:3.1.2")

        //Retrofit
        implementation ("com.squareup.retrofit2:retrofit:2.9.0")
        implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation ("com.squareup.retrofit2:adapter-rxjava3:2.9.0")

        //Glide
        implementation ("com.github.bumptech.glide:glide:4.12.0")
        kapt ("com.github.bumptech.glide:compiler:4.12.0")

        //Room
        implementation ("androidx.room:room-runtime:2.3.0")
        kapt ("androidx.room:room-compiler:2.3.0")

        //Stetho
        implementation ("com.facebook.stetho:stetho:1.6.0")
        implementation ("com.facebook.stetho:stetho-urlconnection:1.6.0")
        implementation ("com.facebook.stetho:stetho-js-rhino:1.6.0")
        implementation ("com.facebook.stetho:stetho-okhttp3:1.6.0")

        //Dagger
        implementation ("com.google.dagger:dagger:2.40")
        kapt ("com.google.dagger:dagger-compiler:2.24")

        testImplementation ("junit:junit:4.+")
        androidTestImplementation ("androidx.test.ext:junit:1.1.3")
        androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
    }
}