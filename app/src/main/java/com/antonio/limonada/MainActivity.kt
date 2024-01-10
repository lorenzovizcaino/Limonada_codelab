package com.antonio.limonada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.antonio.limonada.ui.theme.LimonadaTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LimonadaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Limonada()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LimonadaTheme {
        Limonada()
    }
}

@Composable
fun Limonada(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
) {
    var secuencia by remember {mutableStateOf(1)}
    var imagen = when(secuencia){
        1->R.drawable.lemon_tree
        2->R.drawable.lemon_squeeze
        3->R.drawable.lemon_drink
        else->R.drawable.lemon_restart
    }
    var descripcion = when(secuencia){
        1->R.string.des_limonero
        2->R.string.des_limon
        3->R.string.des_limonada
        else->R.string.des_vasoVacio
    }
    var texto = when(secuencia){
        1->R.string.limonero
        2->R.string.limon
        3->R.string.limonada
        else->R.string.vaso_vacio
    }

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {

        Image(painter = painterResource(imagen ), contentDescription = stringResource(descripcion))
        Text(text = stringResource(texto))
        Button(onClick = {
            secuencia++
            if(secuencia==2){

            }
            if(secuencia>4) secuencia=1
        }) {

        }
    }

}