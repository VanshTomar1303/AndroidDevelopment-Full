package com.vansh.httprequests

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class QuoteController {

    @GetMapping
    fun helloWorld() = "Hello, World!"
}