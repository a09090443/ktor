package com.zipe.service

import com.zipe.configuration.DatabaseFactory.dbExec
import com.zipe.model.*
import org.jetbrains.exposed.sql.*

class TestService {

    fun testPrint(out: String) = print("test print $out")
}