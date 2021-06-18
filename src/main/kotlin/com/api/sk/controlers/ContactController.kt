package com.api.sk.controlers

import com.api.sk.entities.Contact
import com.api.sk.service.ContactService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/contacts")
class ContactController(private val contactService: ContactService) {

     @GetMapping
     fun listaTodos(): List<Contact> {
         return contactService.listarTodos()
     }

    @GetMapping("/{id}")
    fun listaPorId(@Valid @PathVariable id: Long): Contact {
        return contactService.listaPorId(id)
    }

    @PostMapping
    fun criaContato(@Valid @RequestBody contact: Contact): Contact {
       return contactService.criaContato(contact)
    }

    @PutMapping("/{id}")
    fun atualiza(@Valid @PathVariable("id") id: Long, @RequestBody newContact: Contact): Contact {
        return contactService.atualiza(id,newContact)
    }

    @DeleteMapping("/{id}")
    fun deleta(@Valid @PathVariable("id") id: Long) {
        return contactService.deleta(id)
    }


}