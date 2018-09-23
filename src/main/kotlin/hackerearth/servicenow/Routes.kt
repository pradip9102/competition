package hackerearth.servicenow

import java.util.*
import kotlin.collections.ArrayList

class Routes {
}

data class Route(val startCity: Int, val endCity: Int, val flightTime: Int, val flightCost: Int)

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val earningPerHour = scanner.nextInt()
    val cityCount = scanner.nextInt()
    val routeCount = scanner.nextInt()

    val routes = hashMapOf<Int, ArrayList<Route>>()
    for (i in 1..routeCount) {
        val route = Route(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt())
        routes.putIfAbsent(route.startCity, arrayListOf())
        routes.putIfAbsent(route.endCity, arrayListOf())
        routes[route.startCity]?.add(route)
        routes[route.endCity]?.add(route)
    }

    val source = scanner.nextInt()
    val destination = scanner.nextInt()


}