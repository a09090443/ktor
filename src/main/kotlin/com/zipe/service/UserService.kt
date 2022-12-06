package com.zipe.service

import com.zipe.configuration.DatabaseFactory
import com.zipe.model.User
import com.zipe.model.Users
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.ResultSet
import javax.swing.text.html.HTML.Tag.*

class UserService {
    suspend fun findAll(): List<User> = DatabaseFactory.dbExec {
        Users.selectAll().map { toUser(it) }
    }

    fun findUserByAccount(account: String) = transaction {
        TransactionManager.current().exec("SELECT account, password FROM users WHERE account = '$account'") { rs ->
            val result = arrayListOf<Pair<String, String>>()
            while (rs.next()) {
                result += rs.getString("account") to rs.getString("password")
            }
            result
        }?.forEach { result ->
            println(result.first)
        }

    }

}

private fun toUser(row: ResultRow): User =
    User(
        id = row[Users.id],
        account = row[Users.account],
        password = row[Users.password]
    )