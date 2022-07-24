package com.test.testik.mapper

import com.test.testik.entity.UserEntity
import com.test.testik.entity.enumerator.SearchProfileEnum
import com.test.testik.feign.models.UserDto

fun UserDto.toEntity() = UserEntity(
    id = id,
    userId = userId ?: throw IllegalArgumentException("Field userId must not be null!"),
    searchProfile = getSearchProfile(searchProfile),
    searchId = searchId,
    searchRef = searchRef,
    isMonitored = isMonitored

)

fun UserEntity.toDto() = UserDto(
    id = id,
    userId = userId,
    searchProfile = searchProfile?.name,
    searchId = searchId,
    searchRef = searchRef,
    isMonitored = isMonitored,
    version = version,
    createdAt = createdAt,
    modifiedAt = modifiedAt
)

fun UserEntity.merge(userDto: UserDto) {
    searchProfile = getSearchProfile(userDto.searchProfile)
    searchId = userDto.searchId
    searchRef = userDto.searchRef
    isMonitored = userDto.isMonitored
}

fun UserEntity.patch(userDto: UserDto) {
    searchProfile = getSearchProfile(userDto.searchProfile) ?: searchProfile
    searchId = userDto.searchId ?: searchId
    searchRef = userDto.searchRef ?: searchRef
    isMonitored = userDto.isMonitored ?: isMonitored
}


fun getSearchProfile(searchProfile: String?): SearchProfileEnum? {
    return searchProfile?.let {
        SearchProfileEnum.valueOf(it)
    }
}