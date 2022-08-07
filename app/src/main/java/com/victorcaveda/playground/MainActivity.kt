package com.victorcaveda.playground

import android.Manifest
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.victorcaveda.playground.model.WeatherState
import com.victorcaveda.playground.ui.theme.DarkBlue
import com.victorcaveda.playground.ui.theme.DeepBlue
import com.victorcaveda.playground.ui.theme.PlaygroundTheme
import com.victorcaveda.playground.ui.weather.WeatherCard
import com.victorcaveda.playground.ui.weather.WeatherForecast
import com.victorcaveda.playground.ui.weather.WeatherViewModel
import com.victorcaveda.playground.utils.ActivityLogger
import com.victorcaveda.playground.utils.ActivityLoggerImpl
import javax.inject.Inject

class MainActivity : ComponentActivity(), ActivityLogger by ActivityLoggerImpl() {

    @Inject
    lateinit var viewModel: WeatherViewModel
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>

    companion object {
        val TAG = "WeatherActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerActivity(TAG, this)
        requestPermissionsAndLoadData()

        (application as? PlaygroundApplication)?.appComponent?.inject(this)

        setContent {
            PlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = DarkBlue,
                    contentColor = Color.White
                ) {
                    Weather(viewModel.state)
                }
            }
        }
    }

    private fun requestPermissionsAndLoadData() {
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            when {
                permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                    Log.d(TAG, "Fine location permission granted")
                }
                permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                    Log.d(TAG, "Approximate location permission granted")
                }
                else -> {
                    Log.d(TAG, "No location permission granted")
                }
            }
            viewModel.loadWeatherData()
        }
        permissionLauncher.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Weather(state: WeatherState = WeatherState()) {
    Column(
    ) {
        with(state) {
            WeatherCard(state = state, backgroundColor = DeepBlue)
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            this.weatherData?.let { data ->
                WeatherForecast(
                    forecast = data.weather.forecast,
                    units = data.weather.units,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PlaygroundTheme {
        Weather()
    }
}