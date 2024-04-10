import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.routine.api.Event
import com.example.routine.api.Task
import com.example.routine.viewModel.TaskViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TaskListScreen(viewModel: TaskViewModel) {
    val tasks by viewModel.tasks.collectAsState()
    val events by viewModel.events.collectAsState()

    when (tasks.isEmpty()) {
        true -> Text("Loading...")
        false -> Column {
            tasks.forEach { task ->
                TaskItem(task, events)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TaskItem(task: Task, events: Map<Int, Event>) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clickable { /* Handle task click here */ }
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            val dateTime = LocalDateTime.parse(task.startTime, DateTimeFormatter.ISO_DATE_TIME)
            val dateTime2 = LocalDateTime.parse(task.endTime, DateTimeFormatter.ISO_DATE_TIME)
            if (task.startTime != null) {
                Text(text = "$dateTime -", style = MaterialTheme.typography.bodyMedium)
            }
            if (task.endTime != null) {
                Text(text = "$dateTime2 ", style = MaterialTheme.typography.bodyMedium)
            }
            if (task.eventId != null) {
                val associatedEvent = events[task.eventId]
                associatedEvent?.let { event ->
                    Column {
                        if (event.image != null) {
                            // Load the event image using Coil
                            val painter = rememberAsyncImagePainter(event.image)
                            Image(
                                painter = painter,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(100.dp)
                                    .clip(CircleShape)
                            )
                        }
                    }
                }
            }
        }
    }
}

