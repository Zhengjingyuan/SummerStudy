package com.example.myapplication.ui.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Tv
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.Category
import androidx.compose.runtime.*
import com.example.myapplication.data.DataType
import com.example.myapplication.data.SwiperEntity

class MainViewModel:ViewModel() {

    //分类数据
    val categories by mutableStateOf(listOf(
        Category("任天堂"),
        Category("Steam"),
        Category("Xbox"),
        Category("Ps4/5")

    )
    )

    //当前分类下标
    var categoryIndex by mutableStateOf(0)
        private set

    /**
    * 更新分类下标*/

    fun updateCategoryIndex(index:Int){
        categoryIndex=index

    }

    //类型数据
    val types by mutableStateOf(listOf(DataType("相关资讯", Icons.Default.Book),
                                        DataType("视频课程", Icons.Default.Tv)
                                         )
    )

    //当前数据类型下标
    var currentTypeIndex by mutableStateOf(0)
        private set

    /**
        * 更新下标*/
    fun updateTypeIndex(index:Int){
        currentTypeIndex=index

    }

    //轮播图数据
    val swiperData = listOf(SwiperEntity("https://img0.baidu.com/it/u=2310528801,383081618&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1690909200&t=e3c5145c668e3b974a3f086b33b454fc"),
        SwiperEntity("https://img1.baidu.com/it/u=1504316146,2743949949&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1690909200&t=c3473e6f744cb4ed6373b6854e88b58d"),
        SwiperEntity("https://img0.baidu.com/it/u=181358297,3003636493&fm=253&fmt=auto&app=120&f=JPEG?w=1422&h=800"),
            SwiperEntity("https://img2.baidu.com/it/u=840468921,3140809936&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500"),
            SwiperEntity("https://i0.hdslb.com/bfs/archive/f4c71e9467d5b06b609f6e556b579285e5d39df4.jpg"))

    //通知数据
    val notificationData= listOf("喷射战士夏日祭奠","动物森友会烟花大会","数字版本马里奥派对和动物森友会折扣日打七折")


}