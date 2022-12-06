import com.zipe.service.TestService
import io.ktor.server.routing.Routing
import com.zipe.routing.test
import com.zipe.routing.user
import com.zipe.service.UserService
import com.zipe.configuration.DatabaseFactory
import com.zipe.util.JsonMapper
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.engine.commandLineEnvironment
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation

fun Application.module() {

    install(ContentNegotiation) {
        json(JsonMapper.defaultMapper)
    }

    DatabaseFactory.connectAndMigrate()

    val testService = TestService()
    val userService = UserService()

    install(Routing) {
        test(testService)
        user(userService)
    }
}

fun main(args: Array<String>) {
    embeddedServer(Netty, commandLineEnvironment(args)).start(wait = true)
}
