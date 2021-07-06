package com.api.sk.dto

import com.api.sk.entities.Phone
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class ContactDTO(

    var name: String,

    var email: String,

    var phone: List<Phone>
)
