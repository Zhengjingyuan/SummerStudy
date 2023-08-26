package com.example.myapplication

import android.content.res.Configuration
import android.os.Bundle
import android.provider.Telephony.Sms.Conversations
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.data.SampleData
import androidx.compose.runtime.*
data class Message(
    val author: String,
    val body: String
)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme() {
// A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Conversation(messages = SampleData.conversationSample)
                }
            }
        }
    }
}



@Composable
fun MessageCard(msg: Message) {
// Add padding around our message
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = null,
            modifier = Modifier
// Set image size to 40 dp
                .size(40.dp)
// Clip image to be shaped as a circle
                .clip(
                    CircleShape
                )
                .border(1.5.dp, MaterialTheme.colors.secondaryVariant, CircleShape)
        )
    }
        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))
        var isExpanded by remember { mutableStateOf(false) }

    // We keep track if the message is expanded or not in this
    // variable KProperty<*>


        Column (modifier = Modifier.clickable { isExpanded = !isExpanded }){
            Text(
            text = msg.author,
            color = MaterialTheme.colors.secondaryVariant,
            style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
            Text(
            text = msg.body,
            modifier = Modifier.padding(all = 4.dp),
                // If the message is expanded, we display all its content
                // otherwise we only display the first line
                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
            style = MaterialTheme.typography.body2
            )
            }
        }
}



        @Composable
        fun Conversation(messages: List<Message>) {
            LazyColumn {
                items(messages) { message ->
                    MessageCard(message)
                }
            }
        }

        @Preview(
            showBackground = true,
            name = "Light Mode"
        )

        @Composable
        fun DefaultPreview() {
            MyApplicationTheme(){
                Conversation(messages = SampleData.conversationSample)
            }
        }

