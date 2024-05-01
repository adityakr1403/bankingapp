package com.aditya.bankingapp.accountservice.service

import com.aditya.bankingapp.accountservice.dto.AccountDto
import com.aditya.bankingapp.accountservice.model.Account

interface AccountService {
    fun getAccountByAccountNumber(accountNumber: Long): AccountDto
    fun createAccount(account: Account): AccountDto
}