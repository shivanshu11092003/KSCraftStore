package com.example.kscrafts05.Activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.rememberScrollState
import androidx.core.view.WindowCompat
import com.example.kscrafts05.Activity.ui.theme.KSCrafts05Theme
import com.example.kscrafts05.Model.ProductX
import com.example.kscrafts05.Screens.DetailScreen

class DetailScreenActivity : ComponentActivity() {
    private val productX:ProductX by lazy {
        intent?.getSerializableExtra(PRODUCT_ID) as ProductX
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            KSCrafts05Theme {
                val scrollSate = rememberScrollState()
                DetailScreen(productX,scrollSate)


            }
        }


    }
    companion object{
        private const val PRODUCT_ID="id"
        fun newIntent(context: Context,productX: ProductX)=
            Intent(context,DetailScreenActivity::class.java).apply {
                putExtra(PRODUCT_ID,productX)
            }
    }
}

