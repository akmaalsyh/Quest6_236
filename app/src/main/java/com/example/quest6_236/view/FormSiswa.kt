package com.example.quest6_236.view

import com.example.quest6_236.R
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource


@OptIn (ExperimentalMaterial3Api::class)
@Composable
fun FormSiswa(
    // edit 1 : parameterr pilihanJK dan OnSubmitButtonClick
    pilihanJK: List<String>,
    onSubmitButtonClick: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
){
    // edit 2 : tambahkan 4 variabel dibawah ini
    var txtNama by rememberSeveable {MutableStateOf(value = "")}
    var txtAlamat by rememberSeveable {MutableStateOf(value = "")}
    var txtGender by rememberSeveable {MutableStateOf(value = "")}
    val listDate: MutableList<String> = mutableListOf(txtNama, txtGender, txtAlamat)

    Scaffold (modifier = Modifier,
        topBar = { TopAppbar(title = { Text(text = stringResource(id = R.string.app_name), color = Color.White)},
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = colorResource(id = R.color.purple_500))
            )
        }) {}
}