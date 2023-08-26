@file:OptIn(ExperimentalPagerApi::class, ExperimentalFoundationApi::class)

package com.example.myapplication.ui.screen

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Task
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.data.NavigationItem
import com.example.myapplication.ui.screen.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.Red100
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.android.material.snackbar.BaseTransientBottomBar

class MainFrame : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    mainFrame()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainFrame(onNavigateToArtical:()->Unit={}) {
    val navigationItems = listOf(
        NavigationItem("学习", Icons.Filled.Home),
        NavigationItem("任务", Icons.Filled.Task),
        NavigationItem("我的", Icons.Filled.People)
    )
    val currentNavigationIndex = remember { mutableStateOf(0) } // 使用 remember 声明为可变状态变量
    Scaffold(bottomBar = {
        BottomNavigation(backgroundColor = Color.White) {
            navigationItems.forEachIndexed { index, navigationItem ->
                BottomNavigationItem(
                    selected = currentNavigationIndex.value == index, // 使用 currentNavigationIndex.value
                    onClick = {
                        currentNavigationIndex.value = index // 更新 currentNavigationIndex 的值
                    },
                    icon = {
                        androidx.compose.material3.Icon(
                            imageVector = navigationItem.icon,
                            contentDescription = null,
                            tint = if (currentNavigationIndex.value == index) Color.Red else Color.Gray
                           //图标变色
                        )
                    },
                    label = {
                        Text(text = navigationItem.title)
                    }, alwaysShowLabel = false,
                    selectedContentColor = Color(0xFFAD184B),
                    unselectedContentColor = Color(0x97F7E0EC)
                //图标底部变色
                )
            }
        }
    }) {
        Box(modifier = Modifier.padding(it)){
            when(currentNavigationIndex.value){
                0-> StudyScreenContent(onNavigateToArtical={
                    onNavigateToArtical.invoke()})
                1-> TaskScreenContent()
                2-> MyScreenContent()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MyApplicationTheme {
        mainFrame()
    }
}