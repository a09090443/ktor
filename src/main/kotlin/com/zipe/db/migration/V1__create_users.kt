package com.zipe.db.migration

import com.zipe.model.*
import org.flywaydb.core.api.migration.BaseJavaMigration
import org.flywaydb.core.api.migration.Context
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

class V1__create_users : BaseJavaMigration() {
    override fun migrate(context: Context?) {
        transaction {
            SchemaUtils.create(Users)

            Users.insert {
                it[account] = "test1"
                it[password] = "aabbcc"
            }
            Users.insert {
                it[account] = "test2"
                it[password] = "bbccdd"
            }
        }
    }
}
