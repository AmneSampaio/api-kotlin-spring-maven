package com.api.sk.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@Entity
data class Phone(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    @field:JsonIgnore
    var id: Long,

    @field:NotEmpty
    @field:Size(min = 3, max = 3, message = "Field code is not valid")
    var code: String,

    @field:NotEmpty
    @field:Size(min = 8, max = 8, message = "Field number is not valid")
    var number: String

)
