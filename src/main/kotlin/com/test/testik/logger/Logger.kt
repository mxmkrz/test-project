package com.parity.ogm.common.logger

import org.slf4j.LoggerFactory

fun <R : Any> R.logger() = lazy { LoggerFactory.getLogger(this::class.java.name) }
