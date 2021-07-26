package com.api.sk.utils.mapper

import com.api.sk.dto.ContactForm


interface Mapper<DTO, Entity> {

    fun doEntityToDTO(entity: Entity): DTO
    fun doDTOToEntity(dto: ContactForm): Entity
}