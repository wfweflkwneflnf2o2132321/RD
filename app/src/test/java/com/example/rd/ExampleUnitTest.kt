package com.example.rd

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

//    val number = "+463724638423734"
//    val contact = FakeContact(
//        name = "ARTEM",
//        surname = "KUT",
//        phone = "463724638423734"
//    )
//    val contactRepository = FakeContactRepository()

    val contactRepository = FakeContactRepository()
    @Test
    fun testAddContact() {
        val number = "+463724638423734"
        val contact = FakeContact(
            name = "ARTEM",
            surname = "KUT",
            phone = "463724638423734"
        )


        contactRepository.addContact(contact)
        val list = contactRepository.getAllContacts()
        val lastContact = list.last()

        assertEquals(contact, lastContact)
        assertNotEquals(number, lastContact.phone)
    }
    @Test
    fun testDeleteContact() {
        val contactFirst = FakeContact(
            name = "TestName",
            surname = "TestSurname",
            phone = "463724638423734"
        )
        val contactSecond = FakeContact(
            name = "TestName2",
            surname = "TestSurname2",
            phone = "Second463724638423734"
        )

        contactRepository.addContact(contactFirst)
        contactRepository.addContact(contactSecond)
        contactRepository.deleteContact(contactSecond)
        val list = contactRepository.getAllContacts()
        val lastContact = list.last()

        assertEquals(contactFirst, lastContact)

    }

    @Test
    fun testSearchContact() {
        val contactFirst = FakeContact(
            name = "55555",
            surname = "55555555",
            phone = "555555555555"
        )
        val contactSecond = FakeContact(
            name = "666666666",
            surname = "666666666",
            phone = "66666666666666"
        )
        val contactThird = FakeContact(
            name = "77777",
            surname = "77777777",
            phone = "777777777777777"
        )

        contactRepository.addContact(contactFirst)
        contactRepository.addContact(contactSecond)
        contactRepository.addContact(contactThird)
        contactRepository.contactsShown("5")
        val list = contactRepository.contactsShown("5")
        assertEquals(1, list.size)
    }

}