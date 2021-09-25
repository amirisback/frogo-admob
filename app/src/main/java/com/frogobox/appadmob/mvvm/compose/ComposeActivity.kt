package com.frogobox.appadmob.mvvm.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.frogobox.admob.core.FrogoAdmobBannerView
import com.frogobox.admob.core.adsize_banner
import com.frogobox.appadmob.R
import com.frogobox.appadmob.ui.theme.FrogoAdmobTheme

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FrogoAdmobTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        FrogoAdmobBannerView(
                            mAdUnitID = getString(R.string.admob_banner),
                            mAdSize = adsize_banner
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FrogoAdmobTheme {
        Greeting("Android")
    }
}