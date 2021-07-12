package com.api.sk.dto

import com.api.sk.entities.Phone

data class ContactDTO(

    var name: String,

    var email: String,

    var phone: List<Phone>
)
