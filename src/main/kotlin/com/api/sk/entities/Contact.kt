package com.api.sk.entities

import com.sun.istack.NotNull
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.Size

@Entity
class Contact(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @field:NotNull
    @field:Size(min = 5, max = 50, message = "Campo nome não pode ser vazio")
    var name: String,

    @field:NotNull
    @field:Email(message ="Campo email não pode ser vazio")
    var email: String
)
