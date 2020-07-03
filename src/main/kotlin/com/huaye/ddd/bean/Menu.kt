package com.huaye.ddd.bean

import javax.persistence.*

@Entity
@Table(name ="T_MENUS")
data class Menu (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //自增主键
    var menuId : Integer ?=null,

    var menuName : String ?=null,

    var MenuUrl : String ?=null
) {

}