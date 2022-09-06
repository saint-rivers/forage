package com.ksga.forage.model

sealed class ApiResponse(
    open val message: String,
    open val status: String
) {

    class SuccessWithPayload(
        override val message: String,
        override val status: String,
        val payload: Any
    ) : ApiResponse(message, status)

    class SuccessWithPage(
        override val message: String,
        override val status: String,
        val payload: Any,
        val page: Int,
        val size: Int,
        val totalElements: Long,
        val totalPages: Int
    ) : ApiResponse(message, status)

    class Failure(
        override val message: String,
        override val status: String,
    ) : ApiResponse(message, status)

    class Success(
        override val message: String,
        override val status: String,
    ) : ApiResponse(message, status)
}
