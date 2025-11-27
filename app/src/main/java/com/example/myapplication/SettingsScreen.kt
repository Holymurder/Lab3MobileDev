package com.example.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(
    text: String,
    listItems: List<ListItem>,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onButtonClick) {
                Text("Змінити режим")
            }
        }

        HorizontalDivider()

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(listItems) { item ->
                when (item) {
                    is ListItem.HeaderItem -> {
                        HeaderItemView(title = item.title)
                    }
                    is ListItem.UserItem -> {
                        UserItemView(user = item.user)
                    }
                    is ListItem.ProductItem -> {
                        ProductItemView(product = item.product)
                    }
                    is ListItem.ProductCarouselItem -> {
                        ProductCarouselView(
                            products = item.products,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                }
            }
        }
    }
}