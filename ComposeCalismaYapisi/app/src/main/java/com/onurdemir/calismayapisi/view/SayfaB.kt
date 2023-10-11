package com.onurdemir.calismayapisi.view

import android.app.Activity
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp


@Composable
fun SayfaB() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "PAGE B", fontSize = 50.sp)

    }

    val activity = (LocalContext.current as Activity)
    BackHandler(onBack = {
        Log.e("SayfaB","Geri Tuşuna Basıldığında Uygulamadan Çıkıldı")
        activity.finish()
    })

}