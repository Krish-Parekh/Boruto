<h1 align="center">Boruto</h1>
<p align="center">  
🌟 Boruto app is based on modern Android development with Hilt, Coroutines, Flow, Jetpack (Room, ViewModel, Paging3), and Material Design based on MVVM architecture.
</p>
<img src="/preview/borutoLanding.png"/>

<br>
<br>

<img src="/preview/boruto4.gif" align="right"/>

## Tech stack & Open-source libraries

- Minimum SDK level 24
- [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous.
- [Hilt](https://dagger.dev/hilt/) for dependency injection.
- Jetpack
  - Lifecycle - Observe Android lifecycles and handle UI states upon the lifecycle changes.
  - ViewModel - Manages UI-related data holder and lifecycle aware. Allows data to survive configuration changes such as screen rotations.
  - Room Persistence - Constructs Database by providing an abstraction layer over SQLite to allow fluent database access.
  - Paging3 - It has support for requesting the next page to load more data automatically.
  - DataStore - DataStore preference is a data storage solution. It allows us to store key-value pairs (like SharedPreferences)
- Architecture
  - MVVM Architecture (View - ViewModel - Usecases - Model)
  - Repository Pattern
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - Construct the REST APIs.
- [Moshi](https://github.com/square/moshi/) - A modern JSON library for Kotlin and Java.
- [Coil](https://coil-kt.github.io/coil/compose/)
- [Material-Components](https://github.com/material-components/material-components-android) - Material design components for building ripple animation, and CardView.
- [Palette](https://developer.android.com/training/material/palette-colors) -The palette library is a support library that extracts prominent colors from images to help you create visually engaging apps
- [SwipeToRefresh](https://code.amcbizprojects.co.in/2021/09/12/swipe-refresh-layout-jetpack-compose/) - Swipe Refresh in jetpack compose is same as SwipeRefreshLayout with the help of which you can update your UI just swiping from up to down.
- Custom Views
  - [Rating Widget](https://github.com/Krish-Parekh/Boruto/blob/master/app/src/main/java/com/krish/borutoapp/presentation/components/RatingWidget.kt) - A custom rating widget for each character.
  - [Ordered List](https://github.com/Krish-Parekh/Boruto/blob/master/app/src/main/java/com/krish/borutoapp/presentation/components/OrderList.kt) - To display the abilities, family and nature in the order of their appearance.
  - [Shimmer Effect](https://github.com/Krish-Parekh/Boruto/blob/master/app/src/main/java/com/krish/borutoapp/presentation/components/ShimmerEffect.kt) - A shimmer effect for the list of characters when they are in loading state.

<br>
<br>

## Video Walkthrough

 <table style="border:1px solid black;margin-left:auto;margin-right:auto;">
	<thead>
	<tr>
		<th>Light Mode Preview</th>
    <th>Dark Mode Preview</th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td>
            <img src="/preview/boruto1.gif"/>
        </td>
        <td>
            <img src="/preview/boruto4.gif"/>
        </td>
	</tr>
	</tbody>
</table>
