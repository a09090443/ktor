package com.zipe.model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.*

object Users : Table() {
    val id = integer("id").autoIncrement()
    val account = varchar("account", 100)
    val password = varchar("password", 255)
    override val primaryKey = PrimaryKey(id)
}
@Serializable
data class User(
    val id: Int,
    val account: String,
    val password: String
)