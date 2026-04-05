import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework
import com.codingfeline.buildkonfig.compiler.FieldSpec.Type

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.buildkonfig)
}

kotlin {
    val xcframeworkName = "Shared"
    val xcf = XCFramework(xcframeworkName)

    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = xcframeworkName
            binaryOption(
                "bundleId",
                "com.klevell.ecommercesharedui.$xcframeworkName"
            )
            isStatic = true
            xcf.add(this)
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.koin.android)
            implementation(libs.kotlinx.coroutines.android)

            implementation(libs.ktor.client.okhttp)
        }

        commonMain.dependencies {
            implementation(libs.supabase.postgress)

            implementation(libs.koin.compose.viewmodel)
            implementation(libs.koin.compose.viewmodel.nav)
            implementation(libs.kotlinx.coroutines.core)

            implementation(libs.coil.compose)
            implementation(libs.coil.okhttp)

            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.uiToolingPreview)

            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            implementation(libs.kotlinx.serialization.json)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

buildkonfig {
    packageName = "com.ktlevell.ecommercesharedui.shared"

    val sbUrl = gradleLocalProperties(rootDir, rootProject.providers)
        .getProperty("SB_URL")
        ?: throw IllegalStateException(
            "Missing SB_URL property in local.properties"
        )
    val sbKey = gradleLocalProperties(rootDir, rootProject.providers)
        .getProperty("SB_KEY")
        ?: throw IllegalStateException(
            "Missing SB_KEY property in local.properties"
        )

    defaultConfigs {
        buildConfigField(
            type = Type.STRING,
            name = "SB_URL",
            value = sbUrl
        )
        buildConfigField(
            type = Type.STRING,
            name = "SB_KEY",
            value = sbKey
        )
    }
}

android {
    namespace = "com.ktlevell.ecommercesharedui.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(libs.compose.uiTooling)
}