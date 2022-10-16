package com.example.spotify
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.spotify.model.Mix
import com.example.spotify.model.TopMix
import com.example.spotify.ui.theme.GradientBar
import com.example.spotify.ui.theme.SpotifyTheme
import java.security.AccessController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpotifyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SpotifyApp()
                }
            }
        }
    }
}

@Composable
fun SpotifyApp(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavBar(navController) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)){
                Navigation(navController = navController)
            }
        },
        backgroundColor = Color.Transparent
    )
}

@Composable
fun BottomNavBar(navController: NavController){
    val items = listOf(
        NavItem.Home,
        NavItem.Search,
        NavItem.Library
    )
    BottomNavigation(
        modifier = Modifier.background(GradientBar),
        backgroundColor = Color.Transparent,
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach{ item ->
            BottomNavigationItem(
                icon = { Icon(painter = painterResource(item.icon),
                    contentDescription = null)},
                label = { Text(text = item.title)},
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.5f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route){
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route){
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun Navigation(navController: NavHostController){
    NavHost(
        navController,
        startDestination = NavItem.Home.route){
        composable(NavItem.Home.route){
            HomeScreen()
        }

        composable(NavItem.Search.route){
            SearchScreen(
                search = search,
                searchChange = { searchChange(it) },
                onKeyboardDone = { checkSearch() })
        }

        composable(NavItem.Library.route){
            LibraryScreen()
        }
    }
}




@Composable
@Preview
fun BottomNavBarPreview(){
    MaterialTheme{
    }

}



@Composable
@Preview
fun SpotifyAppPreview(){
    SpotifyTheme {
        SpotifyApp()
    }

}