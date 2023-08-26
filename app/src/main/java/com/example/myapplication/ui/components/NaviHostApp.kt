package com.example.myapplication.ui.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.components.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.navigation.Destination
import com.example.myapplication.ui.screen.ArticalDetailContent
import com.example.myapplication.ui.screen.ArticalDetailScreen
import com.example.myapplication.ui.screen.MainFrame
import com.example.myapplication.ui.screen.mainFrame
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class NaviHostApp : ComponentActivity() {
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

/**
 * 导航控制器
 *
 */

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NaviHostAppContent(){
    val navgationController= rememberAnimatedNavController()
    AnimatedNavHost(
        navController =navgationController ,
        startDestination = Destination.HomeFram.route){

        //首页大框架
        composable(
            Destination.HomeFram.route,
            enterTransition = {
            slideIntoContainer(AnimatedContentScope.SlideDirection.Right)//从左滑入动画
        },
            exitTransition = {
            slideOutOfContainer(AnimatedContentScope.SlideDirection.Left)
        }){
            mainFrame(onNavigateToArtical = {
                navgationController.navigate(Destination.ArticalDetail.route)
            })
        }

        //文章详细页
        composable(Destination.ArticalDetail.route,
            enterTransition = {
            slideIntoContainer(AnimatedContentScope.SlideDirection.Left)//从左滑入动画
        },
            exitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.Right)
            }){
            ArticalDetailContent(onBack = {
                navgationController.popBackStack()
            })
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview13() {
    MyApplicationTheme {

    }
}