package com.onurdemir.calismayapisi.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.onurdemir.calismayapisi.Kisiler
import com.onurdemir.calismayapisi.ui.theme.CalismaYapisiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalismaYapisiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SayfaGecisleri()
                }
            }
        }
    }
}

@Composable
fun SayfaGecisleri() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "anasayfa") {
        composable("anasayfa") {
            AnaSayfa(navController = navController)
        }
        composable("sayfaA/{nesne}",
            arguments = listOf(
                navArgument("nesne") {type = NavType.StringType},


            )
        ) {
            val json = it.arguments?.getString("nesne")
            val nesne = Gson().fromJson(json, Kisiler::class.java)

            SayfaA(navController = navController, nesne)
        }
        composable("sayfaB") {
            SayfaB()
        }
    }
}


@Composable
fun AnaSayfa(navController: NavController) {
    val sayac = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Ana Sayfa", fontSize = 50.sp)



        Button(onClick = {

            val kisi = Kisiler("onur",24, 1.78f, true)
            val kisiJson = Gson().toJson(kisi)
            navController.navigate("sayfaA/$kisiJson")
        }) {
            Text(text = "GO PAGE A")
        }

        Text(text = "Sayaç: ${sayac.value}")

        Button(onClick = {
            sayac.value = sayac.value +1
        }) {
            Text(text = "TIKLA")
        }
    }

    LaunchedEffect(key1 = true,) {
        Log.e("Anasayfa", "LaunchedEffect çalıştı")
    }

    SideEffect {
        Log.e("Anasayfa", "SideEffect çalıştı")
    }

    DisposableEffect(Unit) {
        onDispose {
            Log.e("Anasayfa", "DispoasbleEffect çalıştı")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalismaYapisiTheme {

    }
}