package com.huaye.ddd.repository

import com.huaye.ddd.bean.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestBody
import test.menu.MenuTest


@Repository
@Transactional(readOnly = true)
interface UserRepository : JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    //查询用户
    fun findByUserNameAndUserPassword(userName: String?, userPassword: String?): User?


}