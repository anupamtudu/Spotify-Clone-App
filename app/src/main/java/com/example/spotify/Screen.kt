package com.example.spotify

import android.graphics.Paint
import android.widget.AbsListView
import android.widget.OverScroller
import android.widget.Scroller
import android.widget.Space
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.spotify.data.DataSource
import com.example.spotify.data.SadMixDS
import com.example.spotify.data.TopMixDS
import com.example.spotify.model.Mix
import com.example.spotify.model.SadMix
import com.example.spotify.model.TopMix
import com.example.spotify.ui.theme.LightBlack

@Composable
fun HomeScreen() {
    Box(modifier = Modifier.background(Color.Transparent)){
        Column(modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 40.dp)
            ) {
                Text(
                    text = stringResource(R.string.greet1),
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.weight(5f)
                )

                Icon(
                    painter = painterResource(R.drawable.bell),
                    contentDescription = null,
                    modifier = Modifier
                        .weight(1f)
                        .size(30.dp)
                        .clickable {  }
                )
                Icon(
                    painter = painterResource(R.drawable.recentplay),
                    contentDescription = null,
                    modifier = Modifier
                        .weight(1f)
                        .size(30.dp)
                        .clickable {  }
                )
                Icon(
                    painter = painterResource(R.drawable.settings),
                    contentDescription = null,
                    modifier = Modifier
                        .weight(1f)
                        .size(30.dp)
                        .clickable {  }
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row() {
                Button(
                    shape = RoundedCornerShape(50),
                    onClick = { /*TODO*/ },
                ) {
                    Text(
                        text = "Music",
                        style = MaterialTheme.typography.body1
                    )
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Button(
                    shape = RoundedCornerShape(50),
                    onClick = { /*TODO*/ }) {
                    Text(
                        text = "Podcasts & Shows",
                        style = MaterialTheme.typography.body1
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Scrollable()
        }
    }

}

@Composable
fun Scrollable() {
    MixGrid()
    Spacer(modifier = Modifier.height(10.dp))
    Text(
        text = stringResource(R.string.y_t_m),
        style = MaterialTheme.typography.h1
    )
    Spacer(modifier = Modifier.height(0.dp))
    TopMixRow()
    Spacer(modifier = Modifier.height(10.dp))
    Text(
        text = stringResource(R.string.s_s),
        style = MaterialTheme.typography.h1
    )
    Spacer(modifier = Modifier.height(0.dp))
    SadMixRow()
}






@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MixGrid(modifier: Modifier = Modifier){
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(8.dp)){
        items(DataSource.mixes){
            mix -> MixCard(mix)
        }
    }
}

@Composable
fun MixCard(mix: Mix, modifier: Modifier = Modifier){
    Card(
        elevation = 4.dp,
        backgroundColor = LightBlack,
        modifier = Modifier.clickable {  }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Box {
                Image(
                    painter = painterResource(mix.drawableResourceID),
                    contentDescription = stringResource(mix.stringResourceID),
                    modifier = Modifier
                        .size(55.dp, 55.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }

            Column() {
                Text(
                    text = stringResource(mix.stringResourceID),
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(start = 10.dp)
                    )
            }

        }
    }
}


@Composable
fun TopMixRow(){
    LazyRow(
        modifier = Modifier
            .padding(8.dp)
            .background(MaterialTheme.colors.background),
        horizontalArrangement = Arrangement.spacedBy(15.dp)){
        items(TopMixDS.topMixes){
            TopMixCard(topMix = it)
        }
    }
}

@Composable
fun TopMixCard(topMix: TopMix, modifier: Modifier = Modifier){
    Card(
        shape = RoundedCornerShape(0.dp),
        backgroundColor = Color.Transparent
    ) {
        Column {
            Image(
                painter = painterResource(topMix.drawableResourceID),
                contentDescription = stringResource(topMix.stringResourceID),
                modifier = Modifier
                    .size(160.dp)
                    .clickable {  },
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row() {
                Text(
                    text = stringResource(topMix.stringResourceID),
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier.wrapContentSize()
                )
            }



        }
    }

}

@Composable
fun SadMixRow(){
    LazyRow(
        modifier = Modifier
            .padding(8.dp)
            .background(MaterialTheme.colors.background),
        horizontalArrangement = Arrangement.spacedBy(15.dp)){
        items(SadMixDS.sadMixes){
            SadMixCard(sadMix = it)
        }
    }
}

@Composable
fun SadMixCard(sadMix: SadMix, modifier: Modifier = Modifier){
    Card(
        shape = RoundedCornerShape(0.dp),
        backgroundColor = Color.Transparent
    ) {
        Column {
            Image(
                painter = painterResource(sadMix.drawableResourceID),
                contentDescription = stringResource(sadMix.stringResourceID),
                modifier = Modifier
                    .size(160.dp)
                    .clickable {  },
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row() {
                Text(
                    text = stringResource(sadMix.stringResourceID),
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier.wrapContentSize()
                )
            }



        }
    }

}
