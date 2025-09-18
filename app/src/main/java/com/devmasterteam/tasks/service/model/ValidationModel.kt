package com.devmasterteam.tasks.service.model

class ValidationModel(message: String = "") {

    private var status: Boolean = true
    private var errorMessage: String = ""

    init {
        if(message != ""){
            status = false
            errorMessage = message
        }
    }

    fun isSuccess(): Boolean {
        return status
    }

    fun message(): String {
        return errorMessage
    }
}