package rs.ac.metropolitan.cs330_dz11

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import rs.ac.metropolitan.cs330_dz11.ui.navigation.NavSetup
import rs.ac.metropolitan.cs330_dz11.ui.theme.CS330DZ11Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CS330DZ11Theme {
                NavSetup()
            }
        }
    }
}

