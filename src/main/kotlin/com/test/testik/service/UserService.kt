package com.test.testik.service

import com.test.testik.feign.models.UserDto

interface UserService {

    suspend fun create(userDto: UserDto): UserDto
}