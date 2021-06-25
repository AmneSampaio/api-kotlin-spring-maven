package com.api.sk.dto

import com.api.sk.entities.Phone
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class ContactForm(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @field:NotEmpty
    @field:Size(min = 5, max = 50, message = "Field name is not valid")
    var name: String,

    @field:NotEmpty
    @field:Email(message = "Field email is not valid")
    @field:Column(unique = true)
    var email: String,

    @OneToMany(cascade = [CascadeType.ALL])
    var phone: List<Phone>
)