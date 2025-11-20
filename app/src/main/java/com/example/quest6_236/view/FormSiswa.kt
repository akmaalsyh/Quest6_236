package com.example.quest6_236.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable


@OptIn (ExperimentalMaterial3Api::class)
@Composable
fun FormSiswa(
    // edit 1 : parameterr pilihanJK dan OnSubmitButtonClick
    pilihanJK: List<String>,
    onSubmitButtonClick: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
){}