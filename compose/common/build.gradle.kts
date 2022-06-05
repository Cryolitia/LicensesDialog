import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.android.library")
    id("maven-publish")
    signing
}

group = "io.github.cryolitia.licensesdialog.compose"
version = "1.0"

kotlin {
    android {
        publishLibraryVariants("release", "debug")
    }
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                api(compose.materialIconsExtended)
                api(compose.preview)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class) api(compose.material3)
                api("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Version.kotlin}")
            }
        }
        val androidMain by getting {
            dependencies {
                api("androidx.appcompat:appcompat:1.4.2")
                api("androidx.core:core-ktx:1.8.0")
            }
        }
        val desktopMain by getting {
            dependencies {
                api(compose.desktop.currentOs)
                api(compose.preview)
            }
        }
    }
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/Cryolitia/LicensesDialog")
            credentials {
                username = "Cryolitia"
                password = project.findProperty("github.publishPAT").toString()
            }
        }
    }
    publications {
        getByName<MavenPublication>("kotlinMultiplatform") {
            pom {
                name.set("Compose Licenses Dialog")
                description.set("An implementation of porting github.com/psdev/licensesdialog to compose")
                url.set("https://github.com/Cryolitia/LicensesDialog")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("Cryolitia")
                        name.set("Cryolitia")
                        email.set("Cryolitia@gmail.com")
                    }
                }
            }
        }
    }
}

signing {
    sign(publishing.publications["kotlinMultiplatform"])
}

android {
    compileSdk = 32
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
        targetSdk = 32
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}