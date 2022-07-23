package com.test.testik.entity

import com.test.testik.entity.enumerator.SearchProfileEnum
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("user_tb")
class UserEntity(

    id: UUID?,

    var userId: UUID,

    var searchProfile: SearchProfileEnum?,

    var searchId: String?,

    var searchRef: String?,

    var isMonitored: Boolean?,
) : AbstractAuditable(id)
