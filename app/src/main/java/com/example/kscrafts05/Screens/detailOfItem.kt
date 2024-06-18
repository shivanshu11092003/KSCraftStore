package com.example.kscrafts05.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import coil.compose.AsyncImage
import com.example.kscrafts05.Model.ProductX
import com.example.kscrafts05.Model.Review
import com.example.kscrafts05.ui.theme.Yellow
import java.text.NumberFormat
import java.util.Locale


@Composable
fun DetailScreen(productX: ProductX,scrollState: ScrollState) {




    Column(modifier = Modifier.verticalScroll(scrollState)) {

        DetailEachItem(productX = productX)
    }

}

@Composable
fun DetailEachItem(productX: ProductX) {
    val insets = ViewCompat.getRootWindowInsets(LocalView.current)
    val statusBarHeight = with(LocalDensity.current) {
        insets?.systemWindowInsetTop?.toDp() ?: 0.dp
    }
    val price = productX.price*100
    val text = NumberFormat.getCurrencyInstance(Locale.getDefault()).format(price)



    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = statusBarHeight)


    ) {


        Card(){
            Row(modifier = Modifier
                .background(Color.LightGray)
                .padding(6.dp)
                .fillMaxWidth()) {
                Icon(imageVector = Icons.Filled.Star,
                    tint = Yellow, contentDescription ="rating" )
                Text(text = "${productX.rating.toString()}/5",
                    style = TextStyle(fontStyle = FontStyle.Italic,
                        fontSize = 17.sp, color = Color.Black)
                , modifier = Modifier.padding(4.dp))

            }

            AsyncImage(model = productX.thumbnail , contentDescription = "null",

                alignment = Alignment.TopCenter,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .background(Color.LightGray)
                    .padding(top = 6.dp),
                contentScale = ContentScale.FillHeight
            )
            Text(text = text,
                textAlign = TextAlign.Center,
                style = TextStyle(color = Color.Gray,
                    fontStyle = FontStyle.Italic ,fontSize = 16.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(8.dp),

                )
            Row (modifier = Modifier
                .wrapContentHeight()
                .background(Color.LightGray)){
                Text(text = productX.title,
                    style = TextStyle(color = Color.Black,
                        fontStyle = FontStyle.Italic ,fontSize = 18.sp),
                    modifier = Modifier
                        .fillMaxWidth(.6f)

                        .background(Color.LightGray)
                        .padding(8.dp),

                    )
                val Brand = productX.brand ?:" "
                Text(text = Brand.uppercase(),
                    textAlign = TextAlign.Center,
                    style = TextStyle(color = Color.Gray,
                        fontStyle = FontStyle.Italic ,fontSize = 12.sp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                        .padding(8.dp),

                    )


            }

            Text(text = "Category : "+productX.category.uppercase(),
                style = TextStyle(color = Color.Black,
                    fontStyle = FontStyle.Normal ,fontSize = 14.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(8.dp),

                )
            Text(text = "Dimensions : " +"Height : "+ productX.dimensions.height+
                    " Width : "+productX.dimensions.width
                +" Depth : "+productX.dimensions.depth,
                style = TextStyle(color = Color.Black,
                    fontStyle = FontStyle.Normal ,fontSize = 14.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(8.dp),

                )

            Text(text = "Weight : "+productX.weight+" Kg",
                style = TextStyle(color = Color.Black,
                    fontStyle = FontStyle.Normal ,fontSize = 14.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(8.dp),

                )

            Text(text = "Shipping Satus : "+productX.shippingInformation,
                style = TextStyle(color = Color.Black,
                    fontStyle = FontStyle.Normal ,fontSize = 14.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(8.dp),

                )
            Text(text = "Return  Policy : "+productX.returnPolicy,
                style = TextStyle(color = Color.Black,
                    fontStyle = FontStyle.Normal ,fontSize = 14.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(8.dp),

                )
            Text(text = "AvailabilityStatus : "+productX.availabilityStatus,
                style = TextStyle(color = Color.Black,
                    fontStyle = FontStyle.Normal ,fontSize = 14.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(8.dp),

                )
            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White
                    , containerColor = Color.Black
                )
                ) {
                Text(text = "Order Now")
            }


            Text(text = "Review : ",
                style = TextStyle(color = Color.Black,
                    fontStyle = FontStyle.Normal ,fontSize = 14.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(8.dp),

                )
           LazyColumn (
               content = {
                   items(productX.reviews){
                       ReviewItem(review = it)
                   }
               },
               modifier = Modifier.height(260.dp)
           )

            Text(text = "Product Detail : ",
                style = TextStyle(color = Color.Black,
                    fontStyle = FontStyle.Normal ,fontSize = 14.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(8.dp),

                )
            Row (modifier = Modifier.fillMaxWidth()
                .background(Color.LightGray)){
                Row {
                    Column {
                        Text(text = "Created At :"+productX.meta.createdAt,
                            style = TextStyle(color = Color.Black,
                                fontStyle = FontStyle.Normal ,fontSize = 14.sp),
                            modifier = Modifier
                                .fillMaxWidth(.5f)

                                .background(Color.LightGray)
                                .padding(8.dp),

                            )

                        Text(text = "Upadated At :"+productX.meta.updatedAt,
                            style = TextStyle(color = Color.Black,
                                fontStyle = FontStyle.Normal ,fontSize = 14.sp),
                            modifier = Modifier
                                .fillMaxWidth(.5f)

                                .background(Color.LightGray)
                                .padding(8.dp),

                            )

                    }

                }
                Row(modifier = Modifier.offset(x = 35.dp, y = -5.dp)) {
                    AsyncImage(model = productX.meta.qrCode , contentDescription = "null",

                        alignment = Alignment.TopCenter,

                        modifier = Modifier
                            .height(100.dp)
                            .background(Color.LightGray)
                            ,
                        contentScale = ContentScale.FillHeight
                    )

                }



            }





        }





    }




}

@Composable
fun ReviewItem(review: Review) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp),
        border = BorderStroke(2.dp,Color(0xFF8B8989))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(10.dp)

        ) {
            Text(text = "Rating: ${review.rating}", style = TextStyle(color = Color.Black,
                fontStyle = FontStyle.Normal ,fontSize = 14.sp))
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = review.comment, style =TextStyle(color = Color.Black,
                fontStyle = FontStyle.Normal ,fontSize = 14.sp))
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "By ${review.reviewerName}", style = TextStyle(color = Color.Black,
                fontStyle = FontStyle.Normal ,fontSize = 14.sp))
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = review.date, style = TextStyle(color = Color.Black,
                fontStyle = FontStyle.Normal ,fontSize = 14.sp))
        }
    }
}