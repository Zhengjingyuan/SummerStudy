package com.example.myapplication.ui.navigation

sealed class Destination(val route:String){
    //首页大框架
    object HomeFram:Destination("HomeFrame")
    //文章详情页
    object ArticalDetail:Destination("ArticalDetail")

}
