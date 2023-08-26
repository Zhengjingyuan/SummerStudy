package com.example.myapplication.ui.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.components.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.Red100
import com.example.myapplication.ui.theme.Red300
import com.example.myapplication.ui.viewmodel.MainViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

class Notification : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NotificationContent(MainViewModel())
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NotificationContent(vm:MainViewModel) {
    //实际页数
    val actualCount = vm.notificationData.size
    // 使用实际页数的三倍作为虚拟页数
    val virtualCount = actualCount * 3
    // 初始页面下标为实际页数
    val initialIndex = actualCount

    val pageState = rememberPagerState(initialPage = initialIndex)//记得设置state

    //自动轮播
    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            pageState.animateScrollToPage((pageState.currentPage + 1) % virtualCount)
        }
    }


    Row(modifier = Modifier
        .padding(8.dp)//注意顺序！！染色会覆盖padding
        .clip(RoundedCornerShape(8.dp))
        .background(Red100)
        .height(45.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween)
    {
        Text(
            text = "最新活动",
            color = Red300,
            fontSize = 14.sp)

        Spacer(modifier = Modifier.width(8.dp))
        //竖直轮播
        VerticalPager(
            count = virtualCount,
            state = pageState,
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.Start

        )
        {index->
            val actualIndex = index % actualCount
            Text(
                text = vm.notificationData[actualIndex],
                color = Color.Black,
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth())
            
        }

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "更多",
            fontSize = 14.sp,
            color = Color.Gray)

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview7() {
    MyApplicationTheme {
        NotificationContent(MainViewModel())
    }
}