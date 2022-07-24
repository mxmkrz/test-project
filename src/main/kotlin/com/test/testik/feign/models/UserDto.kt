package com.test.testik.feign.models

import com.fasterxml.jackson.annotation.JsonFormat
import com.test.testik.constans.DATE_TIME_WITH_UTC_TIME_ZONE_PATTERN
import com.test.testik.constans.UTC_TIME_ZONE
import org.jetbrains.annotations.NotNull
import java.time.OffsetDateTime
import java.util.*

data class UserDto(

    val id: UUID? = null,

    @field:NotNull
    val userId: UUID? = null,

    val searchProfile: String? = null,

    var searchId: String? = null,

    var searchRef: String? = null,

    var isMonitored: Boolean? = null,

    val version: Int? = null,

    @JsonFormat(
        pattern = DATE_TIME_WITH_UTC_TIME_ZONE_PATTERN,
        timezone = UTC_TIME_ZONE
    )
    val createdAt: OffsetDateTime? = null,

    @JsonFormat(
        pattern = DATE_TIME_WITH_UTC_TIME_ZONE_PATTERN,
        timezone = UTC_TIME_ZONE
    )
    val modifiedAt: OffsetDateTime? = null,
)
