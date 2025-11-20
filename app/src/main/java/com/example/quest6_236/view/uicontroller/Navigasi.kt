package com.example.quest6_236.view.uicontroller

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quest6_236.model.DataJK.JenisK
import com.example.quest6_236.view.FormSiswa
import com.example.quest6_236.view.TampilSiswa
import com.example.quest6_236.viewmodel.SiswaViewModel

enum class Navigasi {
    Formulir,
    Detail
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiswaApp(
    // edit 1: parameter viewModel
    modifier: Modifier = Modifier,
    viewModel: SiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold { isiRuang ->
        // edit 2: Tambahkan variabel uiState
        val uiState by viewModel.statusUI.collectAsState()

        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,

            modifier = Modifier.padding(paddingValues = isiRuang)
        ) {
            composable(route = Navigasi.Formulir.name) {
                // edit 3: Tambahkan variabel konteks
                val konteks = LocalContext.current

                FormSiswa(
                    // edit 4: parameter pilhanJK dan onSubmitButtonClicked
                    pilihanJK = JenisK.map { id -> konteks.resources.getString(id) },
                    onSubmitButtonClick = {
                        viewModel.setSiswa(it)
                        navController.navigate(route = Navigasi.Detail.name)
                    }
                )
            }
            composable(route = Navigasi.Detail.name) {
                TampilSiswa(
                    // edit 5: parameter statusUISiswa
                    statusUISiswa = uiState,
                    onBackButtonClicked = { cancelAndBackToFormulir(navController) }
                )
            }
        }
    }
}


private fun cancelAndBackToFormulir(
    navHostController: NavHostController
) {
    navHostController.popBackStack(route = Navigasi.Formulir.name, inclusive = false)
}