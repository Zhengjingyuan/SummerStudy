package com.example.myapplication.ui.components

import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.CommentsDisabled
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.ImageSearch
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.components.ui.theme.MyApplicationTheme

class DailyTask : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContent {
//            MyApplicationTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    DailyTaskContent("文章学习","10积分/每有效阅读一篇文章，10积分/每有效阅读一篇文章，10积分/每有效阅读一篇文章","已获得50积分")
//                }
//            }
//        }
    }
}

@Composable
fun DailyTaskContent(title: String,seconedTiltle:String,desc:String,percent:Float){

    //防止文本框超出
    val initContentId ="initContentId"

    val secondaryAnnotatedText= buildAnnotatedString {
        append(seconedTiltle)
        appendInlineContent(initContentId,"[icon]")
    }

    val inlineContent= mapOf(
        Pair(initContentId,InlineTextContent(Placeholder(
            width = 14.sp,
            height = 14.sp,
            placeholderVerticalAlign = PlaceholderVerticalAlign.AboveBaseline)
        ){
            Icon(
                imageVector = Icons.Filled.HelpOutline,
                contentDescription =null,
                modifier = Modifier.clickable {
                    Log.i("===","点击了问号")
                })

        })
    )

    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(7f)) {
            Text(text = title, fontSize = 16.sp, color = Color.Black)
            //防止文本超出
            Text(secondaryAnnotatedText,
                inlineContent = inlineContent,
                fontSize = 14.sp,
                color = Color.Black)
//            Row() {
//                Text(text = secondaryAnnotatedText, fontSize = 14.sp, color = Color.Black)
//                Icon(imageVector = Icons.Filled.HelpOutline, contentDescription =null )
//            }
            Row (verticalAlignment = Alignment.CenterVertically){
                LinearProgressIndicator(progress = percent, modifier = Modifier.weight(3f))
                Text(
                    text = desc,
                    fontSize = 10.sp,
                    color = Color.Black,
                    modifier = Modifier.weight(7f,false))
                
            }
            
        }
        OutlinedButton(
            onClick = { /*TODO*/ },
            border = if (percent>=1f)ButtonDefaults.outlinedButtonBorder else BorderStroke(1.dp, Color(0xFFFF5900)),
            shape = CircleShape,
            colors = ButtonDefaults.outlinedButtonColors(contentColor =Color(0xFFFF5900) ),
            modifier = Modifier.weight(3f).padding(8.dp),
            enabled = percent<1f){

            Text(text = "去学习")
            
        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview12() {
//    MyApplicationTheme {
//        DailyTaskContent("文章学习","0积分/每有效阅读一篇文章，10积分/每有效阅读一篇文章，10积分/每有效阅读一篇文章","已获得50积分")
//    }
//}