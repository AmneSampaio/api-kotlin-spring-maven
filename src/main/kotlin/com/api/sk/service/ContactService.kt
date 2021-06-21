package com.api.sk.service

import com.api.sk.dto.ContactForm
import com.api.sk.entities.Contact
import com.api.sk.repositories.ContactRepository
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class ContactService(private val contactRepository: ContactRepository) {
    fun listarTodos(): List<Contact> {
        return contactRepository.findAll()
    }

    fun listaPorId(id: Long): Contact {
        return contactRepository.findById(id).orElseThrow { EntityNotFoundException() }
    }

    fun criaContato(contact: Contact): Contact {
        return contactRepository.save(contact)
    }

    fun adicionaPhones(id: Long, newContact: ContactForm): Contact {
        val contactNoBanco = contactRepository.findById(id).orElseThrow { EntityNotFoundException() }
        //val contactSalvo = contactNoBanco.apply {newContact}
        //val contactAtualizado = contactNoBanco.apply { contactSalvo }
        return contactRepository.save(contactNoBanco)
    }

    fun atualiza(id: Long, newContact: ContactForm): Contact {
        val contactNoBanco = contactRepository.findById(id).orElseThrow { EntityNotFoundException() }
        val contactAtualizado = contactNoBanco.apply {
            this.name = newContact.name
            this.email = newContact.email
            this.phones = newContact.phones.toMutableList()
        }
        return contactRepository.save(contactAtualizado)
    }


    fun deleta(id: Long) {
        val contact = contactRepository.findById(id).orElseThrow { EntityNotFoundException() }
        return contactRepository.delete(contact)
    }
}

