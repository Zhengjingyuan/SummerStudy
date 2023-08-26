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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.VectorProperty
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.components.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.viewmodel.TaskViewModel

class CircleRing : ComponentActivity() {
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
fun CireClrRingContent(boxWidthDp:Int,vm:TaskViewModel){
    Canvas(modifier = Modifier.size(boxWidthDp.dp) ){
        drawArc(
            Color(0,0,0,16),
            startAngle = 160f,
            sweepAngle = 220f,
            useCenter = false,//扇形中间的横线
            style = Stroke(30f, cap = StrokeCap.Round)
        )

        drawArc(
            Color.White,
            startAngle = 160f,
            sweepAngle = vm.pointOfYearPercent,
            useCenter = false,//扇形中间的横线
            style = Stroke(30f, cap = StrokeCap.Round)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview10() {
    MyApplicationTheme {

    }
}