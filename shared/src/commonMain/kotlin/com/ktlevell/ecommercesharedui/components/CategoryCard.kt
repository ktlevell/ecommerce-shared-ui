package com.ktlevell.ecommercesharedui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.ktlevell.ecommercesharedui.theme.AppTheme
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import com.ktlevell.ecommercesharedui.theme.B050
import com.ktlevell.ecommercesharedui.theme.EarbudsCategoryColor
import com.ktlevell.ecommercesharedui.theme.EletronicCategoryColor
import com.ktlevell.ecommercesharedui.theme.MedicineCategoryColor
import com.ktlevell.ecommercesharedui.theme.modifier.categoryGradient

@Composable
fun CategoryCard(
    title: String,
    thumbnail: Any,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(180.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(20.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .categoryGradient(backgroundColor)
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 24.dp)
            )

            val imageModifier = Modifier
                .size(230.dp)
                .align(Alignment.BottomCenter)
                .offset(y = 70.dp)

            AsyncImage(
                model = thumbnail,
                contentDescription = title,
                modifier = imageModifier,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
@Preview
fun CategoryCardMedicinePreview() {
    AppTheme {
        CategoryCard(
            title = "Medicine",
            thumbnail = "/Volumes/Projects/Ecommerce-Shared-UI/shared/src/commonMain/composeResources/drawable/im_medicine.webp",
            onClick = {},
            backgroundColor = MedicineCategoryColor,
        )
    }
}

@Composable
@Preview
fun CategoryCardClothingPreview() {
    AppTheme {
        CategoryCard(
            title = "Clothing",
            thumbnail = "/Volumes/Projects/Ecommerce-Shared-UI/shared/src/commonMain/composeResources/drawable/im_clothing.webp",
            onClick = {},
            backgroundColor = EarbudsCategoryColor,
        )
    }
}

@Composable
@Preview
fun CategoryCardEarbudsPreview() {
    AppTheme {
        CategoryCard(
            title = "Earbuds",
            thumbnail = "/Volumes/Projects/Ecommerce-Shared-UI/shared/src/commonMain/composeResources/drawable/im_earbuds.webp",
            onClick = {},
            backgroundColor = B050,
        )
    }
}

@Composable
@Preview
fun CategoryCardEletronicPreview() {
    AppTheme {
        CategoryCard(
            title = "Electronic",
            thumbnail = "/Volumes/Projects/Ecommerce-Shared-UI/shared/src/commonMain/composeResources/drawable/im_eletronic.webp",
            onClick = {},
            backgroundColor = EletronicCategoryColor,
        )
    }
}
