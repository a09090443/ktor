package com.zipe.routing

import com.zipe.service.UserService
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

/**
 * @author B04575
 * @Date 2022/12/6
 */

fun Route.user(userService: UserService) {

    get("/user") {
        val users = userService.findAll()
        print(users.size)
        call.respondText(users.size.toString())
    }
}