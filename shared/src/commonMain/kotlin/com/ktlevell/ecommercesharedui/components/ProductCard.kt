package com.ktlevell.ecommercesharedui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.ktlevell.ecommercesharedui.theme.Black
import com.ktlevell.ecommercesharedui.theme.DC0100
import com.ktlevell.ecommercesharedui.theme.EarbudsCategoryColor
import com.ktlevell.ecommercesharedui.theme.NC20
import com.ktlevell.ecommercesharedui.theme.NC30
import com.ktlevell.ecommercesharedui.theme.PrimaryColor
import com.ktlevell.ecommercesharedui.theme.Resources
import com.ktlevell.ecommercesharedui.theme.WC080
import com.ktlevell.ecommercesharedui.theme.White
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProductCard(
    productName: String,
    brandName: String,
    thumbnail: Any,
    price: Double,
    rating: Double,
    onCardClick: () -> Unit,
    onAddClick: () -> Unit,
    modifier: Modifier = Modifier,
    isFavorite: Boolean = false
) {
    Card(
        modifier = modifier
            .width(240.dp)
            .height(325.dp)
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(20.dp),
                clip = false,
                ambientColor = Color.Black.copy(alpha = 0.1f),
                spotColor = Color.Black.copy(alpha = 0.2f)
            )
            .clickable { onCardClick() }
        ,
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = White,
            contentColor = Black,
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 16.dp, horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .width(190.dp)
                    .height(190.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(EarbudsCategoryColor)
                ,
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.TopEnd)
                        .padding(top = 12.dp, end = 12.dp)
                        .clip(CircleShape)
                        .background(WC080),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(Resources.Icons.Outlined.Heart),
                        contentDescription = null,
                        modifier = Modifier
                            .size(13.dp),
                        tint = if (isFavorite) DC0100 else NC20
                    )
                }

                AsyncImage(
                    model = thumbnail,
                    contentDescription = null,
                    modifier = Modifier
                        .size(175.dp)
                        .graphicsLayer {
                            rotationZ = -45f
                            translationX = -43f
                            translationY = -13f
                        },
                    contentScale = ContentScale.Fit,
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = productName,
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Start
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        painter = painterResource(Resources.Icons.Outlined.Start),
                        contentDescription = null,
                        tint = Color(0xFFFFC107),
                        modifier = Modifier.size(14.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = "(${rating})",
                        color = NC30,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = brandName,
                        style = MaterialTheme.typography.bodySmall,
                        color = NC30
                    )

                    Text(
                        text = "$${price}",
                        style = MaterialTheme.typography.titleSmall.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = Black
                    )
                }

                Button(
                    modifier = Modifier.size(40.dp),
                    onClick = { onAddClick() },
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryColor,
                        contentColor = White
                    )
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(resource = Resources.Icons.Outlined.Add),
                        contentDescription = null
                    )
                }
            }

        }

    }
}

@Composable
@Preview
fun ProductCardPreview() {
    ProductCard(
        productName = "Harden Vol. 6",
        brandName = "Adidas",
        thumbnail = "/Volumes/Projects/Ecommerce-Shared-UI/shared/src/commonMain/composeResources/drawable/im_nikee.webp",
        price = 90.00,
        rating = 5.0,
        onCardClick = {},
        onAddClick = {}
    )
}
