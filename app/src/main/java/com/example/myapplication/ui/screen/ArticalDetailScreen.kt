package com.example.myapplication.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateBefore
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.components.TopAppBar
import com.example.myapplication.ui.components.TopAppBarContent
import com.example.myapplication.ui.components.WebViewContent
import com.example.myapplication.ui.components.remeberWebViewState
import com.example.myapplication.ui.screen.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.viewmodel.ArticalViewModel
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch

class ArticalDetailScreen : ComponentActivity() {
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

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun ArticalDetailContent(vm:ArticalViewModel= viewModel(), onBack:()->Unit){
    
    val webViewState= remeberWebViewState(data = vm.content)

    var fontScalr by remember {
        mutableStateOf(1.0f)
    }

    val scaffoldState = rememberBottomSheetScaffoldState()
    val couroutineScope= rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        topBar ={
        TopAppBar(
            title = {
                Text(
                    text = "文章详情",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp)},
            navigationIcon = {
                Icon(
                    imageVector = Icons.Default.NavigateBefore,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        onBack()
                    })
            }, actions = {
                Icon(imageVector = Icons.Default.TextFields,
                    contentDescription =null,
                    modifier = Modifier
                        .clickable {
                            //设置文字大小
                            couroutineScope.launch {
                                if (scaffoldState.bottomSheetState.isCollapsed) {
                                    scaffoldState.bottomSheetState.expand()
                                } else {
                                    scaffoldState.bottomSheetState.collapse()

                                }

                            }
                        }
                        .padding(8.dp))
            }
        )
    },
        modifier = Modifier
            .background(MaterialTheme.colorScheme.onError),
        sheetContent = {
            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = "设置字体")

                Slider(value =fontScalr , onValueChange ={
                    fontScalr=it
                }, steps = 3, valueRange = 0.75f..1.75f)

                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    modifier =Modifier.fillMaxWidth()) {
                    Text(text = "较小", fontSize = 14.sp, color = Color.Gray)//0.75
                    Text(text = "标准",fontSize = 14.sp, color = Color.Gray)//1.0
                    Text(text = "普大",fontSize = 14.sp, color = Color.Gray)//1.25
                    Text(text = "超大",fontSize = 14.sp, color = Color.Gray)//1.5
                    Text(text = "巨大",fontSize = 14.sp, color = Color.Gray)//1.75

                }
                Spacer(modifier = Modifier.height(8.dp))
                
            }
        } )
    {
        Box(modifier = Modifier.padding(it)){
            WebViewContent(webViewState)
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview12() {
    MyApplicationTheme {

    }
}