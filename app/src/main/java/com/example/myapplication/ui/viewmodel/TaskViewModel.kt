package com.example.myapplication.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel(){

    var taskData by mutableStateOf("2022.01.01-2022.12.31")
        private set

    val totalPointOfYear=13500

    //学年积分
    var pointOfYear by mutableStateOf(10000)
        private set

    //学年积分进度
    var pointOfYearPercent by mutableStateOf(0f)
        private set

    /**
     * 更新学年积分进度
     *
     * */

    fun updatePointPercent(){
        pointOfYearPercent=220f*pointOfYear/totalPointOfYear
    }

    //今日积分
    var todayPoint =0
        private set

    //一周积分情况
    var pointOfWeek by mutableStateOf(listOf(0.0,2.5,6.0,9.5,10.0,15.0,5.0))
        private set

    //日期
    var weeks= listOf("2.05","2.06","2.07","2.08","2.09","2.10","2.11","今日")
        private set

    //今日提醒文字
    var tips by mutableStateOf("今日获得0积分，快去完成下面任务吧")
        private set

    /**
     * 更新任务提醒文字
     */

    fun updateTodayPoint(){
        tips = when(todayPoint)
        {
            0->{"今日获得0积分，快去完成下面任务吧"}
            in 1..14->{"今日获得${todayPoint}积分，快去完成下面任务吧"}
            else->{"今日获得${todayPoint}积分，已经完成任务啦"}
        }

    }
}