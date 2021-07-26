package com.api.sk.service

import com.api.sk.dto.ContactAdicionaPhoneForm
import com.api.sk.dto.ContactForm
import com.api.sk.dto.ContactView
import com.api.sk.entities.Contact
import com.api.sk.entities.Phone
import com.api.sk.repositories.ContactRepository
import com.api.sk.utils.mapper.MapperDTOEntityContact
import org.springframework.stereotype.Service
import java.util.*

@Service
class ContactService(private val contactRepository: ContactRepository,
                     private val mapperDTOEntityContact: MapperDTOEntityContact) {

    fun listarTodos(): List<Contact> = contactRepository.findAll()

    fun listaPorId(id: Long) = contactRepository.findById(id).map { it }

    fun criaContato(contactForm: ContactForm) =
        contactRepository.save(mapperDTOEntityContact.doDTOToEntity(contactForm))

    fun adicionaPhones(id: Long, phone: List<Phone>) =
        contactRepository.findById(id).map {
            val contactNovoPhone = it.copy(
                phone = phone)
            // val phoneNovo: List<Phone> = listOf(phone)
            contactRepository.save(contactNovoPhone)
        }

    fun atualiza(id: Long, contactForm: ContactForm): Optional<Contact> =
        contactRepository.findById(id).map {
            val contactAtualizado = it.copy(
                name = contactForm.name,
                email = contactForm.email,
                phone = contactForm.phone
            )
            contactRepository.save(contactAtualizado)
        }


    fun deleta(id: Long) = contactRepository
        .findById(id).map {
            contactRepository.delete(it)}

}
