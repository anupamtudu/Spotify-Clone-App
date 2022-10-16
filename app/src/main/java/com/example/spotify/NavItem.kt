package com.example.spotify

sealed class NavItem(var route: String, var icon: Int, var title: String){
    object Home: NavItem("home", R.drawable.home, "Home")
    object Search: NavItem("search", R.drawable.search, "Search")
    object Library: NavItem("library", R.drawable.library, "Your Library")
}


