package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.VideoEntity

class VideoViewModel: ViewModel() {
    var videoList= listOf(
        VideoEntity("动物森友会室内布景教程","视频课程","00:02:00","https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fsafe-img.xhscdn.com%2Fbw1%2F47b702a7-15ca-42a5-b136-b70ad2ea2c4a%3FimageView2%2F2%2Fw%2F1080%2Fformat%2Fjpg&refer=http%3A%2F%2Fsafe-img.xhscdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1693582327&t=e31140eb7315aca032b133ec49e0e045"),
        VideoEntity("穿什么样的衣服能刷到他们？","视频课程","00:02:00","https://p8.itc.cn/images01/20201118/eac1423f4162492c90dc42431c187ba8.png"),
        VideoEntity("动物森友会免费更新！","视频课程","00:02:00","https://p8.itc.cn/images01/20201118/eac1423f4162492c90dc42431c187ba8.png"),
        VideoEntity("一起烟火大会啦！","视频课程","00:02:00","https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fsafe-img.xhscdn.com%2Fbw%2F2095e407-fba5-424d-aa9c-bf8b1463e216%3FimageView2%2F2%2Fw%2F1080%2Fformat%2Fjpg&refer=http%3A%2F%2Fsafe-img.xhscdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1693582825&t=c03db92af95bb89e4ec6e2061a12ca5a")


    )
        private set

}