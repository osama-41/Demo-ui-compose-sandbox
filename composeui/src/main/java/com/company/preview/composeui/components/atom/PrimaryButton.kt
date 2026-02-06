package com.company.preview.composeui.components.atom

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.preview.ThemedPreview
import com.company.preview.composeui.theme.Theme

@Composable
fun PrimaryButton(
    text: String,
    onClick:()-> Unit,
    modifier: Modifier= Modifier,
    @DrawableRes iconRes: Int?=null,
    enabled: Boolean=true,
    contentDescription: String?=null
)
{
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier
            .fillMaxWidth()
            .height(Theme.spacing.buttonHeight),
        shape = RoundedCornerShape(Theme.radius.sm),
        colors = ButtonDefaults.buttonColors(
            containerColor = Theme.colors.primary,
            contentColor = Theme.colors.onPrimary,
            disabledContainerColor = Theme.colors.disabled,
            disabledContentColor = Theme.colors.onPrimary
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = Theme.elevation.sm,
            pressedElevation = Theme.elevation.md,
            disabledElevation = Theme.elevation.none
        ),
        contentPadding = PaddingValues(
            horizontal = Theme.spacing.lg,
            vertical = Theme.spacing.md
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (iconRes!=null){
                Icon(
                    painter = painterResource(iconRes),
                    contentDescription = contentDescription,
                    modifier= Modifier.size(Theme.spacing.iconSize),
                    tint = Theme.colors.onPrimary

                )
                Spacer(modifier = Modifier.size(Theme.spacing.sm))
            }
            Text(
                text = text,
                style = Theme.typography.button,
                color = Theme.colors.onPrimary
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PrimaryButtonPreview_LTR() {
    ThemedPreview {
        PrimaryButton(
            text = "Start Pickup",
            iconRes = Theme.icons.start, // from drawable via Theme.icons
            onClick = {}
        )
    }
}
@Preview(showBackground = true)
@Composable
private fun PrimaryButtonPreview_RTL() {
    RtlPreview {
        PrimaryButton(
            text = "ابدأ الالتقاط",
            iconRes = Theme.icons.start,
            onClick = {}
        )
    }
}