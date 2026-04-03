package com.ktlevell.ecommercesharedui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ecommercesharedui.shared.generated.resources.Res
import ecommercesharedui.shared.generated.resources.be_vietnam_pro_bold
import ecommercesharedui.shared.generated.resources.be_vietnam_pro_light
import ecommercesharedui.shared.generated.resources.be_vietnam_pro_medium
import ecommercesharedui.shared.generated.resources.be_vietnam_pro_regular
import ecommercesharedui.shared.generated.resources.be_vietnam_pro_semi_bold
import org.jetbrains.compose.resources.Font


val BeVietnamProFont @Composable get () = FontFamily(
    Font(
        resource = Res.font.be_vietnam_pro_light,
        weight = FontWeight.Light
    ),
    Font(
        resource = Res.font.be_vietnam_pro_regular,
        weight = FontWeight.Normal
    ),
    Font(
        resource = Res.font.be_vietnam_pro_medium,
        weight = FontWeight.Medium
    ),
    Font(
        resource = Res.font.be_vietnam_pro_semi_bold,
        weight = FontWeight.SemiBold
    ),
    Font(
        resource = Res.font.be_vietnam_pro_bold,
        weight = FontWeight.Bold
    ),
)

val Typography @Composable get() = Typography(
    headlineLarge = TextStyle(
        fontFamily = BeVietnamProFont,
        fontSize = FontSize.EXTRA_LARGE,
        fontWeight = FontWeight.Bold
    ),
    headlineMedium = TextStyle(
        fontFamily = BeVietnamProFont,
        fontSize = FontSize.LARGE,
        fontWeight = FontWeight.SemiBold
    ),
    headlineSmall = TextStyle(
        fontFamily = BeVietnamProFont,
        fontSize = FontSize.EXTRA_MEDIUM,
        fontWeight = FontWeight.SemiBold
    ),
    titleLarge = TextStyle(
        fontFamily = BeVietnamProFont,
        fontSize = FontSize.EXTRA_MEDIUM,
        fontWeight = FontWeight.Medium
    ),
    titleMedium = TextStyle(
        fontFamily = BeVietnamProFont,
        fontSize = FontSize.MEDIUM,
        fontWeight = FontWeight.Medium
    ),
    titleSmall = TextStyle(
        fontFamily = BeVietnamProFont,
        fontSize = FontSize.EXTRA_REGULAR,
        fontWeight = FontWeight.Medium
    ),
    bodyLarge = TextStyle(
        fontFamily = BeVietnamProFont,
        fontSize = FontSize.EXTRA_REGULAR,
        fontWeight = FontWeight.Normal
    ),
    bodyMedium = TextStyle(
        fontFamily = BeVietnamProFont,
        fontSize = FontSize.REGULAR,
        fontWeight = FontWeight.Normal
    ),
    bodySmall = TextStyle(
        fontFamily = BeVietnamProFont,
        fontSize = FontSize.SMALL,
        fontWeight = FontWeight.Normal
    ),
    labelLarge = TextStyle(
        fontFamily = BeVietnamProFont,
        fontSize = FontSize.SMALL,
        fontWeight = FontWeight.Medium
    ),
    labelSmall = TextStyle(
        fontFamily = BeVietnamProFont,
        fontSize = FontSize.EXTRA_SMALL,
        fontWeight = FontWeight.Medium
    )
)


