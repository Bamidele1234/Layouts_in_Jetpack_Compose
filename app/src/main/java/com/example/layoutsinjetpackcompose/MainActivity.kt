package com.example.layoutsinjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.layoutsinjetpackcompose.ui.theme.LayoutsInJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutsInJetpackComposeTheme {
                LayoutsCodelab()
            }
        }
    }
}

@Composable
fun LayoutsCodelab(){
    Scaffold (
        topBar = {
            TopAppBar (
                title = {
                    Text(text = "LayoutsCodelab")
                },
                actions = {
                    IconButton(onClick = {/* Some action */}){
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        BodyContent(
            Modifier
                .padding(innerPadding)
                .padding(8.dp))
    }
}

@Composable
fun ImageListItem(index: Int){
    Row(verticalAlignment = Alignment.CenterVertically){
        Image(
            painter = rememberImagePainter (
                data = "https://developer.android.com/images/brand/Android_Robot.png"
            ),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(Modifier.width(10.dp))
        Text("Item #$index", style = MaterialTheme.typography.subtitle1)

    }
}

@Composable
fun BodyContent(modifier : Modifier = Modifier){
    Column(modifier = Modifier) {
        Text(text = "Hi there")
        Text(text = "Thanks for going through the Layouts codelab")

    }
}

@Composable
fun SimpleList(){
    // We save the scrolling position with this state that can also
    // be used to programmatically scroll the list
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState){
        items(100) {
            ImageListItem(it)
        }
    }
}

@Preview(
    widthDp = 393,
    heightDp = 786,
    name = "Preview on my device"
)
@Composable
fun LayoutsCodelabPreview(){
    LayoutsInJetpackComposeTheme {
        LayoutsCodelab()
    }
}

@Preview(
    widthDp = 350,
    heightDp = 350,
    name = "ScrollableList"
)
@Composable
fun ListPreview(){
    LayoutsInJetpackComposeTheme {
        SimpleList()
    }
}