package com.example.kscrafts05

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.kscrafts05.Activity.DetailScreenActivity
import com.example.kscrafts05.Model.ProductX
import com.example.kscrafts05.Screens.HomeScreen
import com.example.kscrafts05.ui.theme.KSCrafts05Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var productX: ProductX
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KSCrafts05Theme {

                    App{
                        startActivity(DetailScreenActivity.newIntent(this,it))


                    }





            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier,onClick:(ProductX)-> Unit) {
    Surface (modifier = Modifier.background(Color.White)) {

        HomeScreen(onClick = onClick)
    }

//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = "Home"){
//        composable(route = "Home"){
//            HomeScreen(){
//                navController.navigate("Detail")
//            }
//        }
//        composable(route = "Detail"){
//            DetailScreen()
//        }
//    }

}


