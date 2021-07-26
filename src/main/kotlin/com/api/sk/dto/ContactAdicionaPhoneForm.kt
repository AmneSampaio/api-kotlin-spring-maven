package com.api.sk.dto

import com.api.sk.entities.Phone
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class ContactAdicionaPhoneForm(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @OneToMany(fetch = FetchType.LAZY,
        cascade = [(CascadeType.ALL)],
        orphanRemoval = true)
    @JoinColumn(name = "contact_id")
    var phone: Phone
)
