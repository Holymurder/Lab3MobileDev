package com.example.myapplication

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {
    private val repository = DataRepository()

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        _uiState.update {
            it.copy(listItems = repository.getMixedList())
        }
    }

    fun navigateToDestination(destination: AppDestinations) {
        _uiState.update {
            it.copy(
                currentDestination = destination,
                profileCurrentScreen = if (destination == AppDestinations.PROFILE)
                    ProfileDestinations.MAIN
                else
                    it.profileCurrentScreen
            )
        }
    }

    fun navigateToProfileDetails() {
        _uiState.update { it.copy(profileCurrentScreen = ProfileDestinations.DETAILS) }
    }

    fun navigateBackToProfileMain() {
        _uiState.update { it.copy(profileCurrentScreen = ProfileDestinations.MAIN) }
    }

    fun changeSettingsText() {
        _uiState.update {
            it.copy(
                settingsText = if (it.settingsText.contains("звичайний"))
                    "Поточний режим: нічний"
                else
                    "Поточний режим: звичайний"
            )
        }
    }
}

data class MainUiState(
    val currentDestination: AppDestinations = AppDestinations.PROFILE,
    val profileCurrentScreen: ProfileDestinations = ProfileDestinations.MAIN,
    val settingsText: String = "Поточний режим: звичайний",
    val listItems: List<ListItem> = emptyList()
)