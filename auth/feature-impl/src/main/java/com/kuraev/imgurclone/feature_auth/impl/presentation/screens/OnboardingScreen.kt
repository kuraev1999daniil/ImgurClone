package com.kuraev.imgurclone.feature_auth.impl.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.kuraev.imgurclone.core_ui.theme.Dimens.defaultHeightButton
import com.kuraev.imgurclone.core_ui.theme.Dimens.indent16
import com.kuraev.imgurclone.core_ui.theme.Dimens.indent20
import com.kuraev.imgurclone.core_ui.theme.Dimens.indent24
import com.kuraev.imgurclone.core_ui.theme.components.PrimaryButtonText
import com.kuraev.imgurclone.core_ui.theme.components.SecondaryButtonText
import com.kuraev.imgurclone.core_ui.theme.defaultBackground
import com.kuraev.imgurclone.feature_auth.impl.R

@Preview
@Composable
private fun OnboardingScreenPreview() {
    OnboardingContent()
}

@Composable
fun OnboardingScreen() {
    OnboardingContent()
}

@Composable
private fun OnboardingContent() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .background(defaultBackground)
    ) {
        val (previewImage, spacer, descriptionText, signInButton, loginButton) = createRefs()

        val startGuideline = createGuidelineFromStart(indent16)
        val endGuideline = createGuidelineFromEnd(indent16)

        Image(
            painter = painterResource(R.drawable.ic_logo_imgur),
            contentDescription = null,
            modifier = Modifier.constrainAs(previewImage) {
                start.linkTo(anchor = parent.start)
                end.linkTo(anchor = parent.end)
            }
        )
        Spacer(modifier = Modifier
            .height(indent24)
            .constrainAs(spacer) {})
        Text(
            text = stringResource(R.string.onboarding_description),
            textAlign = TextAlign.Center,
            modifier = Modifier.constrainAs(descriptionText) {
                start.linkTo(anchor = startGuideline)
                end.linkTo(anchor = endGuideline)
                width = Dimension.fillToConstraints
            }
        )
        createVerticalChain(
            previewImage,
            spacer,
            descriptionText,
            chainStyle = ChainStyle.Packed(0.4f)
        )
        SecondaryButtonText(
            title = stringResource(R.string.onboarding_sign_in),
            modifier = Modifier
                .height(defaultHeightButton)
                .constrainAs(signInButton) {
                    start.linkTo(anchor = startGuideline)
                    end.linkTo(anchor = endGuideline)
                    bottom.linkTo(anchor = parent.bottom, indent20)
                    width = Dimension.fillToConstraints
                },
            onClick = { /*TODO*/ }
        )
        PrimaryButtonText(
            title = stringResource(R.string.onboarding_login),
            modifier = Modifier
                .height(defaultHeightButton)
                .constrainAs(loginButton) {
                    start.linkTo(anchor = startGuideline)
                    end.linkTo(anchor = endGuideline)
                    bottom.linkTo(anchor = signInButton.top, indent16)
                    width = Dimension.fillToConstraints
                },
            onClick = { /*TODO*/ }
        )
    }
}