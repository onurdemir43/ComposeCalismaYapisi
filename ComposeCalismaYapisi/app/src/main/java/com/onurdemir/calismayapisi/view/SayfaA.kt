package com.onurdemir.calismayapisi.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.onurdemir.calismayapisi.Kisiler

@Composable
fun SayfaA(navController: NavController, gelenNesne: Kisiler ) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "PAGE A", fontSize = 50.sp)
        
        Text(text = gelenNesne.ad, fontSize = 20.sp)
        Text(text = gelenNesne.yas.toString(), fontSize = 20.sp)
        Text(text = gelenNesne.boy.toString(), fontSize = 20.sp)
        Text(text = gelenNesne.evliMi.toString(), fontSize = 20.sp)

        //sayfaB'den geri tuşuna basıldığında AnaSayfa'ya gitmek için sayfaA'dan gelindiği bilgisi silindi
        Button(onClick = {
            navController.navigate("sayfaB") {
                popUpTo("sayfaA") {inclusive = true}
            }
        }) {
            Text(text = "GO PAGE B")
        }

        //geri gitme butonu
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text(text = "GO BACK")
        }


    }

}