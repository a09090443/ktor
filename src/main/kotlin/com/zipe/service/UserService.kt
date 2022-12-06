package com.zipe.service

import com.zipe.configuration.DatabaseFactory
import com.zipe.model.User
import com.zipe.model.Users
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll

class UserService {
    suspend fun findAll(): List<User> = DatabaseFactory.dbExec {
        Users.selectAll().map { toUser(it) }
    }

    private fun toUser(row: ResultRow): User =
        User(
            id = row[Users.id],
            account = row[Users.account],
            password = row[Users.password]
        )

}