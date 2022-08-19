object Config {
    const val applicationId = "com.example.londonsightseensapp"
    const val minSdkVersion = 23
    const val targetSdkVersion = 31
    const val compileSdkVersion = 31
    const val buildToolsVersion = "30.0.3"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    const val ktxVersion = "1.7.0"
    const val kotlinStdLibVersion = "1.4.32"
    const val rxJava3AndroidVersion = "3.0.0"
    const val rxJava3Version = "3.1.2"
    const val retrofit2Version = "2.9.0"
    const val converterGsonVersion = "2.9.0"
    const val retrofitAdapterVersion = "2.9.0"
    const val appcompatVersion = "1.3.1"
    const val materialVerson = "1.4.0"
    const val constraintlayoutVersion = "2.1.1"
    const val junitVersion = "1.1.3"
    const val junitTestVersion = "4.13.2"
    const val epressoCoreVersion = "3.4.0"
    const val glideVersion = "4.12.0"
    const val roomVersion = "2.3.0"
    const val stethoVersion = "1.6.0"
    const val dagger = "2.40"
    const val daggerKapt = "2.24"
    const val moxyVersion = "2.2.2"
    const val moxyAndroidXVersion = "2.2.2"
    const val ciceroneVersion = "7.1"
    const val recyclerVersion = "1.2.1"
    const val coordinatorLayoutVersion = "1.2.0"
}

object Kotlin {
    const val core = "androidx.core:core-ktx:${Versions.ktxVersion}"
    const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinStdLibVersion}"
}

object Design {
    const val androidxAppcompat = "androidx.appcompat:appcompat:${Versions.appcompatVersion}"
    const val material = "com.google.android.material:material:${Versions.materialVerson}"
    const val androidxConstraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintlayoutVersion}"
    const val coordinatorLayout =
        "androidx.coordinatorlayout:coordinatorlayout:${Versions.coordinatorLayoutVersion}"
}

object Testing {
    const val testJunit = "androidx.test.ext:junit:${Versions.junitVersion}"
    const val espressoTest = "androidx.test.espresso:espresso-core:${Versions.epressoCoreVersion}"
    const val junit = "junit:junit:${Versions.junitTestVersion}"
}

object RXJava3 {
    const val rxJava3Android = "io.reactivex.rxjava3:rxandroid:${Versions.rxJava3AndroidVersion}"
    const val rxJava3 = "io.reactivex.rxjava3:rxjava:${Versions.rxJava3Version}"
}

object Stetho {
    const val stetho = "com.facebook.stetho:stetho:${Versions.stethoVersion}"
    const val stethoUrlConnection =
        "com.facebook.stetho:stetho-urlconnection:${Versions.stethoVersion}"
    const val stethoJsRhino = "com.facebook.stetho:stetho-js-rhino:${Versions.stethoVersion}"
    const val stethoOkhttp3 = "com.facebook.stetho:stetho-okhttp3:${Versions.stethoVersion}"
}

object Dagger {
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerKapt = "com.google.dagger:dagger-compiler:${Versions.daggerKapt}"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit2Version}"
    const val converterGson =
        "com.squareup.retrofit2:converter-gson:${Versions.converterGsonVersion}"
    const val rxJava3Adapter =
        "com.squareup.retrofit2:adapter-rxjava3:${Versions.retrofitAdapterVersion}"
}

object Room {
    const val runtime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val compilerKapt = "androidx.room:room-compiler:${Versions.roomVersion}"
}

object Glide {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    const val glideKapt = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"
}

object Moxy {
    const val moxy = "com.github.moxy-community:moxy:${Versions.moxyVersion}"
    const val moxyKaptCompiler = "com.github.moxy-community:moxy-compiler:${Versions.moxyVersion}"
    const val moxyAndoidX =
        "com.github.moxy-community:moxy-androidx:${Versions.moxyAndroidXVersion}"
    const val moxyKtx = "com.github.moxy-community:moxy-ktx:${Versions.moxyAndroidXVersion}"
}

object Cicerone {
    const val cicerone = "com.github.terrakok:cicerone:${Versions.ciceroneVersion}"
}

object Recycler {
    const val rv = "androidx.recyclerview:recyclerview:${Versions.recyclerVersion}"
}




