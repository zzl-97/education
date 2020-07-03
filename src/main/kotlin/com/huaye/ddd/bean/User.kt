package com.huaye.ddd.bean

import jdk.nashorn.internal.objects.annotations.Getter
import javax.persistence.*


@Entity









@Table(name ="T_USERS")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    //自定义序列
    @SequenceGenerator(name= "initialValue = 100")
    var userId : Integer ?= null,

    var userName : String ?= null,

    var userPassword : String ?= null
) {

  fun dto() : Dto{
      return Dto(
              id =  userId,
              username = userName
      )
  }

}