package com.luma.focus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import com.luma.focus.luma.LumaApp
import com.luma.focus.theme.LumaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LumaTheme(
                darkTheme = isSystemInDarkTheme()
            ) {
                LumaApp()
            }
        }
    }
}
