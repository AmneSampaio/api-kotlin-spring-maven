package com.api.sk.controlers

import com.api.sk.dto.ContactDTO
import com.api.sk.entities.Contact
import com.api.sk.service.ContactService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/contacts")
class ContactController(private val contactService: ContactService) {

    @GetMapping
    fun listaTodos(): List<Contact> = contactService.listarTodos()

    @GetMapping("/{id}")
    fun listaPorId(@Valid @PathVariable id: Long): ResponseEntity<ResponseEntity<Contact>> =
        ResponseEntity.ok().body(contactService.listaPorId(id))

    @PostMapping
    fun criaContato(
        @Valid @RequestBody contactDTO: ContactDTO): ResponseEntity<Contact> {
        val contactSalvo = contactService.criaContato(contactDTO)
        return ResponseEntity.ok().body(contactSalvo)
    }

    @PutMapping("/{id}")
    fun atualiza(@Valid @PathVariable("id") id: Long, @RequestBody contactDTO: ContactDTO):
            ResponseEntity<ResponseEntity<Contact>> =
        ResponseEntity.ok(contactService.atualiza(id, contactDTO))


    @DeleteMapping("/{id}")
    fun deleta(@Valid @PathVariable("id") id: Long): ResponseEntity<ResponseEntity<Void>> =
        ResponseEntity.ok(contactService.deleta(id))
}