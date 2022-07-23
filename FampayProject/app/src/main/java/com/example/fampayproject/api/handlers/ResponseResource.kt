package com.example.fampayproject.api.handlers

//enum class used as status of response
enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}

//handling response
data class ResponseResource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {

        //when it is successful
        fun <T> success(data: T): ResponseResource<T> {
            return ResponseResource(status = Status.SUCCESS, data = data, message = null)
        }

        //when it is an error
        fun <T> error(data: T, message: String?): ResponseResource<T> {
            return ResponseResource(status = Status.ERROR, data = data, message = message)
        }

        //when it is loading
        fun <T> loading(data: T): ResponseResource<T> {
            return ResponseResource(status = Status.LOADING, data = data, message = null)
        }
    }
}