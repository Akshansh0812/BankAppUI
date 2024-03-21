package com.example.bankingappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bankingappui.data.Card
import com.example.bankingappui.ui.theme.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

val cards = listOf(
    Card(
        cardTypes = "VISA",
        cardNumber = "3664 8475 9485 7838",
        cardName = "Business",
        balance = 46.467,
        color = getGradient(PurpleStart, PurpleEnd),
    ),
    Card(
        cardTypes = "MASTER CARD",
        cardNumber = "6574 8475 9485 7838",
        cardName = "Savings",
        balance = 6.467,
        color = getGradient(BlueStart, BlueEnd),
    ),
    Card(
        cardTypes = "VISA",
        cardNumber = "8765 8475 9485 7838",
            cardName = "School",
        balance = 3.467,
        color = getGradient(OrangeStart, OrangeEnd),
    ),
    Card(
        cardTypes = "MASTER CARD",
        cardNumber = "1759 8475 9485 7838",
        cardName = "Trips",
        balance = 26.46,
        color = getGradient(GreenStart, GreenEnd),
    ),
)

fun getGradient(
    startColor: Color,
    endColor:Color,
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}
@Preview(showBackground = true)
@Composable
fun CardsSection(){
    LazyRow{
        items(cards.size){index->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(index : Int){
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if(index == cards.size-1){
        lastItemPaddingEnd = 16.dp
    }
    var image = painterResource(id = R.drawable.ic_visa)
    if(card.cardTypes == "MASTER CARD"){
        image = painterResource(id = R.drawable.ic_mastercard)
    }

    Box(
        modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)
    ){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable {}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = "${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}