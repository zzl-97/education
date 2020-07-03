package com.huaye.ddd.controller

import com.huaye.ddd.bean.Dto
import com.huaye.ddd.bean.JSONMegess
import com.huaye.ddd.bean.User
import com.huaye.ddd.repository.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import javax.persistence.Id
import javax.print.attribute.IntegerSyntax


@RestController
@RequestMapping("/zzl")
@CrossOrigin
class LoginController(
    var userRepository: UserRepository
) {
    @PostMapping("/Login")
    fun selectUser(@RequestBody u: User): ResponseEntity<JSONMegess> {
        println(u.userName)
        println(u.userPassword)
        val user = userRepository.findByUserNameAndUserPassword(u.userName, u.userPassword)
            ?: return ResponseEntity.ok(JSONMegess(message = "暂无"))
        var jsonMegess: JSONMegess = JSONMegess(message = "成功", data = user)

        return ResponseEntity.ok(jsonMegess)
    }

    @PostMapping("/add")
    fun addUser(@RequestBody u: User): String? {
        val user = User()

        user.userName = u.userName
        user.userPassword = u.userPassword
        userRepository.save(user)
        return "save";
    }


    //修改 用户信息
    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Integer, @RequestBody u: Dto): String? {
        //val user: User = userRepository.findById(u.userId).get()
        userRepository.findById(id).map {
            it.userName = u.username
            userRepository.save(it)
        }
        // user.userName = u.userName

        return "update";
    }

    //删除用户
    @DeleteMapping("/deleUser/{id}")
    fun deleUser(@PathVariable id: Integer): String? {
        userRepository.findById(id).map {
            userRepository.deleteById(id);
        }

        return "dele" + id;
    }

}