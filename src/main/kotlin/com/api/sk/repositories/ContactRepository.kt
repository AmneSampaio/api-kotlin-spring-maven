package com.api.sk.repositories

import com.api.sk.entities.Contact
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContactRepository: JpaRepository<Contact, Long> {
}