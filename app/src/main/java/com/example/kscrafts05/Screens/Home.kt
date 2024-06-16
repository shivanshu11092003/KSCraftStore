package com.example.kscrafts05.Screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.kscrafts05.Model.ProductX
import com.example.kscrafts05.ViewModel.HomeViewModel
import com.example.kscrafts05.ui.theme.Appcolor
import com.example.kscrafts05.ui.theme.DarkBrown
import com.example.kscrafts05.ui.theme.Yellow
import java.text.NumberFormat
import java.util.Locale


@Composable
fun HomeScreen(onClick: (ProductX) -> Unit) {
    val homeViewModel : HomeViewModel = hiltViewModel()
    val products = homeViewModel.product.collectAsState()

    Box {
        Column {
            Row {
                TopApp(modifier = Modifier.background(Color.White))
            }

            Row (modifier = Modifier.fillMaxSize()){
                LazyColumn( content = {
                    items(products.value){
                        producteachitem(productX = it, onClick = onClick)

                    }
                                      },
                    modifier = Modifier
                        .padding(0.dp, 0.dp, 0.dp, 0.dp)
                        .background(Color.White))

            }

        }

    }



    
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopApp(modifier: Modifier = Modifier) {

    val context = LocalContext.current.applicationContext
    TopAppBar(title = {
        Text(text = "KS Craft Store",
            style = TextStyle(
                fontFamily = FontFamily.Cursive,
                fontSize = 25.sp,
                fontWeight = FontWeight.W600,
                color = Color.Black
            ),

            )},
        navigationIcon = {
            IconButton(onClick = { Toast.makeText(context,"Buy Something", Toast.LENGTH_SHORT).show()}) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "menu")



            }
        }, modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
        , colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Appcolor,
            titleContentColor = Color.Black,
            navigationIconContentColor = Color.Black
        ),
        actions = {
            IconButton(onClick = { Toast.makeText(context,"Search", Toast.LENGTH_SHORT).show() }) {
                Icon(imageVector = Icons.Rounded.Search,
                    tint = Color.Black
                    ,contentDescription = "menu")

            }
            IconButton(onClick = { Toast.makeText(context,"Account", Toast.LENGTH_SHORT).show() }) {
                Icon(imageVector = Icons.Rounded.Person
                    ,
                    tint = Color.Black
                    ,contentDescription = "menu")

            }

        }
    )



}


@Composable
fun producteachitem(productX: ProductX, onClick: (ProductX) -> Unit) {

    Card(modifier = Modifier
        .background(Color.White)
        .fillMaxWidth()
        .padding(12.dp)
        .clickable { onClick(productX) }
        ,
        border = BorderStroke(2.dp,Color(0xFFCCCCCC)),



    ){


        AsyncImage(model = productX.thumbnail, contentDescription = "null",

            alignment = Alignment.TopCenter,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .background(Color.LightGray),
                )
        Spacer(modifier = Modifier
            .background(Color.White)
            .height(1.dp))
        Row ( modifier = Modifier
            .background(Color.White)){
            Column( modifier = Modifier
                .fillMaxWidth(.8f)
                ) {
                Text(text = productX.title,
                    fontStyle = FontStyle.Normal,
                    style = TextStyle( fontFamily = FontFamily.Serif,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W600,
                        color = Color.Black ),
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                    modifier = Modifier
                        .background(Color.White)

                        .padding(10.dp, 0.dp)


                )

            }
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally) {

                Icon(imageVector = Icons.Filled.Star,
                    tint = Yellow, contentDescription ="rating" )
                Text(text = "${productX.rating.toString()}/5",
                    style = TextStyle(fontStyle = FontStyle.Italic,
                        fontSize = 10.sp, color = Color.Black))

            }



        }



        Spacer(modifier = Modifier
            .height(1.dp)
            .background(Color.Black))
        Text(text = productX.description,
            fontStyle = FontStyle.Normal,
            style = TextStyle( fontFamily = FontFamily.Default,
                fontSize = 12.sp,

                color = Color.Black ),
            textAlign = TextAlign.Start,
            color = Color.Black,

            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(10.dp, 0.dp)


        )
        Row {
            val price = productX.price
            val text = NumberFormat.getCurrencyInstance(Locale.getDefault()).format(price)

            Column(modifier = Modifier
                .fillMaxSize(.35f)
                .background(Color.White)) {
                Card {
                    Text(text = text,
                        style = TextStyle(color = Color.Black, fontStyle = FontStyle.Normal ,fontSize = 18.sp),modifier = Modifier
                            .background(Color.White)
                            .padding(16.dp))
                }

            }
            Column() {
                Button(onClick = { onClick(productX) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = DarkBrown,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth(1f)


                ) {
                    Text(text = "View Details")

                }

            }



        }

        }


    }
