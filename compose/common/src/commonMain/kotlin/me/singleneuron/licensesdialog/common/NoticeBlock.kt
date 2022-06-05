package me.singleneuron.licensesdialog.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import me.singleneuron.licensesdialog.common.licenses.Hyperlink
import me.singleneuron.licensesdialog.common.model.Notice

@Composable
fun NoticeBlock(notice: Notice, showFullLicenseText: Boolean = false) {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("• " + notice.name, style = MaterialTheme.typography.h6, color = MaterialTheme.colors.onBackground)
            val url = notice.url
            if (!url.isNullOrEmpty()) {
                Text(" (")
                Hyperlink(url)
                Text(")")
            }
        }
        Text(modifier = Modifier.padding(vertical = 16.dp)
            .background(if (MaterialTheme.colors.isLight) Color(238, 238, 238) else Color(16, 16, 16))
            .padding(16.dp), text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontFamily = FontFamily.Monospace, color = MaterialTheme.colors.onBackground)) {
                val copyright = notice.copyright
                if (!copyright.isNullOrEmpty()) {
                    append(copyright)
                    append("\n\n")
                }
                append((if (showFullLicenseText) notice.license.fullText else notice.license.summaryText).toString())
            }
        })
    }
}