import com.zipe.service.TestService
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.Routing
import com.zipe.routing.test

fun Application.module() {

    val testService = TestService()

    install(Routing) {
        test(testService)
    }
}

fun main(args: Array<String>) {
    embeddedServer(Netty, commandLineEnvironment(args)).start(wait = true)
}
