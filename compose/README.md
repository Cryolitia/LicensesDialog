# Licenses Dialog for Jetbrains Compose Multiplatform

## Install

In `settings.gradle.kts`

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/Cryolitia/LicensesDialog")
            credentials {
                username = "Cryolitia"
                password = "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"
            }
        }
        //other respositories……
    }
}
```

In `build.gralde.kts`

```kotlin
api("io.github.cryolitia.licensesdialog.compose:common:1.0")
```
