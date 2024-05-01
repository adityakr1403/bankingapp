package com.aditya.bankingapp.accountservice.accountExceptions

class UsernameAlreadyExistsException(message: String? = "username already exists", cause: Throwable? = null) :
    Exception(message, cause)

class AccountNotFoundException(message: String? = "account not found", cause: Throwable? = null) :
    Exception(message, cause)

class InsufficientBalanceException(message: String? = "insufficient balance", cause: Throwable? = null) :
    Exception(message, cause)

class InvalidAccountTypeException(message: String? = "invalid account type", cause: Throwable? = null) :
    Exception(message, cause)

class InvalidAccountNumberException(message: String? = "invalid account number", cause: Throwable? = null) :
    Exception(message, cause)

class InvalidPhoneNumberException(message: String? = "invalid phone number", cause: Throwable? = null) :
    Exception(message, cause)

class InvalidUsernameOrPasswordException(message: String? = "invalid username or password", cause: Throwable? = null) :
    Exception(message, cause)

class InvalidRoleException(message: String? = "invalid role", cause: Throwable? = null) :
    Exception(message, cause)

class CredentialsExpiredException(message: String? = "credentials expired", cause: Throwable? = null) :
    Exception(message, cause)

class AccountLockedException(message: String? = "account locked", cause: Throwable? = null) :
    Exception(message, cause)

class AccountExpiredException(message: String? = "account expired", cause: Throwable? = null) :
    Exception(message, cause)

class AccountDisabledException(message: String? = "account disabled", cause: Throwable? = null) :
    Exception(message, cause)


