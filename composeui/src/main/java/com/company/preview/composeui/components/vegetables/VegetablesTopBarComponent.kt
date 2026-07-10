package com.company.preview.composeui.components.vegetables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.theme.Theme

private val TopBarIconColor = Color(0xFF222222)
private val SearchIconSize = 13.dp
private val SearchIconStrokeWidth = 1.4.dp
private val CornIconSize = 12.sp
private val TitleCornSpacing = 2.dp

@Composable
fun VegetablesTopBarComponent(
    title: String,
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        TopBarCircleButton(
            onClick = onBackClick,
        ) {
            Text(
                text = "‹",
                style = Theme.typography.titleMediumBold,
                color = TopBarIconColor,
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = title,
                style = Theme.typography.titleMediumBold,
                color = Theme.colors.primary,
            )

            Spacer(modifier = Modifier.width(TitleCornSpacing))

            Text(
                text = "🌽",
                fontSize = CornIconSize,
                modifier = Modifier.graphicsLayer(
                    scaleX = -1f,
                ),
            )
        }

        TopBarCircleButton(
            onClick = onSearchClick,
        ) {
            SearchIcon()
        }
    }
}

@Composable
private fun TopBarCircleButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .size(Theme.spacing.x3l)
            .clip(CircleShape)
            .background(Theme.colors.white)
            .border(
                width = Theme.spacing.borderThin,
                color = Theme.colors.cardBorder,
                shape = CircleShape,
            )
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        content()
    }
}

@Composable
private fun SearchIcon(
    modifier: Modifier = Modifier,
) {
    Canvas(
        modifier = modifier.size(SearchIconSize),
    ) {
        val strokeWidth = SearchIconStrokeWidth.toPx()
        val circleRadius = size.minDimension * 0.28f
        val circleCenter = Offset(
            x = size.width * 0.42f,
            y = size.height * 0.42f,
        )

        drawCircle(
            color = TopBarIconColor,
            radius = circleRadius,
            center = circleCenter,
            style = Stroke(width = strokeWidth),
        )

        drawLine(
            color = TopBarIconColor,
            start = Offset(
                x = size.width * 0.62f,
                y = size.height * 0.62f,
            ),
            end = Offset(
                x = size.width * 0.82f,
                y = size.height * 0.82f,
            ),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun VegetablesTopBarComponentPreview() {
    LtrPreview {
        Surface(
            color = Theme.colors.white,
        ) {
            VegetablesTopBarComponent(
                title = "Vegetables",
                onBackClick = {},
                onSearchClick = {},
            )
        }
    }
}