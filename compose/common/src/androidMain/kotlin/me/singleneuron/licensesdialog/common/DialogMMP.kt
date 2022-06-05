package me.singleneuron.licensesdialog.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
actual fun DialogMMP(onCloseRequest: () -> Unit, title: String?, content: @Composable LazyListState.(modifier: Modifier) -> Unit) {
    Dialog(onDismissRequest = onCloseRequest) {
        val stateVertical = rememberLazyListState()
        Column(modifier = Modifier.padding(vertical = 32.dp).background(MaterialTheme.colors.background)) {
            if (title != null) {
                Text(text = title, modifier = Modifier.padding(8.dp), style = MaterialTheme.typography.h5, color = MaterialTheme.colors.onBackground)
            }
            content.invoke(stateVertical, Modifier.weight(1f))
            TextButton(onClick = {
                onCloseRequest()
            }, modifier = Modifier.align(Alignment.End)) {
                Text("OK")
            }
        }
    }
}