package com.aditya.bankingapp.accountservice.repository

import com.aditya.bankingapp.accountservice.model.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, Long> {

    fun findAccountByUsername(userName: String): Account?
    fun findAccountByAccountNumber(accountNumber: Long): Account?

}