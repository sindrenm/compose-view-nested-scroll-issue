package dev.sindrenm.showcase.compose.viewcompat.nestedscroll

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

@Composable
fun ViewComposeNestedScrollShowcaseTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit,
) {
  MaterialTheme(
    colors = if (darkTheme) darkColors() else lightColors(),
    content = content
  )
}
