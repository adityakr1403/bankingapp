package com.aditya.bankingapp.accountservice.controller

import com.aditya.bankingapp.accountservice.dto.AccountDto
import com.aditya.bankingapp.accountservice.model.Account
import com.aditya.bankingapp.accountservice.service.AccountService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/account")
class AccountController(
    private val accountService: AccountService
) {

    @GetMapping("/details")
    fun getAccount(@RequestParam acc: Long): ResponseEntity<AccountDto> {
        val account = accountService.getAccountByAccountNumber(acc)
        return ResponseEntity.ok(account)
    }

    @PostMapping("/create")
    fun createAccount(@RequestBody account: Account): ResponseEntity<AccountDto> {
        val newAccount = accountService.createAccount(account)
        return ResponseEntity.ok(newAccount)
    }

}