package com.example.myapplication

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class AppDestinations(
    val label: String,
    val icon: ImageVector,
) {
    PROFILE("Профіль", Icons.Default.Person),
    SETTINGS("Налаштування", Icons.Default.Settings)
}