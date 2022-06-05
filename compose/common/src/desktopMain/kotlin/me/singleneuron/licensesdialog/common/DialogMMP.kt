package me.singleneuron.licensesdialog.common

import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
actual fun DialogMMP(onCloseRequest: () -> Unit, title: String?, content: @Composable LazyListState.(modifier: Modifier) -> Unit) {
    Dialog(onCloseRequest = onCloseRequest, title = title ?: "", content = {
        val stateVertical = rememberLazyListState()
        Box(modifier = Modifier.background(MaterialTheme.colors.background).padding(10.dp)) {
            Box {
                content.invoke(stateVertical, Modifier)
            }
            VerticalScrollbar(modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(), adapter = rememberScrollbarAdapter(scrollState = stateVertical))

        }
    })
}