package com.example.myapplication.ui.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.components.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.Red700

class ChartView : ComponentActivity() {
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
fun ChartViewContent(points:List<Double>){
    //每一行的高度
    val heightForRow= 24

    //小圆圈的半径
    val circleRadius=2.5

    //总行数
    val countForRow= 5

    var perY=8 //24*5/15,代表没8dp一积分，也就是一行3积分


    //画布宽度=屏幕宽度 - padding*2
    val canvasWidth= LocalConfiguration.current.screenWidthDp-8*2

    //7平分的宽度
    val averageWidth=canvasWidth/7

    //画布高度
    val canvasHeight=heightForRow*countForRow+circleRadius*2

    Canvas(modifier = Modifier
        .size(
            width = canvasWidth.dp,
            height = canvasHeight.dp) )
    {
        //背景横线
        for (index in 0..countForRow){
            val y=(heightForRow*index+circleRadius).dp.toPx()
            drawLine(color = Color.Gray,
            start = Offset(0f,y),
            end = Offset(size.width,y)
            )
        }

        //圆圈，折线
        for (index in 0 until points.count()){
            val circleCenter=Offset((averageWidth*index + averageWidth/2).dp.toPx(),
                (heightForRow*countForRow-points[index]*perY).dp.toPx())
            drawCircle(
                color = Red700,
                radius = circleRadius.dp.toPx(),
                center=circleCenter,
                style = Stroke(5f)
            )
            if(index<points.count()-1){
                val nextPointIndex=Offset((averageWidth*(index+1) + averageWidth/2).dp.toPx(),
                    (heightForRow*countForRow-points[index+1]*perY).dp.toPx())
                drawLine(color = Red700,
                start = circleCenter,
                end=nextPointIndex,
                    strokeWidth = 5f
                )
                
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview11() {
    MyApplicationTheme {

    }
}