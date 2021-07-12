package com.api.sk.entities

import com.api.sk.dto.ContactDTO
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
    @field:Email(message = "Field email is not valid")
    @field:Column(unique = true)
    var email: String,

    @OneToMany(fetch = FetchType.LAZY,
               cascade = [(CascadeType.ALL)],
               orphanRemoval = true)
    @JoinColumn(name = "contact_id")
    var phone: List<Phone> = emptyList<Phone>(),

    var data: LocalDateTime = LocalDateTime.now()
) {
    constructor(contactDTO: ContactDTO) : this(0, "", "", emptyList<Phone>()) {
        this.name = contactDTO.name
        this.email = contactDTO.email
        this.phone = contactDTO.phone
    }

    constructor(name: String, email: String, phone: List<Phone>) :this(0,"","", emptyList<Phone>()){
        this.name = name
        this.email = email
        this.phone = phone
    }

    constructor(): this(0,"","", emptyList<Phone>())
}