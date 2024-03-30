package com.example.bankapp

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CurrencyFranc
import androidx.compose.material.icons.rounded.CurrencyPound
import androidx.compose.material.icons.rounded.CurrencyRuble
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankapp.data.Currency


val currencies = listOf(
    Currency(
        name = "USD",
        buy = 23.44f,
        sell = 23.36f,
        icon = Icons.Rounded.AttachMoney
    ),
    Currency(
        name = "EUR",
        buy = 13.44f,
        sell = 13.36f,
        icon = Icons.Rounded.Euro
    ),
    Currency(
        name = "YEN",
        buy = 23.44f,
        sell = 23.36f,
        icon = Icons.Rounded.CurrencyYen
    ),
    Currency(
        name = "RUB",
        buy = 53.44f,
        sell = 53.36f,
        icon = Icons.Rounded.CurrencyRuble
    ),
    Currency(
        name = "GBR",
        buy = 23.44f,
        sell = 23.36f,
        icon = Icons.Rounded.CurrencyPound
    ),
    Currency(
        name = "CHF",
        buy = 33.44f,
        sell = 33.36f,
        icon = Icons.Rounded.CurrencyFranc
    )
)

@Preview
@Composable
fun CurrenciesSection(){
    var isVisible by remember{
        mutableStateOf(false)
    }

    var iconState by remember{
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .animateContentSize()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .animateContentSize()
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondary)
                    .clickable {
                        isVisible = !isVisible
                        iconState = if (isVisible) {
                            Icons.Rounded.KeyboardArrowUp
                        } else {
                            Icons.Rounded.KeyboardArrowDown
                        }
                    }
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = iconState,
                    contentDescription = "Currencies",
                    tint = MaterialTheme.colorScheme.onSecondary)
            }
        }

    }

}