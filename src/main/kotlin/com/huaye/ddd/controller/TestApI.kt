package com.huaye.ddd.controller


import com.huaye.ddd.bean.JSONMegess
import com.huaye.ddd.bean.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin//跨域请求
@RequestMapping("/zzl")//postman请求地址
class TestApI {

    @GetMapping("/hellow")
    fun testget() :String{

        return "hello  word";
    }

    @PostMapping("/testhellow")
    fun testpost(@RequestBody user :User):ResponseEntity<JSONMegess>{
        ResponseEntity.badRequest()
        return ResponseEntity.ok(JSONMegess(data = user));
    }

    @PutMapping("/hello")
    fun putHello(@RequestBody user :User): ResponseEntity<JSONMegess> {
        println(user.userId)
        val list = arrayListOf("12", 23, 2132, 2132)
        list.map {
            println(it)
        }
        return ResponseEntity.ok(JSONMegess(data = user))
    }

    @DeleteMapping("/hello/{id}")
    fun deleteHello(@PathVariable id: String): ResponseEntity<JSONMegess> {
        return ResponseEntity.ok(JSONMegess(message = "删除$id"))
    }

    @DeleteMapping("/hello")
    fun deleteHello1(id: String): ResponseEntity<JSONMegess> {
        return ResponseEntity.ok(JSONMegess(message = "删除$id"))
    }

}