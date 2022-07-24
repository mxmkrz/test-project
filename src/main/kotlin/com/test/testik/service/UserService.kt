package com.test.testik.service

import com.test.testik.feign.models.UserDto
import org.springframework.data.domain.Page
import java.util.*

interface UserService {

    suspend fun create(userDto: UserDto): UserDto

    suspend fun get(pageNumber: Int, pageSize: Int): Page<UserDto>

    suspend fun getById(id: UUID): UserDto

    suspend fun update(id: UUID,userDto: UserDto): UserDto

    suspend fun patch(id: UUID,userDto: UserDto): UserDto

    suspend fun delete(id: UUID)

}