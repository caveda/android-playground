package com.victorcaveda.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.victorcaveda.playground.ui.theme.PlaygroundTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as? PlaygroundApplication)?.appComponent?.inject(this)

        setContent {
            PlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Stations(mainViewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Stations(mainViewModel: MainViewModel = viewModel()) {
    Column(
    ) {
        with(mainViewModel.uiState.collectAsState().value) {
            Listing(this.map { it.name })
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
        Stations()
    }
}