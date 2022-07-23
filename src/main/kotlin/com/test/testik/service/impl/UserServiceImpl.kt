package com.test.testik.service.impl

import com.test.testik.feign.models.UserDto
import com.test.testik.mapper.toDto
import com.test.testik.mapper.toEntity
import com.test.testik.repository.UserRepository
import com.test.testik.service.UserService
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {


    override suspend fun create(userDto: UserDto): UserDto {
        return userRepository
            .save(userDto.toEntity())
            .awaitSingle()
            .toDto()
    }
}
