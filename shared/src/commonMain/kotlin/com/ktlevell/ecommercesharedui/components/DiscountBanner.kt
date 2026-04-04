package com.ktlevell.ecommercesharedui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ktlevell.ecommercesharedui.theme.AppTheme
import ecommercesharedui.shared.generated.resources.Res
import ecommercesharedui.shared.generated.resources.im_discount
import org.jetbrains.compose.resources.painterResource

@Composable
fun DiscountBanner(
    title: String,
    discount: Int,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF1A1A1A), Color(0xFF3C3C3C))
                    )
                )
        ) {
            Image(
                painter = painterResource(resource = Res.drawable.im_discount),
                contentDescription = null,
                modifier = Modifier
                    .size(240.dp)
                    .align(Alignment.CenterEnd)
                    .offset(x = 40.dp, y = 20.dp),
                contentScale = ContentScale.Fit
            )

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 24.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title.uppercase(),
                    color = Color.White,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "$discount% Off",
                    color = Color(0xFFF7B559),
                    style = MaterialTheme.typography.displayLarge,
                    fontWeight = FontWeight.Black
                )

                Text(
                    text = subtitle,
                    color = Color.White,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {  },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF7B559),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(12.dp),
                    contentPadding = PaddingValues(horizontal = 24.dp)
                ) {
                    Text(
                        text = "Get",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}


@Composable
@Preview
fun DiscountBannerPreview(

) {
    AppTheme {
        DiscountBanner(
            title = "Black Friday",
            subtitle = "All products",
            discount = 20
        )
    }
}
