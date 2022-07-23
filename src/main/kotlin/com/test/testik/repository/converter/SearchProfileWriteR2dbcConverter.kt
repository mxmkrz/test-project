package com.test.testik.repository.converter

import com.parity.ogm.common.repository.converter.CustomR2dbcConverter
import com.test.testik.entity.enumerator.SearchProfileEnum
import org.springframework.data.r2dbc.convert.EnumWriteSupport
import org.springframework.stereotype.Component

@Component
class SearchProfileWriteR2dbcConverter : EnumWriteSupport<SearchProfileEnum>(), CustomR2dbcConverter
