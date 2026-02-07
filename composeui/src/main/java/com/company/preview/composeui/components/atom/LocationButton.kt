package com.company.preview.composeui.components.atom

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.preview.ThemedPreview
import com.company.preview.composeui.theme.Theme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import com.company.preview.composeui.preview.RtlPreview


@Composable
fun LocationButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int= Theme.icons.location,
    enabled: Boolean = true,
    contentDescription: String? = null,
){
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth()
            .height(Theme.spacing.buttonHeight),
        shape = RoundedCornerShape(Theme.spacing.radiusCard),
        colors = ButtonDefaults.buttonColors(
            containerColor = Theme.colors.white,
            contentColor = Theme.colors.black,
            disabledContainerColor = Theme.colors.disabled,
            disabledContentColor = Theme.colors.black
      ),
        border = BorderStroke(Theme.spacing.buttonBorderSize, Theme.colors.greyOutlined),
        contentPadding = PaddingValues(
            horizontal = Theme.spacing.lg,
            vertical = Theme.spacing.lg
        ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(iconRes),
                contentDescription = contentDescription,
                modifier = Modifier.size(Theme.spacing.iconSize),
                tint = Theme.colors.black
            )
            Spacer(modifier = Modifier.size(Theme.spacing.sm))
            Text(
                text = text,
                style = Theme.typography.bodyMedium,
                color = Theme.colors.black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LocationButtonPreview_LTR() {
    ThemedPreview {
        LocationButton(
            text = "Pick-up Location",
            onClick = {}
        )
    }
}
@Preview(showBackground = true)
@Composable
private fun LocationButtonPreview_RTL() {
    RtlPreview {
        LocationButton(
            text = "موقع الالتقاط",
            onClick = {}
        )
    }
}