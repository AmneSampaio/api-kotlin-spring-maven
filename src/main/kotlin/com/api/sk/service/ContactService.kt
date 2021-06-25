package com.api.sk.service

import com.api.sk.dto.ContactForm
import com.api.sk.entities.Contact
import com.api.sk.repositories.ContactRepository
import com.api.sk.utils.mapper.ConversorDeClassesMapper
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class ContactService(
    private val contactRepository: ContactRepository,
    private val conversorDeClassesMapper: ConversorDeClassesMapper
) {

    fun listarTodos(): List<Contact> {
        return contactRepository.findAll()

    }

    fun listaPorId(id: Long): Contact {
        return contactRepository.findById(id).orElseThrow { EntityNotFoundException() }
    }

    fun criaContato(contactForm: ContactForm): Contact {
        val salvaContact = conversorDeClassesMapper.doDTOToEntity(contactForm)
        return contactRepository.save(salvaContact)
    }

    fun atualiza(id: Long, contactForm: ContactForm): Contact {
        val contactNoBanco = contactRepository.findById(id).orElseThrow { EntityNotFoundException() }
        val contactAtualizado = contactNoBanco.apply {
            this.name = contactNoBanco.name
            this.email = contactNoBanco.email
            this.phone = contactNoBanco.phone
        }
        return contactRepository.save(contactAtualizado)
    }

    fun deleta(id: Long) {
        val contactNoBanco = contactRepository.findById(id).orElseThrow { EntityNotFoundException() }
        return contactRepository.delete(contactNoBanco)
    }
}