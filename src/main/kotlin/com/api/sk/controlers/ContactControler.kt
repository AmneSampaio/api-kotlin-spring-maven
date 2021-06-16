package com.api.sk.controlers

import com.api.sk.entities.Contact
import com.api.sk.repositories.ContactRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("contacts")
class ContactControler {

     @Autowired
     lateinit var repository: ContactRepository

     @GetMapping
     fun lista() {
         repository.findAll()
     }

    @PostMapping
    fun criaContato(@RequestBody contact: Contact) {
        repository.save(contact)
    }

}