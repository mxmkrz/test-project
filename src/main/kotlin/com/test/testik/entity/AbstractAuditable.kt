package com.test.testik.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import org.springframework.data.relational.core.mapping.Column
import java.time.OffsetDateTime
import java.util.UUID

abstract class AbstractAuditable(givenId: UUID?) {

    /**
     * Record ID
     */
    @Id
    @Column("id")
    open var id: UUID? = givenId

    /**
     * Record version
     */
    @Column
    @Version
    open var version:Int? = null

    /**
     * Record creation datetime with timezone
     */
    @Column("created_at")
    @CreatedDate
    open var createdAt: OffsetDateTime? = null

    /**
     * Record last modification datetime with timezone
     */
    @Column("modified_at")
    @LastModifiedDate
    open var modifiedAt: OffsetDateTime? = null
}
