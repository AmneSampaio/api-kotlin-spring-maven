package com.api.sk.entities

import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@Entity
data class Contact(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @field:NotEmpty
    @field:Size(min = 5, max = 50, message = "Field name is not valid")
    var name: String,

    @field:NotEmpty
    @field:Email(message ="Field email is not valid")
    @field:Column(unique = true)
    var email: String,

    var data: LocalDateTime = LocalDateTime.now(),

    @OneToMany(cascade = arrayOf(CascadeType.ALL))
    //@OrderColumn
    var phones: List<Phones>
)
