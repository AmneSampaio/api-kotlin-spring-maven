package com.api.sk.service

import com.api.sk.dto.ContactDTO
import com.api.sk.entities.Contact
import com.api.sk.repositories.ContactRepository
import com.api.sk.utils.mapper.MapperDTOEntityContact
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class ContactService(private val contactRepository: ContactRepository,
                     private val mapperDTOEntityContact: MapperDTOEntityContact) {

    fun listarTodos(): List<Contact> = contactRepository.findAll()

    fun listaPorId(id: Long): ResponseEntity<Contact> =
        contactRepository.findById(id).map {
                ResponseEntity.ok(it)
            }
            .orElse(ResponseEntity.notFound().build())

    fun criaContato(contactDTO: ContactDTO): Contact =
       contactRepository.save(mapperDTOEntityContact.doDTOToEntity(contactDTO))

    fun atualiza(id: Long, contactDTO: ContactDTO): ResponseEntity<Contact> =
        contactRepository.findById(id).map {
            val contactAtualizado = it.copy(
                name = contactDTO.name,
                email = contactDTO.email,
                phone = contactDTO.phone
            )
            ResponseEntity.ok(contactRepository.save(contactAtualizado))
        }.orElse(ResponseEntity.notFound().build())


    fun deleta(id: Long): ResponseEntity<Void> = contactRepository
        .findById(id).map {
            contactRepository.delete(it)
            ResponseEntity<Void>(HttpStatus.OK)}
        .orElse(ResponseEntity.notFound().build())

}
