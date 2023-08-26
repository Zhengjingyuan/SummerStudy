package com.example.myapplication.ui.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.data.ArticalEntity
import com.example.myapplication.ui.components.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.viewmodel.ArticalViewModel

class ArticalItem(artical: ArticalEntity,modifier: Modifier=Modifier) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun ArticalContent(artical:ArticalEntity,modifier: Modifier=Modifier){
    Column(modifier = modifier.padding(8.dp)) {
        Text(
            text = artical.title,
            color = Color.Black,
            fontSize = 16.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(bottom = 8.dp))
        
    }
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
        Text(text = "来源：${artical.source}",
            color = Color.Gray,
            fontSize = 16.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis)

        Text(
            text = artical.timestamp,
            color = Color.Gray,
            fontSize = 16.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis)
        
    }
    Spacer(modifier = Modifier.padding(8.dp))

    Divider()

}
@Preview(showBackground = true)
@Composable
fun GreetingPreview8() {
    MyApplicationTheme {


    }
}