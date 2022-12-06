package com.zipe.util

import kotlinx.serialization.json.Json

/**
 * @author B04575
 * @Date 2022/12/6
 */
object JsonMapper {

    val defaultMapper = Json {
        prettyPrint = true
    }

}