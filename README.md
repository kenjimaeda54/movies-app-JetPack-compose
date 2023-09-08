# Movies App
Pequena aplicação onde pode visualizar alguns filmes gravados e visualizar os detalhes

## Motivação
Treinar JetPack Compose para criar aplicações em Android

## Feature
- Neste aplicativo estou usando o [Material Theme 3](https://developer.android.com/jetpack/compose/designsystems/material3) para criar as aplicações
- [Esta documentação](https://foso.github.io/Jetpack-Compose-Playground/foundation/shape/) consegue visualizar o core
- Para lidar com imagens assíncronas instalei o [Coil](https://coil-kt.github.io/coil/compose/)
- Para realizar efeito de scrollar, posso usar próprio Column com a propriedade .verticalScroll

```kotlin
  AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current).data(movie.images[0])
                        .crossfade(true).build(),
                    contentDescription = "Image Poster",
                    contentScale = ContentScale.FillHeight

)


 Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .padding(top = it.calculateTopPadding())
                        .verticalScroll(
                            rememberScrollState()
                        )

                )


```

##
- Para navegar com estilo stack em Compose, existe n maneiras de fazer, conveniente primeiro criar um Enum com as rotas,depois criar o  NavController e por fim os Graph
- Repara que estou passando o NavController para todos os arquivos de visualização, motivo e que NavController  e responsável pela lógica de navegar ou retornar entre as stacks
 

``` kotlin
//crio os enums das rotas
enum class MovieScreens {
    HomeScreen,
    DetailsScreen;

    companion object {
        fun fromRoute(route: String?): MovieScreens = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            else -> throw IllegalArgumentException("Route  $route is not regonizable")
        }
    }

}

//crio o navcontroller
@Composable
fun MovieRoute() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name) {
        composable(MovieScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }

        //exemplo como passar parametro via rota
        composable(
            MovieScreens.DetailsScreen.name + "/{movie}",
            arguments = listOf(navArgument("movie") { type = NavType.StringType })
        ) {
            DetailsScreen(navController = navController, it.arguments?.getString("movie"))
        }

    }

}

//para navegar
//DetailsScreen aceita parametro
 RowMovies(it) {
                    navController.navigate(route = MovieScreens.DetailsScreen.name + "/$it")
 }

//no arquivo DetailsScreen, vou receber como parametro de função, parecido com swift
DetailsScreen(navController: NavController, movieId: String?)

//para retornar
  modifier = Modifier
                            .size(15.dp)
                            .clickable {
                                navController.popBackStack()
},


```
