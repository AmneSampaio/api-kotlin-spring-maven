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
    fun listaPorId(@Valid @PathVariable id: Long): ResponseEntity<Contact> {
        return ResponseEntity.ok().body(contactService.listaPorId(id))
    }

    @PostMapping
    fun criaContato(
        @Valid @RequestBody contactForm: ContactForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<Contact> {
        val contactSalvo = contactService.criaContato(contactForm)
        val uri = uriBuilder.path("/contacts/${contactSalvo.id}").build().toUri()
        return ResponseEntity.created(uri).body(contactSalvo)
    }

    @PutMapping("/{id}")
    fun atualiza(@Valid @PathVariable("id") id: Long, @RequestBody contactForm: ContactForm): ResponseEntity<Contact> {
        val contactAtualizado = contactService.atualiza(id, contactForm)
        return ResponseEntity.ok(contactAtualizado)
    }

    @DeleteMapping("/{id}")
    fun deleta(@Valid @PathVariable("id") id: Long) {
        return contactService.deleta(id)
    }


}