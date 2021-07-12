package com.api.sk.service

import com.api.sk.dto.ContactDTO
import com.api.sk.entities.Contact
import com.api.sk.repositories.ContactRepository
import com.api.sk.utils.mapper.MapperDTOEntityContact
import org.springframework.stereotype.Service
import java.util.*

@Service
class ContactService(private val contactRepository: ContactRepository,
                     private val mapperDTOEntityContact: MapperDTOEntityContact) {

    fun listarTodos(): List<Contact> = contactRepository.findAll()

    fun listaPorId(id: Long) = contactRepository.findById(id).map { it }

    fun criaContato(contactDTO: ContactDTO): Contact =
      contactRepository.save(mapperDTOEntityContact.doDTOToEntity(contactDTO))

    fun atualiza(id: Long, contactDTO: ContactDTO): Optional<Contact> =
        contactRepository.findById(id).map {
            val contactAtualizado = it.copy(
                name = contactDTO.name,
                email = contactDTO.email,
                phone = contactDTO.phone
            )
            contactRepository.save(contactAtualizado)
        }


    fun deleta(id: Long) = contactRepository
        .findById(id).map {
            contactRepository.delete(it)}

}
