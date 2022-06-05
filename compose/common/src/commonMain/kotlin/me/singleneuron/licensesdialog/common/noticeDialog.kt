package me.singleneuron.licensesdialog.common

import DialogMMP
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import me.singleneuron.licensesdialog.common.licenses.ApacheSoftwareLicense20
import me.singleneuron.licensesdialog.common.model.Notice

@RequiresOptIn("https://github.com/JetBrains/compose-jb/issues/2069")
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.FUNCTION)
annotation class ComposeIssue

@Composable
@ComposeIssue
fun NoticeDialog(title: String?, notices: MutableList<Notice>, showFullText: Boolean = false, showOwnText: Boolean = true,
    //TODO: Overwrite it!!!
                 systemInDarkTheme: Boolean = isSystemInDarkTheme()) {
    var state by rememberSaveable { mutableStateOf(true) }
    if (state) {
        MaterialTheme(if (systemInDarkTheme) darkColors() else lightColors()) {
            DialogMMP(onCloseRequest = { state = false }, title = title) { it ->
                if (showOwnText) {
                    notices.add(ownLicense)
                }
                LazyColumn(state = this, modifier = it) {
                    items(notices.size) { i ->
                        NoticeBlock(notices[i], showFullText)
                    }
                }
            }
        }
    }
}

val ownLicense by lazy {
    Notice("LicensesDialog", "https://github.com/Cryolitia/LicensesDialog", "Copyright 2022 singleNeuron", ApacheSoftwareLicense20)
}