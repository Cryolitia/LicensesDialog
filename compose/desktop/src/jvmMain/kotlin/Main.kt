// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.ui.window.application
import me.singleneuron.licensesdialog.common.ComposeIssue
import me.singleneuron.licensesdialog.common.NoticeDialog
import me.singleneuron.licensesdialog.common.licenses.MITLicense
import me.singleneuron.licensesdialog.common.model.Notice


@OptIn(ComposeIssue::class)
fun main() = application {
    NoticeDialog("Open Source License", mutableListOf(Notice("abc", "https://github.com", "edf", MITLicense), Notice("abc", "https://github.com", "edf", MITLicense), Notice("abc", "https://github.com", "edf", MITLicense), Notice("abc", "https://github.com", "edf", MITLicense), Notice("abc", "https://github.com", "edf", MITLicense)), showFullText = false, showOwnText = true, systemInDarkTheme = true)
}
