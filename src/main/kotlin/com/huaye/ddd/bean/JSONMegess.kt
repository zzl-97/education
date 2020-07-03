package com.huaye.ddd.bean

data class JSONMegess (
        var id :Int = 1,
        var message :String = "成功/失败",
        var data: Any? = null
){
}