object CoreDependencies {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycleRunTimeKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
}

object ComposeDependencies {
    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val materialCompose = "androidx.compose.material:material:${Versions.composeVersion}"
    const val toolingCompose = "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"
    const val uiCompose = "androidx.compose.ui:ui:${Versions.composeVersion}"
    const val navigationCompose = "androidx.navigation:navigation-compose:${Versions.composeNavigationVersion}"
}

object AccompanistDependencies {
    const val navigationAnimation = "com.google.accompanist:accompanist-navigation-animation:${Versions.accompanistVersion}"
}

object TestDependencies {
    const val junit = "junit:junit:${Versions.junitV}"
    const val androidxJunit = "androidx.test.ext:junit:${Versions.androidXJunitV}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
}

object HiltDependencies {
    const val androidHilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerCompiler}"
    const val hiltViewModelLifecycle = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.viewModelHilt}"
    const val androidCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"
}

object RetrofitDependencies {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.gsonConverterVersion}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptorVersion}"
}
