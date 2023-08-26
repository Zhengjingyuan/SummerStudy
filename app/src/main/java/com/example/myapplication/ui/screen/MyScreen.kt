package com.example.myapplication.ui.screen

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.components.TopAppBarContent
import com.example.myapplication.ui.screen.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.Grey100
import com.example.myapplication.ui.theme.Red700

class MyScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyScreenContent()
                }
            }
        }
    }
}
data class MenuItem(@DrawableRes val icon:Int,val title:String)

@Composable
fun MyScreenContent(){
    val menus= listOf(
        MenuItem(R.drawable.baseline_credit_score_24,"学习积分"),
        MenuItem(R.drawable.baseline_ad_units_24,"浏览记录"),
        MenuItem(R.drawable.baseline_addchart_24,"学习档案"),

        MenuItem(R.drawable.baseline_question_mark_24,"常见问题"),
        MenuItem(R.drawable.baseline_query_builder_24,"版本信息"),
        MenuItem(R.drawable.baseline_settings_24,"个人设置"),
        MenuItem(R.drawable.baseline_local_phone_24,"联系我们"))
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBarContent{
            Text(text = "我的", color = Color.White, fontSize = 18.sp)
        }
        LazyColumn(modifier = Modifier.padding(8.dp)){
            //头像
            item {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(painter = painterResource(
                        id = R.drawable.profile),
                        contentDescription =null,
                        contentScale=ContentScale.Crop,
                        modifier = Modifier
                            .size(62.dp)
                            .clip(CircleShape))
                    Column(modifier = Modifier
                        .padding(8.dp)
                        .height(62.dp),
                        verticalArrangement = Arrangement.SpaceAround) {
                        Text(text = "哇哦橘橘",color= Color.Black, fontSize = 18.sp)
                        Text(text = "已登录学习23天",color= Color.Gray, fontSize = 12.sp)
                        
                    }
                    
                }
            }
            //菜单部分
            itemsIndexed(menus){index,menu->
                if (index==3){
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                        .height(16.dp)
                        .background(color = Grey100)){

                    }

                }
                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(8.dp))
                {
                    Icon(
                        painter =  painterResource(id =menu.icon ), contentDescription = null,
                        modifier = Modifier.size(17.dp),
                        tint = Red700

                    )
                    Column (modifier = Modifier.padding(horizontal = 8.dp)){
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp))
                        {
                            Text(text = menu.title,
                                color = Color.Black,
                                fontSize = 16.sp,
                                modifier = Modifier.weight(1f))
                            Icon(
                                imageVector = Icons.Default.ArrowForwardIos,
                                contentDescription =null,
                                tint= Color.Gray,
                                modifier = Modifier.size(13.dp))

                        }
                        Divider()

                    }

                }


            }

        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview6() {
    MyApplicationTheme {
        MyScreenContent()
    }
}