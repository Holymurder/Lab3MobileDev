package com.example.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ProfileDetailsScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Детальна інформація профілю",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        PersonalInfoCard()

        Spacer(modifier = Modifier.height(24.dp))

        StatisticsCard()

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Повернутися до профілю")
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
private fun PersonalInfoCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            DetailRow("Ім'я:", "Андрій Мачульський")
            Spacer(modifier = Modifier.height(12.dp))
            DetailRow("Email:", "andriymachul@example.com")
            Spacer(modifier = Modifier.height(12.dp))
            DetailRow("Телефон:", "+380 67 123 4567")
            Spacer(modifier = Modifier.height(12.dp))
            DetailRow("Місто:", "Золотоноша")
        }
    }
}

@Composable
private fun StatisticsCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer
        )
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = "Статистика",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onTertiaryContainer
            )
            DetailRow("Дата реєстрації:", "17.10.2023")
        }
    }
}

@Composable
fun DetailRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.7f)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
    }
}