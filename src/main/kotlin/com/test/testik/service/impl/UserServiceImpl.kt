package com.test.testik.service.impl

import com.test.testik.feign.models.UserDto
import com.test.testik.mapper.merge
import com.test.testik.mapper.patch
import com.test.testik.mapper.toDto
import com.test.testik.mapper.toEntity
import com.test.testik.repository.UserRepository
import com.test.testik.service.UserService
import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*
import java.util.stream.Collectors

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

    @Transactional(readOnly = true)
    override suspend fun get(pageNumber: Int, pageSize: Int): Page<UserDto> {

        val pageRequest = getPageRequest(pageNumber, pageSize)
        val total = userRepository.count().awaitSingle()

        val content = userRepository
            .findAllBy(pageRequest)
            .collectList()
            .awaitSingle()
            .stream()
            .map {
                it.toDto()
            }
            .collect(Collectors.toList())

        return PageImpl(content, pageRequest, total)
    }


    @Transactional(readOnly = true)
    override suspend fun getById(id: UUID): UserDto {

        return findById(id)
            .toDto()
    }


    override suspend fun update(id: UUID, userDto: UserDto): UserDto {

        val entity = findById(id)

        entity.merge(userDto)

        return userRepository
            .save(entity)
            .awaitSingle()
            .toDto()

    }


    override suspend fun patch(id: UUID, userDto: UserDto): UserDto {

        val entity = findById(id)

        entity.patch(userDto)

        return userRepository
            .save(entity)
            .awaitFirst()
            .toDto()

    }

    override suspend fun delete(id: UUID) {

        if (!userRepository.existsById(id).awaitSingle()) {
            throw NotFoundException()
        }

        userRepository.deleteById(id).awaitSingleOrNull()
    }

    private suspend fun findById(id: UUID) = userRepository
        .findById(id)
        .awaitSingle()

    private fun getPageRequest(pageNumber: Int, pageSize: Int) = PageRequest
        .of(pageNumber, pageSize)
        .withSort(Sort.Direction.DESC, "createdAt")

}
