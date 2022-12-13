package com.kuraev.imgurclone.feature_auth.impl.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
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
        modifier = Modifier.fillMaxSize()
    ) {
        val (previewImage, descriptionText, signInButton, loginButton) = createRefs()

        Image(
            painter = painterResource(R.drawable.ic_logo_imgur),
            contentDescription = null,
            modifier = Modifier.constrainAs(previewImage) {
                top.linkTo(anchor = parent.top, 64.dp)
                start.linkTo(anchor = parent.start)
                end.linkTo(anchor = parent.end)
            }
        )
        Text(
            text = stringResource(R.string.onboarding_description),
            textAlign = TextAlign.Center,
            modifier = Modifier.constrainAs(descriptionText) {
                top.linkTo(anchor = previewImage.bottom, 16.dp)
                start.linkTo(anchor = parent.start)
                end.linkTo(anchor = parent.end)
            }
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(signInButton) {
                    start.linkTo(anchor = parent.start)
                    end.linkTo(anchor = parent.end)
                    bottom.linkTo(anchor = parent.bottom)
                },
            onClick = { /*TODO*/ }
        ) {
            Text(stringResource(R.string.onboarding_sign_in))
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(loginButton) {
                    start.linkTo(anchor = parent.start)
                    end.linkTo(anchor = parent.end)
                    bottom.linkTo(anchor = signInButton.top, 16.dp)
                },
            onClick = { /*TODO*/ }
        ) {
            Text(stringResource(R.string.onboarding_login))
        }
    }
}