package me.singleneuron.licensesdialog.common

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun DialogMMP(onCloseRequest: () -> Unit, title: String? = null, content: @Composable LazyListState.(modifier: Modifier) -> Unit)