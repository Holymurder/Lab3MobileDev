package com.example.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ProfileMainScreen(
    text: String,
    onUpdateClick: () -> Unit,
    onDetailsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onUpdateClick) {
            Text("Оновити профіль")
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(onClick = onDetailsClick) {
            Text("Переглянути деталі")
        }
    }
}