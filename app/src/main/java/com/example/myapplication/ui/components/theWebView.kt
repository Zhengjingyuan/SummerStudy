package com.example.myapplication.ui.components

import android.os.Bundle
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.myapplication.ui.components.ui.theme.MyApplicationTheme
class theWebView : ComponentActivity() {
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

@Composable
fun WebViewContent(state: WebViewState){
    AndroidView(factory = {context ->
            WebView(context)
    }){
        view->

        when(val content=state.content){
            is WebContent.Url->{
                val url=content.url
                //url不空并且和当前加载url不同
                if(url.isNotEmpty()&&url!=view.url){
                    view.loadUrl(content.url)
                }
            }

            is WebContent.Data->{
                view.loadDataWithBaseURL(
                    content.baseUrl,
                    content.data,
                    null,
                    "utf-8",
                    null
                )
            }
        }
    }

}

sealed class WebContent(){
    data class Url(val url:String):WebContent()
    data class Data(val data:String,val baseUrl:String?=null):WebContent()
}

class WebViewState(webContent: WebContent){
    //网页内容：url 或者 html内容：data
    var content by mutableStateOf(webContent)

    //TODO 遗留问题
    var pageTitle:String?by mutableStateOf(null)

}

@Composable
fun remeberWebViewState(url:String)= remember(key1 = url) {
    WebViewState(WebContent.Url(url))
    
}
@Composable
fun remeberWebViewState(
    data: String,
    baseUrl:String?=null
    ) = remember(key1 = data,key2 = baseUrl) {
    WebViewState(WebContent.Data(data,baseUrl))

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview14() {
    MyApplicationTheme {

    }
}