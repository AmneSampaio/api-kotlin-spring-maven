package com.api.sk.service

import com.api.sk.entities.Contact
import com.api.sk.repositories.ContactRepository
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class ContactService(private val contactRepository: ContactRepository) {
    fun listarTodos(): List<Contact> {
        return contactRepository.findAll()
    }

    fun listaPorId(): Contact {
        return contactRepository.findById(id).orElseThrow { EntityNotFoundException() }
    }

    fun criaContato(): Contact {
        return contactRepository.save(contact)
    }

    fun atualiza(): Contact {
        val contactNoBanco = contactRepository.findById(id).orElseThrow {EntityNotFoundException()}
        contactNoBanco.apply {
            this.name = newContact.name
            this.email = newContact.email
        }
        return contactRepository.save(contactNoBanco)
    }

    fun deleta() {
        val contact = contactRepository.findById(id).orElseThrow {EntityNotFoundException()}
        contactRepository.delete(contact)
    }
}