package com.krish.borutoapp.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.krish.borutoapp.presentation.screens.details.DetailsScreen
import com.krish.borutoapp.presentation.screens.home.HomeScreen
import com.krish.borutoapp.presentation.screens.search.SearchScreen
import com.krish.borutoapp.presentation.screens.splash.SplashScreen
import com.krish.borutoapp.presentation.screens.welcome.WelcomeScreen
import com.krish.borutoapp.util.Constants.DETAILS_ARGUMENT_KEY

@OptIn(ExperimentalPagerApi::class,ExperimentalCoilApi::class,ExperimentalMaterialApi::class)
@Composable
fun SetupNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navController = navController)
        }

        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(DETAILS_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {
            DetailsScreen(navController = navController)
        }

        composable(route = Screen.Search.route) {
            SearchScreen(navController = navController)
        }
    }


}