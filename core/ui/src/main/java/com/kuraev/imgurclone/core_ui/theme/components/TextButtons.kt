package com.kuraev.imgurclone.core_ui.theme.components

import android.view.MotionEvent
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kuraev.imgurclone.core_ui.theme.*
import com.kuraev.imgurclone.core_ui.theme.Dimens.smallSizeCircularProgressIndicator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow


@Preview
@Composable
private fun PrimaryButtonTextPreview() {
    val isLoaded = remember { mutableStateOf(false) }
    PrimaryButtonText(
        isLoaded = isLoaded.value,
        isEnabled = true,
        title = "PrimaryButton",
        onClick = {
            isLoaded.value = !isLoaded.value
        }
    )
}

@Preview
@Composable
private fun SecondaryButtonTextPreview() {
    SecondaryButtonText(
        isLoaded = false,
        isEnabled = true,
        title = "SecondaryButton",
        onClick = {

        }
    )
}

@Composable
fun PrimaryButtonText(
    modifier: Modifier = Modifier,
    isLoaded: Boolean = false,
    isEnabled: Boolean = true,
    title: String,
    onClick: () -> Unit,
) {
    ButtonContainer(
        modifier = modifier,
        containerColor = primaryButton,
        contentColor = primaryButtonText,
        pressedColor = pressedPrimaryButton,
        isEnabled = isEnabled,
        onClick = { onClick.invoke() }
    ) {
        ButtonContent(
            title = title,
            isLoaded = isLoaded,
            progressBarColor = disabledButton
        )
    }
}

@Composable
fun SecondaryButtonText(
    modifier: Modifier = Modifier,
    isLoaded: Boolean = false,
    isEnabled: Boolean = true,
    title: String,
    onClick: () -> Unit,
) {
    ButtonContainer(
        containerColor = secondaryButton,
        contentColor = secondaryButtonText,
        pressedColor = pressedSecondaryButton,
        isEnabled = isEnabled,
        modifier = modifier,
        onClick = { onClick.invoke() }
    ) {
        ButtonContent(
            title = title,
            isLoaded = isLoaded,
            progressBarColor = progressBarBackground
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun ButtonContainer(
    modifier: Modifier = Modifier,
    contentColor: Color,
    containerColor: Color,
    pressedColor: Color,
    isEnabled: Boolean,
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    val containerColorRemember = remember { mutableStateOf(containerColor) }
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColorRemember.value,
            contentColor = contentColor,
            disabledContainerColor = disabledButton,
            disabledContentColor = disabledButtonText,
        ),
        modifier = modifier
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        containerColorRemember.value = pressedColor
                    }
                    MotionEvent.ACTION_UP -> {
                        containerColorRemember.value = containerColor

                        if (isEnabled) {
                            onClick.invoke()
                        }
                    }
                }
                true
            },
        interactionSource = remember { DisabledInteractionSource() },
        shape = RoundedCornerShape(8.dp),
        enabled = isEnabled
    ) {
        content.invoke(this)
    }
}

@Composable
private fun ButtonContent(
    isLoaded: Boolean,
    title: String,
    progressBarColor: Color,
) {
    if (isLoaded) {
        CircularProgressIndicator(
            strokeWidth = 2.dp,
            color = progressBarColor,
            modifier = Modifier
                .height(smallSizeCircularProgressIndicator)
                .width(smallSizeCircularProgressIndicator)
        )
    } else {
        Text(
            text = title,
            fontSize = 16.sp
        )
    }
}

/**
 * An event stream that is used to change the display of components in different states.
 *
 * For example, when clicking or dragging a component.
 *
 * This event removes the ripple effect from the button.
 * */
class DisabledInteractionSource : MutableInteractionSource {

    override val interactions: Flow<Interaction> = emptyFlow()

    override suspend fun emit(interaction: Interaction) {}

    override fun tryEmit(interaction: Interaction) = true
}