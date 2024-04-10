package com.example.routine.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.example.routine.viewModel.EventViewModel

@Composable
fun EventListScreen(viewModel: EventViewModel) {
    val events by viewModel.events.collectAsState()

    when (events.isEmpty()) {
        true -> Text("Loading...")
        false -> Column {
            events.forEach { event ->
                if (event.title != "Get Dressed") {
                    EventItem(event)
                }
            }
        }
    }
}

@Composable
fun EventItem(event: Event) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clickable { /* Handle event click here */ }
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            if (event.image?.isNotEmpty() == true) {
                Image(
                    modifier = Modifier
                        .size(100.dp, 100.dp)
                        .clip(CircleShape),
                    painter = rememberAsyncImagePainter(event.image),
                    contentDescription = null
                )
            }
            Column(modifier = Modifier.fillMaxWidth()) {
                event.title?.let { Text(text = it, style = MaterialTheme.typography.headlineSmall) }
            }
        }
    }
}
