package com.aditya.bankingapp.accountservice.dto

import java.util.*

class AccountDto(
    val accountNumber: Long,
    val accountHolderName: String,
    val phoneNumber: String,
    val accountType: String,
    val balance: Double,
    val username: String,
    val accountExpired: Boolean,
    val accountLocked: Boolean,
    val credentialsExpiryDate: Date,
    val enabled: Boolean,
    val role: String
) {
}