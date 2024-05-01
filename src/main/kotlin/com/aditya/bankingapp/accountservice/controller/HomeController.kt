package com.aditya.bankingapp.accountservice.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/home")
class HomeController {

    @RequestMapping("/")
    fun home(): String {
        return "Welcome to the Banking App"
    }
}