package com.example.routine
import TaskListScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.routine.network.NetworkModule.provideApiService
import com.example.routine.ui.theme.RoutineTheme
import com.example.routine.viewModel.TaskViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val taskViewModel = TaskViewModel(provideApiService())
            TaskListScreen(viewModel = taskViewModel)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    RoutineTheme {
        Greeting("Bud")
    }
}

