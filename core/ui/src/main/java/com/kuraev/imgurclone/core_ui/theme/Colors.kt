package com.kuraev.imgurclone.core_ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


/* Backgrounds */

val defaultBackground: Color
    @Composable
    get() = if (isSystemInDarkTheme()) UiColor.White else UiColor.White


/* Buttons */

val primaryButton: Color
    @Composable
    get() = if (isSystemInDarkTheme()) UiColor.LightGreen else UiColor.LightGreen

val pressedPrimaryButton: Color
    @Composable
    get() = if (isSystemInDarkTheme()) UiColor.LightGreenShade01 else UiColor.LightGreenShade01

val secondaryButton: Color
    @Composable
    get() = if (isSystemInDarkTheme()) UiColor.Orange else UiColor.Orange

val pressedSecondaryButton: Color
    @Composable
    get() = if (isSystemInDarkTheme()) UiColor.OrangeShade01 else UiColor.OrangeShade01

val disabledButton: Color
    @Composable
    get() = if (isSystemInDarkTheme()) UiColor.GreyLightShade01 else UiColor.GreyLightShade01


/* Buttons Text */

val primaryButtonText: Color
    @Composable
    get() = if (isSystemInDarkTheme()) UiColor.White else UiColor.White

val secondaryButtonText: Color
    @Composable
    get() = if (isSystemInDarkTheme()) UiColor.White else UiColor.White

val disabledButtonText: Color
    @Composable
    get() = if (isSystemInDarkTheme()) UiColor.White else UiColor.White


/* Progress bar */

val progressBarBackground: Color
    @Composable
    get() = if (isSystemInDarkTheme()) UiColor.Black else UiColor.Black
