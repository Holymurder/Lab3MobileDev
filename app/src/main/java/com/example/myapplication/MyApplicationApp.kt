package com.example.myapplication

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApplicationApp(viewModel: MainViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach { destination ->
                item(
                    icon = { Icon(destination.icon, contentDescription = destination.label) },
                    label = { Text(destination.label) },
                    selected = destination == uiState.currentDestination,
                    onClick = { viewModel.navigateToDestination(destination) }
                )
            }
        }
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                if (uiState.currentDestination == AppDestinations.PROFILE &&
                    uiState.profileCurrentScreen == ProfileDestinations.DETAILS) {
                    TopAppBar(
                        title = { Text("Деталі профілю") },
                        navigationIcon = {
                            IconButton(onClick = { viewModel.navigateBackToProfileMain() }) {
                                Icon(Icons.Default.ArrowBack, contentDescription = "Назад")
                            }
                        }
                    )
                }
            }
        ) { innerPadding ->
            when (uiState.currentDestination) {
                AppDestinations.PROFILE -> {
                    ProfileNavigation(
                        profileCurrentScreen = uiState.profileCurrentScreen,
                        onNavigateToDetails = viewModel::navigateToProfileDetails,
                        onNavigateBack = viewModel::navigateBackToProfileMain,
                        modifier = Modifier.padding(innerPadding)
                    )
                }

                AppDestinations.SETTINGS -> {
                    SettingsScreen(
                        text = uiState.settingsText,
                        listItems = uiState.listItems,
                        onButtonClick = viewModel::changeSettingsText,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
private fun ProfileNavigation(
    profileCurrentScreen: ProfileDestinations,
    onNavigateToDetails: () -> Unit,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler(enabled = profileCurrentScreen == ProfileDestinations.DETAILS) {
        onNavigateBack()
    }

    when (profileCurrentScreen) {
        ProfileDestinations.MAIN -> {
            var profileText by remember { mutableStateOf("Вітаю, користувачу!") }

            ProfileMainScreen(
                text = profileText,
                onUpdateClick = {
                    profileText = if (profileText.contains("Вітаю"))
                        "Дані профілю оновлено!"
                    else
                        "Вітаю, користувачу!"
                },
                onDetailsClick = onNavigateToDetails,
                modifier = modifier
            )
        }
        ProfileDestinations.DETAILS -> {
            ProfileDetailsScreen(
                onBackClick = onNavigateBack,
                modifier = modifier
            )
        }
    }
}