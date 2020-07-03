package com.huaye.ddd.bean

data class Dto (

        var id : Integer ?= null,
        var username : String ?= null
) {

    fun entity() : User{
        return User(
                userId = id,
                userName = username
        )
    }
}