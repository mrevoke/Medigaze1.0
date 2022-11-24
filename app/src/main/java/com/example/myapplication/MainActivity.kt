package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CreateBiz()
                }
            }
        }
    }
}
@Preview
@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)){
        
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(), shape = RoundedCornerShape(corner = CornerSize(6.dp)), border = BorderStroke(width = 2.dp, color = Color.LightGray)) {
            Portfolio(data = listOf("medicine 1","medicine 2","medicine 3"))
        }
    }
    
}

@Composable
fun Portfolio(data: List<String>){
     LazyColumn{
        items(data)
         {
            item ->  
             Card(modifier = Modifier
                 .padding(13.dp)
                 .fillMaxWidth(), shape = RectangleShape) {
               Row(modifier = Modifier
                   .padding(8.dp)
                   .background(MaterialTheme.colors.surface)
                   .padding(16.dp)) {
                   CreateProfileImg(modifier = Modifier.size(100.dp))
                 Column(modifier = Modifier.padding(7.dp).align(Alignment.CenterVertically)) {



                   Text(text = item, fontWeight = FontWeight.Bold)

                     Text(text = "xyz medics", style = MaterialTheme.typography.body2)

               }}

             }
         }
     }
}

@Composable
fun CreateBiz(){
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()) {
Card(modifier = Modifier
    .width(200.dp)
    .height(390.dp)
    .padding(12.dp), backgroundColor = Color.White,shape = RoundedCornerShape(corner = CornerSize(15.dp)), elevation = 5.dp) {
Column(modifier = Modifier.height(300.dp), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
    CreateProfileImg()
    Divider(modifier = Modifier.padding(1.dp,1.dp), color = Color.Blue, thickness = 3.dp)
    CreateInfo()
    Button(onClick = {
        buttonClickedState.value=!buttonClickedState.value
    }) {
        Text(text = "Recent purchase", style = MaterialTheme.typography.button)

    }
    if (buttonClickedState.value){
        Content()
    }
    else{
        Box(){}

    }
}


}
    }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Mr. Evoke",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primaryVariant
        )
        Text(text = "8989789865", modifier = Modifier.padding(3.dp), color = Color.Black)
        Text(
            text = "@evoke_guy.medigaze.com",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.subtitle1, color = Color.Black
        )
    }
}

@Composable
private fun CreateProfileImg(modifier: Modifier= Modifier) {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp), shape = CircleShape, border = BorderStroke(
            0.5.dp,
            Color.LightGray
        ), elevation = 4.dp, color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.imgmadigaze),
            contentDescription = "profile image",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
CreateBiz()    }
}