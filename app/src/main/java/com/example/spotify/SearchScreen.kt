package com.example.spotify

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.spotify.data.DataSource
import com.example.spotify.data.SearchGenre
import com.example.spotify.data.SearchGenre.genres
import com.example.spotify.model.Genre


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchScreen(
    search: String,
    searchChange: (String) -> Unit,
    onKeyboardDone: () -> Unit,
    modifier: Modifier = Modifier){

    Column(modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 40.dp)
        ) {
            Text(
                text = "Search",
                style = MaterialTheme.typography.h1,
                )
        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            value = search,
            onValueChange = searchChange,
            leadingIcon = { Icon(
                painter = painterResource(R.drawable.search),
                contentDescription = null,
                tint = Color.White)},
            label = { Text(
                text = "What do you want to listen to?",
                style = MaterialTheme.typography.h3)},
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { onKeyboardDone }
            ),
            shape = RoundedCornerShape(5.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Browse all",
                style = MaterialTheme.typography.h4,

                )
        }
        
        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.padding(15.dp)
            ){
            items(SearchGenre.genres){
                genre -> GenreGrid(genre)
            }
        }

    }
}

@Composable
fun GenreGrid(genre: Genre, modifier: Modifier = Modifier){
    Card(elevation = 4.dp) {
        Image(
            painter = painterResource(genre.drawableResourceID),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .aspectRatio(1f)
                .clickable { },
            contentScale = ContentScale.Crop)
    }
}

var search by mutableStateOf("")
    private set

fun searchChange(word: String){
    search = word
}

fun checkSearch() {
    searchChange("")
}