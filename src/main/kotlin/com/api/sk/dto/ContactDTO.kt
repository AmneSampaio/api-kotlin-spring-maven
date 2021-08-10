package com.api.sk.dto

import com.api.sk.entities.Phone

data class ContactDTO(

    val id: Long,

    var name: String,

    var email: String,

    var phone: List<Phone>
)
