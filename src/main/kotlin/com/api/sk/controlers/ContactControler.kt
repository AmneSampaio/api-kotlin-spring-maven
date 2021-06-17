package com.api.sk.controlers

import com.api.sk.entities.Contact
import com.api.sk.repositories.ContactRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityNotFoundException
import javax.validation.Valid

@RestController
@RequestMapping("/contacts")
class ContactController {

     @Autowired
     lateinit var repository: ContactRepository

     @GetMapping
     fun lista(): List<Contact> {
         return repository.findAll()
     }

    @GetMapping("/{id}")
    fun listaPorId(@Valid @PathVariable("id") id: Long): Contact {
        return repository.findById(id).orElseThrow {EntityNotFoundException()}
    }

    @PostMapping
    fun criaContato(@Valid @RequestBody contact: Contact): Contact {
       return repository.save(contact)
    }

    @PutMapping("/{id}")
    fun atualiza(@Valid @PathVariable("id") id: Long, @RequestBody newContact: Contact): Contact {
        val contactNoBanco = repository.findById(id).orElseThrow {EntityNotFoundException()}
        contactNoBanco.apply {
            this.name = newContact.name
            this.email = newContact.email
        }
    return repository.save(contactNoBanco)
    }

    @DeleteMapping("/{id}")
    fun deleta(@Valid @PathVariable("id") id: Long) {
        val contact = repository.findById(id).orElseThrow {EntityNotFoundException()}
        repository.delete(contact)
    }


}