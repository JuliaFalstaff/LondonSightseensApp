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

        //Kotlin
        implementation (Kotlin.stdLib)
        implementation (Kotlin.core)

        // Design
        implementation (Design.androidxAppcompat)
        implementation (Design.material)
        implementation (Design.androidxConstraintlayout)
        implementation (Design.coordinatorLayout)

        //Test
        testImplementation (Testing.junit)
        androidTestImplementation (Testing.testJunit)
        androidTestImplementation (Testing.espressoTest)

        //Moxy
        implementation (Moxy.moxy)
        kapt (Moxy.moxyKaptCompiler)
        implementation (Moxy.moxyAndoidX)
        implementation (Moxy.moxyKtx)

        //recycler
        implementation (Recycler.rv)

        //Cicerone
        implementation(Cicerone.cicerone)

        //RX
        implementation (RXJava3.rxJava3Android)
        implementation (RXJava3.rxJava3)

        //Retrofit
        implementation (Retrofit.retrofit)
        implementation (Retrofit.converterGson)
        implementation (Retrofit.rxJava3Adapter)

        //Glide
        implementation (Glide.glide)
        kapt (Glide.glideKapt)

        //Room
        implementation (Room.runtime)
        kapt (Room.compilerKapt)

        //Stetho
        implementation (Stetho.stetho)
        implementation (Stetho.stethoUrlConnection)
        implementation (Stetho.stethoJsRhino)
        implementation (Stetho.stethoOkhttp3)

        //Dagger
        implementation (Dagger.dagger)
        kapt (Dagger.daggerKapt)
    }
}