package com.pluu.sample.remote.common

import kotlinx.serialization.Serializable

@Serializable
data class ApiItem(
    val name: String,
    val path: String
)

@Serializable
data class ApiList(
    val sample: List<ApiItem>,
    val custom: List<ApiItem>
)

@Serializable
data class ApiResponse(
    val api: ApiList
)
