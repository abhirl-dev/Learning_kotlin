package com.independent_developer.learnKotlin.components.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.independent_developer.learnKotlin.ui.theme.DarkAccentColor

@Composable
fun RecyclerCard(text: String = "") {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        shape = ShapeDefaults.ExtraSmall,
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(
                space = 7.dp,
                alignment = Alignment.CenterHorizontally,
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .size(20.dp),
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "",
                tint = Color.Green
            )
            Text(
                color = DarkAccentColor,
                fontWeight = FontWeight(700),
                fontSize = 16.sp,
                text = text
            )
        }
    }
}