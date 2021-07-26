package com.api.sk.utils.mapper

import com.api.sk.dto.ContactForm
import com.api.sk.entities.Contact
import org.springframework.stereotype.Component

@Component
class MapperDTOEntityContact : Mapper<ContactForm, Contact> {

    override fun doEntityToDTO(entity: Contact): ContactForm = ContactForm(
        entity.id,
        entity.name,
        entity.email,
        entity.phone
    )


    override fun doDTOToEntity(dto: ContactForm): Contact = Contact(
        dto.name,
        dto.email,
        dto.phone
    )
}