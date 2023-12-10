package com.projeto.bankapp.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projeto.bankapp.R
import com.projeto.bankapp.data.Card
import com.projeto.bankapp.ui.theme.BlueEnd
import com.projeto.bankapp.ui.theme.BlueStart
import com.projeto.bankapp.ui.theme.GreenEnd
import com.projeto.bankapp.ui.theme.GreenStart
import com.projeto.bankapp.ui.theme.OrangeEnd
import com.projeto.bankapp.ui.theme.OrangeStart
import com.projeto.bankapp.ui.theme.PurpleEnd
import com.projeto.bankapp.ui.theme.PurpleStart

val cards = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "3666 7567 5488 3679",
        cardName = "Business",
        balance = 50.458,
        color = getGradient(PurpleStart, PurpleEnd)
    ),
    Card(
        cardType = "MASTER",
        cardNumber = "4428 4587 4532 0585",
        cardName = "Personal",
        balance = 16.458,
        color = getGradient(BlueStart, BlueEnd)
    ),
    Card(
        cardType = "VISA",
        cardNumber = "0561 0401 4387 0585",
        cardName = "School",
        balance = 1.564,
        color = getGradient(OrangeStart, OrangeEnd)
    ),
    Card(
        cardType = "MASTER",
        cardNumber = "1125 5468 4642 2047",
        cardName = "Trips",
        balance = 2.654,
        color = getGradient(GreenStart, GreenEnd)
    ),
)

fun getGradient(
    startColor: Color,
    endColor: Color
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Preview
@Composable
fun CardSection() {
    LazyRow {
        items(cards.size) { index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(
    index: Int
) {
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cards.size - 1) {
        lastItemPaddingEnd = 16.dp
    }
    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "MASTER") {
        image = painterResource(id = R.drawable.ic_mastercard)
    }

    Box(
        Modifier.padding(16.dp, end = lastItemPaddingEnd)
    ) {
        Column(
            Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable {}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(painter = image, contentDescription = card.cardName, Modifier.width(60.dp))
            Spacer(Modifier.height(10.dp))
            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}