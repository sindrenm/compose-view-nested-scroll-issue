package dev.sindrenm.showcase.compose.viewcompat.nestedscroll

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import dev.sindrenm.showcase.compose.viewcompat.nestedscroll.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {
  lateinit var viewBinding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    viewBinding = ActivityMainBinding.bind(findViewById(R.id.root))

    supportFragmentManager
      .beginTransaction()
      .replace(R.id.container, MainComposeFragment())
      .commit()

    viewBinding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
      override fun onTabSelected(tab: TabLayout.Tab?) {
        val fragment = when (tab?.position) {
          0 -> MainComposeFragment()
          1 -> MainViewFragment()
          else -> error { "Unsupported" }
        }

        supportFragmentManager
          .beginTransaction()
          .replace(R.id.container, fragment)
          .commit()
      }

      override fun onTabUnselected(tab: TabLayout.Tab?) = Unit

      override fun onTabReselected(tab: TabLayout.Tab?) = Unit
    })
  }
}

