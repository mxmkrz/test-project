package com.test.testik.controller

import com.test.testik.feign.models.UserDto
import com.test.testik.service.UserService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/int/ogm/")
class UserController(
    private val userService: UserService
) {


    @PostMapping(
        value = ["/users"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE],
    )
    suspend fun create(userDto: UserDto): UserDto {
        return userService.create(userDto)

    }
}
