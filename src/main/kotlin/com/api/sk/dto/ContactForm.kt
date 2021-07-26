package com.api.sk.dto

import com.api.sk.entities.Phone
import java.time.LocalDateTime
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

    @OneToMany(fetch = FetchType.LAZY,
        cascade = [(CascadeType.ALL)],
        orphanRemoval = true)
    @JoinColumn(name = "contact_id")
    var phone: List<Phone> = emptyList<Phone>(),

    var data: LocalDateTime = LocalDateTime.now()
)
