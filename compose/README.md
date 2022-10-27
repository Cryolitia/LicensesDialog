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
                password = "9sb2n1ZvKGNMSzXqd0vIxX4nJJuRQHMOc3pf_phg".reverse()
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
