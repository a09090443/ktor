package com.zipe.service

import com.zipe.configuration.DatabaseFactory.dbExec
import com.zipe.model.*
import org.jetbrains.exposed.sql.*

class TestService {
    suspend fun findAll(): List<User> = dbExec {
        Users.selectAll().map { toUser(it) }
    }

    private fun toUser(row: ResultRow): User =
        User(
            id = row[Users.id],
            account = row[Users.account],
            password = row[Users.password]
        )
}