package dev.sindrenm.showcase.compose.viewcompat.nestedscroll

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment

class MainComposeFragment : Fragment() {
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    return ComposeView(requireContext()).apply {
      setContent {
        ViewComposeNestedScrollShowcaseTheme {
          Surface(color = MaterialTheme.colors.background) {
            MainScreen()
          }
        }
      }
    }
  }
}

@Composable
fun MainScreen() {
  LazyColumn {
    items(numbers.toList()) {
      ListItem(text = { Text("Item number $it") })
    }
  }
}
