package com.projeto.bankapp.section

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material.icons.rounded.KeyboardDoubleArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projeto.bankapp.data.Currency
import com.projeto.bankapp.ui.theme.GreenStart

val currencies = listOf(
    Currency(
        name = "USD",
        buy = 25.35f,
        sell = 23.25f,
        icon = Icons.Rounded.AttachMoney
    ),
    Currency(
        name = "EUR",
        buy = 13.35f,
        sell = 23.25f,
        icon = Icons.Rounded.Euro
    ),
    Currency(
        name = "USD",
        buy = 63.35f,
        sell = 45.25f,
        icon = Icons.Rounded.CurrencyYen
    ),
    Currency(
        name = "USD",
        buy = 32.35f,
        sell = 18.25f,
        icon = Icons.Rounded.AttachMoney
    ),
    Currency(
        name = "EUR",
        buy = 15.35f,
        sell = 43.25f,
        icon = Icons.Rounded.Euro
    ),
    Currency(
        name = "USD",
        buy = 43.35f,
        sell = 25.25f,
        icon = Icons.Rounded.CurrencyYen
    ),
)

@Preview
@Composable
fun CurrenciesSection() {
    var isVisible by remember {
        mutableStateOf(false)
    }
    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }

    Column(
        Modifier
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .animateContentSize()
    ) {
        Row(
            Modifier
                .padding(16.dp)
                .animateContentSize()
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondary)
                    .clickable {
                        isVisible = !isVisible
                        if (isVisible) {
                            iconState = Icons.Rounded.KeyboardArrowUp
                        } else {
                            iconState = Icons.Rounded.KeyboardArrowDown
                        }
                    }
            ) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    imageVector = iconState,
                    contentDescription = "Currencies",
                    tint = MaterialTheme.colorScheme.onSecondary
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "Currencies",
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onSecondary,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(
                    MaterialTheme.colorScheme.secondaryContainer
                )
        )
        if (isVisible) {
            BoxWithConstraints(
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 15.dp))
            )
            {
                val boxWidConstraintsScope = this
                val width = boxWidConstraintsScope.maxWidth / 3

                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        Modifier.fillMaxWidth()
                    ) {
                        Text(
                            modifier = Modifier.width(width),
                            text = "Currency",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Text(
                            modifier = Modifier.width(width),
                            text = "Buy",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.End
                        )
                        Text(
                            modifier = Modifier.width(width),
                            text = "Sell",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.End
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyColumn(

                    ) {
                        items(currencies.size) { i ->
                            CurrencyItem(i = i, width = width)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CurrencyItem(i: Int, width: Dp) {
    val currency = currencies[i]

    Row(
        Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(GreenStart)
                .padding(4.dp)
        ) {
            Icon(
                modifier =Modifier.size(18.dp),
                imageVector = currency.icon,
                contentDescription = currency.name,
                tint = Color.White

            )
        }
    }
}

