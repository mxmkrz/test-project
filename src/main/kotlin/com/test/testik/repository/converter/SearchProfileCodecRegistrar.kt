package com.test.testik.repository.converter


import com.google.auto.service.AutoService
import com.test.testik.entity.enumerator.SearchProfileEnum
import io.netty.buffer.ByteBufAllocator
import io.r2dbc.postgresql.api.PostgresqlConnection
import io.r2dbc.postgresql.codec.CodecRegistry
import io.r2dbc.postgresql.codec.EnumCodec
import io.r2dbc.postgresql.extension.CodecRegistrar
import io.r2dbc.postgresql.extension.Extension


@AutoService(Extension::class)
open class SearchProfileCodecRegistrar : CodecRegistrar, Extension {
    private val codecRegistrar: CodecRegistrar = EnumCodec.builder()
        .withEnum("search_profile", SearchProfileEnum::class.java)
        .build()

    override fun register(
        connection: PostgresqlConnection,
        allocator: ByteBufAllocator,
        registry: CodecRegistry
    ) = codecRegistrar.register(connection, allocator, registry)
}
