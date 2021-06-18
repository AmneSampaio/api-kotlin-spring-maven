package com.api.sk.controlers

import com.api.sk.dto.ContactForm
import com.api.sk.entities.Contact
import com.api.sk.service.ContactService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
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
    fun criaContato(@Valid @RequestBody contact: Contact,
                    uriBuilder: UriComponentsBuilder): ResponseEntity<Contact> {
       val contactSalvo = contactService.criaContato(contact)
       val uri = uriBuilder.path("/contacts/${contactSalvo.id}").build().toUri()
       return ResponseEntity.created(uri).body(contactSalvo)
    }

    @PutMapping("/{id}")
    fun atualiza(@Valid @PathVariable("id") id: Long, @RequestBody newContact: ContactForm): ResponseEntity<Contact> {
        val contactAtualizado = contactService.atualiza(id,newContact)
        return ResponseEntity.ok(contactAtualizado)
    }

    @DeleteMapping("/{id}")
    fun deleta(@Valid @PathVariable("id") id: Long) {
        return contactService.deleta(id)
    }


}