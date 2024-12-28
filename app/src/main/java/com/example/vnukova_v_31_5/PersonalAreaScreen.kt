package com.example.vnukova_v_31_5

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vnukova_v_31_5.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalAreaScreen(onSettingsClick: () -> Unit, onLogout: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = { Text("Мой сад") },
            actions = {
                IconButton(onClick = onSettingsClick) {
                    Icon(Icons.Filled.Settings, contentDescription = "Settings")
                }
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text("Привет, User!", style = MaterialTheme.typography.headlineSmall, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { /* TODO Search by photo */ },
            modifier = Modifier.fillMaxWidth(0.8f)) {
            Text("Поиск по фото")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Card(
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Добавлено", style = MaterialTheme.typography.bodyMedium)
                    Text("растений", style = MaterialTheme.typography.bodyMedium)
                    Text("157", style = MaterialTheme.typography.headlineMedium)                }
            }
            Card(
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Редкие", style = MaterialTheme.typography.bodyMedium)
                    Text("растения", style = MaterialTheme.typography.bodyMedium)
                    Text("5", style = MaterialTheme.typography.headlineMedium)
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(10.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        ) {
            Row(modifier = Modifier.padding(16.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.plant_photo),
                    contentDescription = "Plant Card Image",
                    modifier = Modifier.size(100.dp).clip(RoundedCornerShape(16.dp))
                )
                Column(modifier = Modifier.padding(10.dp)){
                    Text("Топ 10 самых необычных растений мира.", style = MaterialTheme.typography.bodyLarge)
                    val dateFormat = SimpleDateFormat("dd MMMM, в HH:mm", Locale("ru"))
                    Text(text = dateFormat.format(Date()), style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(modifier = Modifier.padding(bottom = 20.dp)) {
            IconButton(onClick = onLogout) {
                Icon(Icons.Filled.ExitToApp, "Выйти")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PersonalAreaScreenPreview() {
    PersonalAreaScreen(onSettingsClick = {}, onLogout = {})
}