package com.ktlevell.ecommercesharedui.theme

import androidx.compose.ui.unit.sp
import ecommercesharedui.shared.generated.resources.Res
import ecommercesharedui.shared.generated.resources.ic_add
import ecommercesharedui.shared.generated.resources.ic_arrow_back
import ecommercesharedui.shared.generated.resources.ic_category
import ecommercesharedui.shared.generated.resources.ic_filter
import ecommercesharedui.shared.generated.resources.ic_heart
import ecommercesharedui.shared.generated.resources.ic_home
import ecommercesharedui.shared.generated.resources.ic_profile
import ecommercesharedui.shared.generated.resources.ic_search
import ecommercesharedui.shared.generated.resources.ic_shopping_cart
import ecommercesharedui.shared.generated.resources.ic_sub
import ecommercesharedui.shared.generated.resources.im_mastercard
import ecommercesharedui.shared.generated.resources.im_momo
import ecommercesharedui.shared.generated.resources.im_paypal
import ecommercesharedui.shared.generated.resources.im_visa

object Resources {
    object Icons {
        object Outlined {
            val Add = Res.drawable.ic_add
            val Subtract = Res.drawable.ic_sub
            val ArrowBack = Res.drawable.ic_arrow_back
            val Category = Res.drawable.ic_category
            val Filter = Res.drawable.ic_filter
            val Heart = Res.drawable.ic_heart
            val Home = Res.drawable.ic_home
            val Profile = Res.drawable.ic_profile
            val Search = Res.drawable.ic_search
            val ShoppingCart = Res.drawable.ic_shopping_cart
        }
    }

    object Images {
        val MasterCard = Res.drawable.im_mastercard
        val Visa = Res.drawable.im_visa
        val Momo = Res.drawable.im_momo
        val PayPal = Res.drawable.im_paypal
    }
}

object FontSize {
    val EXTRA_SMALL = 10.sp
    val SMALL = 12.sp
    val REGULAR = 14.sp
    val EXTRA_REGULAR = 16.sp
    val MEDIUM = 18.sp
    val EXTRA_MEDIUM = 20.sp
    val LARGE = 30.sp
    val EXTRA_LARGE = 40.sp
}