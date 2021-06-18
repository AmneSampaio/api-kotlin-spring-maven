package com.api.sk.controlers

import com.api.sk.entities.Contact
import com.api.sk.repositories.ContactRepository
import com.api.sk.service.ContactService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityNotFoundException
import javax.validation.Valid

@RestController
@RequestMapping("/contacts")
class ContactController(private val contactService: ContactService) {

     @GetMapping
     fun listaTodos(): List<Contact> {
         return contactService.listarTodos()
     }

    @GetMapping("/{id}")
    fun listaPorId(@Valid @PathVariable("id") id: Long): Contact {
        return contactService.listaPorId()
    }

    @PostMapping
    fun criaContato(@Valid @RequestBody contact: Contact): Contact {
       return contactService.criaContato()
    }

    @PutMapping("/{id}")
    fun atualiza(@Valid @PathVariable("id") id: Long, @RequestBody newContact: Contact): Contact {
        return contactService.atualiza()
    }

    @DeleteMapping("/{id}")
    fun deleta(@Valid @PathVariable("id") id: Long) {
        return contactService.deleta()
    }


}