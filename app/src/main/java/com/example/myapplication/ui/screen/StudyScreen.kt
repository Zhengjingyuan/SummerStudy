@file:OptIn(ExperimentalFoundationApi::class)

package com.example.myapplication.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LeadingIconTab
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.components.ArticalContent
import com.example.myapplication.ui.components.ArticalItem
import com.example.myapplication.ui.components.NotificationContent
import com.example.myapplication.ui.components.Swiper
import com.example.myapplication.ui.components.TopAppBarContent
import com.example.myapplication.ui.components.VideoContent
import com.example.myapplication.ui.screen.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.Red100
import com.example.myapplication.ui.theme.Red200
import com.example.myapplication.ui.theme.Red700
import com.example.myapplication.ui.viewmodel.ArticalViewModel
import com.example.myapplication.ui.viewmodel.MainViewModel
import com.example.myapplication.ui.viewmodel.VideoViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalFoundationApi::class)
class StudyScreen : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StudyScreenContent()
                }
            }
        }
    }
}
@ExperimentalPagerApi
@ExperimentalFoundationApi
@Composable
fun StudyScreenContent(vm:MainViewModel= viewModel(),
                       atvm:ArticalViewModel= viewModel(),
                       vdvm:VideoViewModel= viewModel(),
                        onNavigateToArtical:()->Unit={}){
    Column(modifier = Modifier.fillMaxSize() ) {
        //标题栏
        TopAppBarContent{

            Spacer(modifier = Modifier.width(8.dp))

            Surface(modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .weight(1f), color = Red100)
            {
                Row(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
                    Icon(imageVector = Icons.Filled.Search,
                        contentDescription =null,
                        tint = Color.White,
                        modifier = Modifier.size(13.dp))
                    Text(text = "搜索感兴趣的内容",
                        color = Color.White, fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis)//超出换行

                }

            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "学习\n进度", fontSize = 10.sp, color = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "26%", fontSize = 10.sp, color = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Icon(imageVector = Icons.Filled.Notifications, contentDescription =null, tint = Color.White)
            Spacer(modifier = Modifier.width(8.dp))


    }
        //分类标签
        TabRow(selectedTabIndex = vm.categoryIndex,
            backgroundColor = Red200)
        {
            vm.categories.forEachIndexed{index, category ->
                Tab(selected = vm.categoryIndex==index,
                    onClick = {vm.updateCategoryIndex(index) },
                    selectedContentColor = Red700,
                    unselectedContentColor = Color.Gray )//内容选中颜色
                {
                    Text(text = category.title,
                        modifier = Modifier.padding(8.dp),
                        color = if (vm.categoryIndex == index) Red700 else Color.Gray)
                    //如果当前选中的标签与循环的索引相等，则文字颜色为红色，否则为灰色。
                }

            }
            
        }
        //类型标签
        TabRow(selectedTabIndex = vm.currentTypeIndex,
        backgroundColor = Color.White,
        contentColor = Red200,
        indicator = {},
        divider = {},
        modifier = Modifier
            .height(48.dp)
            .padding(bottom = 0.dp))

        {
            vm.types.forEachIndexed{index, DataType ->
                LeadingIconTab(selected = vm.currentTypeIndex==index,
                    onClick = { vm.updateTypeIndex(index)},
                    selectedContentColor = Red700,
                    unselectedContentColor = Color.Gray,
                    icon = {
                           Icon(imageVector = DataType.icon,
                               contentDescription =null,
                               tint = if (vm.currentTypeIndex == index) Red700 else Color.Gray)
                    },
                    text = {
                        Text(text = DataType.title,
                        modifier = Modifier.padding(8.dp),
                        fontSize = 18.sp,
                        color = if (vm.currentTypeIndex == index) Red700 else Color.Gray)

                    }
                )


            }
        }
        LazyColumn(modifier = Modifier.fillMaxSize()){
            //轮播图
            item {Swiper(vm = MainViewModel())  }

            //通知公告
            item { NotificationContent(vm = MainViewModel()) }

            if(vm.currentTypeIndex==0){
                //文章列表
                items(atvm.articleList){artical->
                    ArticalContent(
                        artical,
                        modifier = Modifier.clickable{onNavigateToArtical.invoke()})

                }

            }else{
                //视频列表
                items(vdvm.videoList){vedio->
                    VideoContent(vedio = vedio)

                }

            }





        }


    }
}
@OptIn(ExperimentalPagerApi::class, ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun StudyScreenPreview() {
    MyApplicationTheme {
        StudyScreenContent()
    }
}