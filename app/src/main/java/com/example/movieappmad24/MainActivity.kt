package com.example.movieappmad24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppMAD24Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MovieList(movies = listOf("Avatar", "Titanic", "Lord of the Rings", "Start Wars"))
                }
            }
        }
    }
}

/*
Surface() {
}
Icon(
modifier
imageVector
tint
contentDescriptor
)
 */


@Composable
fun MovieRow(movieTitle: String) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp)
    ) {
        Column {
            Box(
            ) {
                Image(
                    painter = painterResource(id = R.drawable.movie_image),
                    //contentScale = ContentScale.Crop,
                    contentDescription = "placeholder_image"
                )
                Icon(
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.TopEnd),
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "Localized description"
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement  =  Arrangement.SpaceBetween,
                verticalAlignment  =  Alignment.CenterVertically) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = movieTitle
                )
                Icon(
                    modifier = Modifier.padding(8.dp),
                    imageVector = Icons.Outlined.KeyboardArrowUp,
                    contentDescription = "ka"
                )
            }
        }
    }

}

@Composable
fun MovieList(movies: List<String>) {
    LazyColumn {
        items(movies) {movie ->
            MovieRow(movieTitle = movie)
        }
    }
}

@Preview
@Composable
fun Preview() {
    MovieList(movies = listOf("Avatar", "Titanic", "Lord of the Rings"))
}
