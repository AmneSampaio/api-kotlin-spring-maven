package com.api.sk.dto

import com.api.sk.entities.Phone
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class ContactView(

    val id: Long,

    var name: String,

    var email: String,

    var phone: List<Phone>,

    var data: LocalDateTime
)
