package com.ktlevell.ecommercesharedui.ecommercesharedui.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ktlevell.ecommercesharedui.components.HorizontalCarrouselSection
import com.ktlevell.ecommercesharedui.components.ProductCard
import com.ktlevell.ecommercesharedui.components.PromotionBanner
import com.ktlevell.ecommercesharedui.domain.Product
import com.ktlevell.ecommercesharedui.domain.Promotion

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    trendingProducts: List<Product>,
    popularProducts: List<Product>,
    promotion: Promotion?,
    onPromotionClick: () -> Unit,
    onAddClick: (Product) -> Unit,
    onCardClick: (Product) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        promotion?.let {
            PromotionBanner(
                title = it.title,
                subtitle = it.subtitle,
                discount = it.discount,
            )
        }

        Spacer(modifier = Modifier.height(26.dp))

        HorizontalCarrouselSection(
            title = "Trending",
            items = trendingProducts,
            modifier = Modifier,
            itemContent = { product ->
                ProductCard(
                    productName = product.title,
                    brandName = product.brand,
                    thumbnail = product.thumbnail,
                    price = product.price,
                    rating = product.rating,
                    onAddClick = {
                        onAddClick(product)
                    },
                    onCardClick = {
                        onCardClick(product)
                    },
                    color = product.color
                )
            }
        )

        Spacer(modifier = Modifier.height(26.dp))

        HorizontalCarrouselSection(
            title = "Most Popular",
            items = popularProducts,
            modifier = Modifier,
            itemContent = { product ->
                ProductCard(
                    productName = product.title,
                    brandName = product.brand,
                    thumbnail = product.thumbnail,
                    price = product.price,
                    rating = product.rating,
                    onAddClick = {
                        onAddClick(product)
                    },
                    onCardClick = {
                        onCardClick(product)
                    },
                    color = product.color
                )
            }
        )

        Spacer(modifier = Modifier.height(32.dp))
    }
}

