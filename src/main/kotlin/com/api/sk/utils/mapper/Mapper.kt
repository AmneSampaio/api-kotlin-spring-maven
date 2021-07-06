package com.api.sk.utils.mapper

import com.api.sk.dto.ContactDTO


interface Mapper<DTO, Entity> {

    fun doEntityToDTO(entity: Entity): DTO
    fun doDTOToEntity(dto: ContactDTO): Entity
}