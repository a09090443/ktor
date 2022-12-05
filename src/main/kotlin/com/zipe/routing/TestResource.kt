package com.zipe.routing

import com.zipe.service.TestService
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.test(testService: TestService) {

    get("/test") {
        testService.testPrint("I'm testing")
        call.respondText("Test index")
    }
}
