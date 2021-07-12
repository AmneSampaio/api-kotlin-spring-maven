package com.api.sk.utils.mapper

import com.api.sk.dto.ContactDTO
import com.api.sk.entities.Contact
import org.springframework.stereotype.Component

@Component
class MapperDTOEntityContact : Mapper<ContactDTO, Contact> {

    override fun doEntityToDTO(entity: Contact): ContactDTO = ContactDTO(
        entity.name,
        entity.email,
        entity.phone
    )


    override fun doDTOToEntity(dto: ContactDTO): Contact = Contact(
        dto.name,
        dto.email,
        dto.phone
    )
}