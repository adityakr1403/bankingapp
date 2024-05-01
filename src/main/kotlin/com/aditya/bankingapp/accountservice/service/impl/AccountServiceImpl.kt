package com.aditya.bankingapp.accountservice.service.impl

import com.aditya.bankingapp.accountservice.accountExceptions.AccountNotFoundException
import com.aditya.bankingapp.accountservice.dto.AccountDto
import com.aditya.bankingapp.accountservice.model.Account
import com.aditya.bankingapp.accountservice.repository.AccountRepository
import com.aditya.bankingapp.accountservice.service.AccountService
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl(
    private val accountRepository: AccountRepository
) : AccountService {

    override fun getAccountByAccountNumber(accountNumber: Long): AccountDto {
        val account = accountRepository.findAccountByAccountNumber(accountNumber)
            ?: throw AccountNotFoundException("Account not found")
        return getAccountDtoFromAccount(account)
    }

    override fun createAccount(account: Account): AccountDto {
        val username = account.username
        val existingAccount = accountRepository.findAccountByUsername(username)

        accountRepository.save(account)

        val newAccountDetails = getAccountDtoFromAccount(account)
        return newAccountDetails
    }


    private fun getAccountDtoFromAccount(account: Account): AccountDto {
        return AccountDto(
            accountNumber = account.accountNumber,
            accountHolderName = account.accountHolderName,
            phoneNumber = account.phoneNumber,
            accountType = account.accountType,
            balance = account.balance,
            username = account.username,
            accountExpired = !account.isAccountNonExpired,
            accountLocked = !account.isAccountNonLocked,
            credentialsExpiryDate = account.credentialsExpiryDate,
            enabled = account.isEnabled,
            role = account.authorities.first().authority
        )
    }
}