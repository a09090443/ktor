package com.zipe.routing

import com.zipe.service.UserService
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route

/**
 * @author B04575
 * @Date 2022/12/6
 */
fun Route.user(userService: UserService) {

    route("/user"){
        get("all") {
            val users = userService.findAll()
            call.respond(mapOf("users" to users))
        }
        get("test"){
            userService.findUserByAccount("test1")
            call.respondText("Hello, world!", ContentType.Text.Plain, HttpStatusCode.OK)
        }
    }
}