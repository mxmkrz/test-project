package com.test.testik.repository

import com.test.testik.entity.UserEntity
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.awt.print.Pageable
import java.util.UUID

@Repository
interface UserRepository : ReactiveCrudRepository<UserEntity,UUID>  {
    fun findAllBy(page:Pageable) : Flux<UserEntity>

    fun findAllByUserId(page: Pageable,userId:UUID) : Flux<UserEntity>

    fun countByUserId(userId: UUID) : Mono<UserEntity>
}
