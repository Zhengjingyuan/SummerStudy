package com.example.myapplication.ui.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.example.myapplication.data.VideoEntity
import com.example.myapplication.ui.components.ui.theme.MyApplicationTheme

class Videos : ComponentActivity() {
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
fun VideoContent(vedio:VideoEntity){

    //约束
    val constraintset= ConstraintSet{
        val title=createRefFor("title")
        val type=createRefFor("type")
        val cover=createRefFor("cover")
        val duration=createRefFor("duration")
        val divider=createRefFor("divider")

        constrain(cover){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            centerVerticallyTo(parent)
            width= Dimension.value(121.dp)
        }

        constrain(title){
            start.linkTo(cover.end, margin = 8.dp)
            end.linkTo(parent.end)
            width= Dimension.fillToConstraints
        }

        constrain(type){
            start.linkTo(title.start)
            bottom.linkTo(parent.bottom,margin = 8.dp)

        }

        constrain(duration){
            end.linkTo(parent.end, margin = 4.dp)
            bottom.linkTo(parent.bottom, margin = 8.dp)
        }

        constrain(divider){
            top.linkTo(cover.bottom, margin = 8.dp)
        }
    }

    //传入约束
    ConstraintLayout(constraintset, modifier = Modifier.fillMaxWidth().padding(4.dp)) {
        AsyncImage(
            model = vedio.imageUrl, contentDescription = null,
            contentScale=ContentScale.Crop,
            modifier = Modifier
                .layoutId("cover")
                .aspectRatio(16 / 9f)
                .clip(RoundedCornerShape(8.dp)))
        
        Text(
            text = vedio.title,
            color = Color.Black,
            fontSize = 16.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.layoutId("title"))
        
        Text(
            text = vedio.type,
            color = Color.Gray,
            fontSize = 10.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.layoutId("type"))
        
        Text(
            text = "时长${vedio.duration}",
            color = Color.Gray,
            fontSize = 10.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.layoutId("duration"))

        Divider(
            modifier = Modifier
                .layoutId("divider"))
        
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview9() {
    MyApplicationTheme {

    }
}