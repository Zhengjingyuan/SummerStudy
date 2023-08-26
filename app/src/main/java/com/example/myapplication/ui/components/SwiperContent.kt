package com.example.myapplication.ui.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myapplication.ui.components.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.viewmodel.MainViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Timer
import java.util.TimerTask


class SwiperContent : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Swiper(MainViewModel())
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Swiper(vm: MainViewModel) {
    //实际页数
    val actualCount = vm.swiperData.size
    // 使用实际页数的三倍作为虚拟页数
    val virtualCount = actualCount * 3
    // 初始页面下标为实际页数
    val initialIndex = actualCount

    val pageState = rememberPagerState(initialPage = initialIndex)

    //自动轮播
    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            pageState.animateScrollToPage((pageState.currentPage + 1) % virtualCount)
        }
    }

    HorizontalPager(
        count = virtualCount,
        state = pageState,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(16.dp))
    ) { index ->
        val actualIndex = index % actualCount // 使用取模运算来获取实际下标
        AsyncImage(
            model = vm.swiperData[actualIndex].imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(7 / 4f),
            contentScale = ContentScale.Crop
        )
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    MyApplicationTheme {
        Swiper(MainViewModel())
    }
}

