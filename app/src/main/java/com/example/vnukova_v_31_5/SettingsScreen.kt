package com.example.vnukova_v_31_5

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(onBackPressed: () -> Unit) {
    var activateSearchByPhoto by remember { mutableStateOf(true) }
    var remindMeAboutWateringPlants by remember { mutableStateOf(true) }
    var showNewsFromBotany by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            title = { Text("Настройки") },
            navigationIcon = {
                IconButton(onClick = onBackPressed) {
                    Icon(Icons.Filled.ArrowBack, "Back")
                }
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Ваш индивидуальный код", style = MaterialTheme.typography.bodyMedium)
                Text("8456 9163 5454", color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.titleMedium)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        SettingItem(
            text = "Активировать поиск растений по фото",
            checked = activateSearchByPhoto,
            onCheckedChange = { activateSearchByPhoto = it })
        SettingItem(
            text = "Напоминать мне о поливе растений",
            checked = remindMeAboutWateringPlants,
            onCheckedChange = { remindMeAboutWateringPlants = it })
        SettingItem(
            text = "Показывать новости из мира ботаники",
            checked = showNewsFromBotany,
            onCheckedChange = { showNewsFromBotany = it })
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Техническая поддержка:", style = MaterialTheme.typography.bodyMedium)
                Text("support.plant.ru", color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.bodyMedium)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                activateSearchByPhoto = false
                remindMeAboutWateringPlants = false
                showNewsFromBotany = false
            },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 20.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Сбросить настройки")
        }
    }
}
@Composable
fun SettingItem(text: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text, modifier = Modifier.weight(1f))
        Switch(checked = checked, onCheckedChange = onCheckedChange)
    }
}
@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen(onBackPressed = {})
}