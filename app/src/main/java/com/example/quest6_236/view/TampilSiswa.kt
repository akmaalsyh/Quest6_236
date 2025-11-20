package com.example.quest6_236.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.example.quest6_236.model.Siswa
import com.example.quest6_236.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilSiswa(
    // edit 1: parameter statusUISiswa
    statusUISiswa: Siswa,
    onBackButtonClicked: () -> Unit
) {
    // edit 2: Items Pair
    val items = listOf(
        Pair(first = stringResource(id = R.string.nama), second = statusUISiswa.nama),
        Pair(first = stringResource(id = R.string.gender), second = statusUISiswa.gender),
        Pair(first = stringResource(id = R.string.alamat), second = statusUISiswa.alamat)
    )

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.detail),
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = colorResource(id = R.color.purple_500))
            )
        }) {

    }
}