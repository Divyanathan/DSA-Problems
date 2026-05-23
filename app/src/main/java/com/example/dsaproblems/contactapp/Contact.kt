package com.example.dsaproblems.contactapp

data class Contact(
    val id: Int,
    val name: String,
    val company: String? = null,
    val phone: List<String>? = null,
    val email: List<String>? = null,
    val address: List<Address>? = null
)

data class Address(
    val street: String,
    val city: String,
    val state: String,
    val zip: String,
)
