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
    const val kotlinStdLibVersion = "1.4.2"
    const val rxJava2AndroidVersion = "2.1.0"
    const val rxJava2Version = "2.1.0"
    const val retrofit2Version = "2.6.0"
    const val converterGsonVersion = "2.6.0"
    const val okhhtp3LoggingInterceptorVersion = "3.12.1"
    const val retrofitAdapterVersion = "1.0.0"
    const val coroutinesVersion = "1.5.1"
    const val coroutinesAndroidVersion = "1.5.0"
    const val coroutinesAdapter = "0.9.2"
    const val appcompatVersion = "1.3.1"
    const val materialVerson = "1.4.0"
    const val constraintlayoutVersion = "2.1.1"
    const val junitVersion = "1.1.3"
    const val epressoCoreVersion = "3.4.0"
    const val koinVersion = "3.1.2"
    const val picassoVersion = "2.71828"
    const val roomVersion = "2.3.0"
    const val stethoVersion = "1.6.0"
    const val exoPlayer = "2.16.1"

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
}

object Testing {
    const val testJunit = "androidx.test.ext:junit:${Versions.junitVersion}"
    const val espressoTest = "androidx.test.espresso:espresso-core:${Versions.epressoCoreVersion}"
}