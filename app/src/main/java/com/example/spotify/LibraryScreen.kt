package com.example.spotify

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.spotify.data.LibraryList
import com.example.spotify.data.RowList
import com.example.spotify.data.TopMixDS
import com.example.spotify.model.LibList
import com.example.spotify.model.lib
import com.example.spotify.ui.theme.LightBlack

@Composable
fun LibraryScreen(){
    Column(modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 40.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.mypic),
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .weight(1f)
                    .size(30.dp)
                    .clip(RoundedCornerShape(50))
            )
            Text(
                text = "Your Library",
                style = MaterialTheme.typography.h1,
                modifier = Modifier.weight(5f)
            )

            Icon(
                painter = painterResource(R.drawable.search),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .size(30.dp)
                    .clickable { }
            )
            Icon(
                painter = painterResource(R.drawable.plus),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .size(30.dp)
                    .clickable { }
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow(
            modifier = Modifier
                .padding(5.dp)
                .background(MaterialTheme.colors.background),
            horizontalArrangement = Arrangement.spacedBy(5.dp)){
            items(RowList.buttons){
                libItem(libText = it)
            }
        }

        LazyColumn(
            modifier = Modifier
                .padding(5.dp)
                .background(Color.Transparent),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
            item{
                RecentBar()
            }
            
            items(LibraryList.list){
                listItem(ll = it)
            }
        }
    }
}


@Composable
fun libItem(libText: lib){
    Button(
        onClick= { },
        modifier = Modifier.background(Color.Black),
        shape = RoundedCornerShape(50)
    ){
        Text(
            text = stringResource(libText.stringResourceID),
            style = MaterialTheme.typography.body1)
    }
}

@Composable
fun listItem(ll: LibList, modifier: Modifier = Modifier){
    Card(
        elevation = 4.dp,
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier.clickable {  },
        shape = RoundedCornerShape(0.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Box {
                Image(
                    painter = painterResource(ll.drawableResourceID),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }

            Column() {
                Text(
                    text = stringResource(ll.stringResourceID),
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = stringResource(ll.stringResourceID2),
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(start = 10.dp))
            }
        }
    }
}

@Composable
fun RecentBar(){
    Row() {
        Icon(
            painter = painterResource(R.drawable.swap),
            contentDescription = null)
        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            text = "Most Recent",
            style = MaterialTheme.typography.body1)

    }
}