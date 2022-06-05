package me.singleneuron.licensedialog.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.mutableStateOf
import me.singleneuron.licensesdialog.common.ComposeIssue
import me.singleneuron.licensesdialog.common.NoticeDialog
import me.singleneuron.licensesdialog.common.licenses.MITLicense
import me.singleneuron.licensesdialog.common.model.Notice

class MainActivity : AppCompatActivity() {
    @OptIn(ComposeIssue::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var state = mutableStateOf(true)

            NoticeDialog("Open Source License", mutableListOf(Notice("abc", "https://github.com", "edf", MITLicense), Notice("abc", "https://github.com", "edf", MITLicense), Notice("abc", "https://github.com", "edf", MITLicense), Notice("abc", "https://github.com", "edf", MITLicense), Notice("abc", "https://github.com", "edf", MITLicense)), state, showFullText = false, showOwnText = true)
        }
    }
}