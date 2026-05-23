package com.example.dsaproblems.contactapp

import java.util.Scanner

private val contacts = LinkedHashMap<Int, Contact>()

fun main() {
    var option = 0
    while (option != 6) {
        option = showOption()
        when (option) {
            1 -> {
                createContact()
            }

            2 -> {
                println("Update")
            }

            3 -> {
                searchContact()
            }

            4 -> {
                println("Delete")
            }

            5 -> {
                displayContact()
            }

            6 -> {
                println("Exit")
            }


        }
    }
}


fun showOption(): Int {
    while (true) {
        println(
            "1.Create \n" +
                    "2.Update \n" +
                    "3.Search \n" +
                    "4.Delete \n" +
                    "5.Display \n" +
                    "6.Exit \n" +
                    "Choose option \n"
        )
        val option = Scanner(System.`in`).nextInt()
        println()
        if (option in 1..6) {
            return option
        }
    }

}

fun createContact() {

    while (true) {
        println("Enter Name ")
        val name = Scanner(System.`in`).nextLine()
        val phoneList = createPhoneNumber("Phone Number")
        val emailList = createPhoneNumber("Email")
//        val email = Scanner(System.`in`).nextLine()
//        println("Enter Street ")
//        val street = Scanner(System.`in`).nextLine()
//        println("Enter City ")
//        val city = Scanner(System.`in`).nextLine()
//        println("Enter State ")
//        val state = Scanner(System.`in`).nextLine()
//        println("Enter Zip ")
        val id = contacts.size + 1
        contacts[id] =
            Contact(id, name = name, phone = phoneList, email = emailList)
        println("Do you want to add Another Contact? Y/N")
        val option = Scanner(System.`in`).nextLine()
        if (option.equals("Y", ignoreCase = true).not()) {
            return
        }
    }

}

fun createPhoneNumber(key: String): List<String> {
    val phoneNumbers = mutableListOf<String>()
    while (true) {
        println("Do you want to enter $key? Y/N")
        val option = Scanner(System.`in`).nextLine()
        if (option.equals("Y", ignoreCase = true)) {
            println("Please enter $key")
            val phone = Scanner(System.`in`).nextLine()
            println()
            phoneNumbers.add(phone)
        } else
            return phoneNumbers
    }
}

fun displayContact() {
    for (contact in contacts) {
        println(contact.toString())
    }
}

fun searchContact() {

    println("Enter Key to Search")
    val key = Scanner(System.`in`).nextLine()
    for (contact in contacts) {
        if (contact.value.name.contains(key, ignoreCase = true) ||
            contact.value.phone.toString().contains(key, ignoreCase = true) ||
            contact.value.email.toString().contains(key, ignoreCase = true)
        ) {
            println(contact.toString())
            return
        }
    }
    println("No Contact Found")

}