package com.example.myapplication.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.components.ChartView
import com.example.myapplication.ui.components.ChartViewContent
import com.example.myapplication.ui.components.CireClrRingContent
import com.example.myapplication.ui.components.DailyTaskContent
import com.example.myapplication.ui.components.TopAppBar
import com.example.myapplication.ui.components.TopAppBarContent
import com.example.myapplication.ui.screen.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.Red100
import com.example.myapplication.ui.theme.Red700
import com.example.myapplication.ui.viewmodel.TaskViewModel

class TaskScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskScreenContent()
                }
            }
        }
    }
}

@Composable
fun TaskScreenContent(tkvm:TaskViewModel= viewModel()){

    //当学年积分改变时重新计算百分比
    LaunchedEffect(Unit){
        tkvm.updatePointPercent()
        tkvm.updateTodayPoint()

    }

    //圆环高度
    var boxWidthDp:Int
    with(LocalConfiguration.current){
        boxWidthDp=screenWidthDp/2
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Brush.verticalGradient(listOf(Red700, Color.White))))
    {
        //标题栏
        Row( modifier = Modifier
            .statusBarsPadding()
            .height(58.dp),
        verticalAlignment = Alignment.CenterVertically){
            Text(text = "学习任务",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize =18.sp )
        }

        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally ){
            //学习周期
            item {
                Text(
                    text = tkvm.taskData,
                    fontSize = 12.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp))
            }

            //学习进度
            item {
                Box(
                    contentAlignment = Alignment.Center
                    ,modifier = Modifier.height(boxWidthDp.dp)){
                    //圆环
                    CireClrRingContent(boxWidthDp = boxWidthDp,tkvm)

                    //进度数据
                    Column(horizontalAlignment = Alignment.CenterHorizontally){
                        Text(
                            buildAnnotatedString {
                                append(tkvm.pointOfYear.toString())
                                withStyle(SpanStyle(fontSize = 12.sp)){
                                    append("分")
                                }
                            },
                            fontSize = 36.sp,
                            color = Color.White

                        )
                        Text(text = "学年积分",
                        fontSize = 12.sp,
                        color = Color.White)

                        
                    }
                }
            }

            item {
                //两端对齐
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 38.dp))
                {
                    Column() {
                        Text(
                        text = "${tkvm.totalPointOfYear}分",
                        color = Color.White,
                        fontSize = 16.sp)
                        Text(
                            text = "学年规定积分",
                            color = Color.White,
                            fontSize = 12.sp)


                    }
                    Column() {
                        Text(
                            text = "${tkvm.totalPointOfYear-tkvm.pointOfYear}分",
                            color = Color.White,
                            fontSize = 16.sp)
                        Text(
                            text = "还差",
                            color = Color.White,
                            fontSize = 12.sp)


                    }
                    
                }
            }

            //学习明细
            item{
                Column (modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(8.dp)){
                    Text(text = "学习明细", fontSize = 16.sp,color= Color.Black)
                    Text(text = "最近一周获得积分情况", fontSize = 14.sp,color= Color.Gray)

                    //积分情况的折线图
                    ChartViewContent(tkvm.pointOfWeek)

                    //日期
                    Row() {
                        tkvm.weeks.forEach{
                            Text(
                                text = it,
                                color = Color.Gray,
                                fontSize = 12.sp,
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.Center)
                        }
                        
                    }

                    //今日提醒
                    Row(modifier = Modifier
                        .height(58.dp)
                        .padding(8.dp)
                        .background(color = Red100)
                        .fillMaxWidth()) {
                        Text(text = tkvm.tips,
                            modifier = Modifier
                                .padding(8.dp),
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp,
                            color = Red700
                        )
                        
                    }

                    //每日任务
                    DailyTaskContent(
                        title = "登录",
                        seconedTiltle ="5积分/每日首次登录" ,
                        desc ="已获得50积分",
                        1f )
                    DailyTaskContent(
                        title = "文章学习",
                        seconedTiltle ="10积分/每有效阅读一篇文章" ,
                        desc ="已获得50积分",
                        0.8f )
                    DailyTaskContent(
                        title = "文章学习",
                        seconedTiltle ="10积分/每有效观看或收听音频累计" ,
                        desc ="已获得50积分",
                        0.8f )


                }
            }
        }


    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    MyApplicationTheme {
        TaskScreenContent()
    }
}