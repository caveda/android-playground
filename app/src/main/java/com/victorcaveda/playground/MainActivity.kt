package com.victorcaveda.playground

import android.Manifest
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.victorcaveda.playground.model.WeatherState
import com.victorcaveda.playground.ui.theme.PlaygroundTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModel: MainViewModel
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>

    companion object {
        val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestPermissionsAndLoadData()

        (application as? PlaygroundApplication)?.appComponent?.inject(this)

        setContent {
            PlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
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
            this.weatherData?.let {
                Listing(mutableListOf(it.location.toString()) + it.weather.forecast.values.map { it.toString() })
            }
        }
    }
}


@Composable
private fun Listing(elements: List<String>) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(elements) { name ->
            Text(name)
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