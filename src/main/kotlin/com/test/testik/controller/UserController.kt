package com.test.testik.controller

import com.parity.ogm.common.logger.logger
import com.test.testik.feign.models.UserDto
import com.test.testik.service.UserService
import org.checkerframework.checker.index.qual.Positive
import org.slf4j.Logger
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/int/ogm/")
class UserController(
    private val userService: UserService
) {

    private val log: Logger by logger()

    @PostMapping(
        value = ["/users"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE],
    )
    suspend fun create(@RequestBody userDto: UserDto): UserDto {
        log.info("Create user  request received")

        return userService.create(userDto)

    }


    @GetMapping(
        value = ["/users"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
    )
    suspend fun get(
        @RequestParam(required = false, defaultValue = "0") pageNumber: Int,
        @RequestParam(required = false, defaultValue = "5") pageSize: Int,
    ): Page<UserDto> {

        log.info("Get user  request received. Pagination: pageNumber = $pageNumber, pageSize = $pageSize")

        return userService.get(pageNumber, pageSize)
    }


    @GetMapping(
        value = ["/users/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
    )
    suspend fun getById(@PathVariable id: UUID): UserDto {

        log.info("Get user  by id request received")

        return userService.getById(id)
    }

    @PutMapping(
        value = ["/users/{id}"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE],
    )
    suspend fun update(
        @PathVariable id: UUID,
        @RequestBody dto: UserDto,
    ): UserDto {

        log.info("Update user  request received")

        return userService.update(id, dto)
    }

    @PatchMapping(
        value = ["/users/{id}"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE],
    )
    suspend fun patch(
        @PathVariable id: UUID,
        @RequestBody dto: UserDto,
    ): UserDto {

        log.info("Patch user request received")

        return userService.patch(id, dto)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = ["/users/{id}"])
    suspend fun delete(@PathVariable id: UUID) {

        log.info("Delete user by id request received")

        userService.delete(id)
    }

}
