plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
}


// TODO SDK 버전
val sdkVersion: String = "1.0.0"
// TODO 배포 모듈명 가져오기
val publishModule = project.findProperty("PUBLISH_MODULE") as String? ?: ""

android {
    namespace = "com.sample.stringLibrary"
    compileSdk = 34

    defaultConfig {
        minSdk = 23

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        freeCompilerArgs += "-Xexplicit-api=strict"
    }
    resourcePrefix = "sampleTest_"
}

if (publishModule == "myString") {
//    plugins.apply("maven-publish")

    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = "com.github.yydud"
                artifactId = "myString"
                version = sdkVersion

                afterEvaluate {
                    from(components["release"])
                }
            }
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}