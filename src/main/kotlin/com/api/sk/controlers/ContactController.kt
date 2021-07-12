package com.api.sk.controlers

import com.api.sk.dto.ContactDTO
import com.api.sk.entities.Contact
import com.api.sk.service.ContactService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/contacts")
class ContactController(private val contactService: ContactService) {

    @GetMapping
    fun listaTodos(): List<Contact> = contactService.listarTodos()

    @GetMapping("/{id}")
    fun listaPorId(@Valid @PathVariable id: Long): ResponseEntity<Optional<Contact>> =
        ResponseEntity.ok().body(contactService.listaPorId(id))

    @PostMapping
    fun criaContato(
        @Valid @RequestBody contactDTO: ContactDTO): ResponseEntity<Contact> {
        val contactSalvo = contactService.criaContato(contactDTO)
        return ResponseEntity.ok().body(contactSalvo)
    }

    @PutMapping("/{id}")
    fun atualiza(@Valid @PathVariable("id") id: Long, @RequestBody contactDTO: ContactDTO):
            ResponseEntity<Optional<Contact>> =
        ResponseEntity.ok(contactService.atualiza(id, contactDTO))


    @DeleteMapping("/{id}")
    fun deleta(@Valid @PathVariable("id") id: Long): ResponseEntity<Optional<Unit>> =
        ResponseEntity(contactService.deleta(id), HttpStatus.OK)
}