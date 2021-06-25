package com.api.sk.entities

import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@Entity
data class Phone(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @field:NotEmpty
    @field:Size(min = 3, max = 3, message = "Field code is not valid")
    val code: String,

    @field:NotEmpty
    @field:Size(min = 8, max = 8, message = "Field number is not valid")
    val number: String,

    @ManyToOne
    @JoinColumn(name = "contact_id")
    val contact: Contact?
)
