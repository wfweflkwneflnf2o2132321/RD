package com.example.rd

interface ContactRepository {

    fun addContact(name: String, surname: String, number: String)
    fun editContact(name: String, surname: String, number: String,contact: Contact)
    fun deleteContact(contact: Contact)
    fun getContact(): List<Contact>


}