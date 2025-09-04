package com.vansh.firsthelloworld

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FirstHelloWorldApplication

fun main(args: Array<String>) {
    runApplication<FirstHelloWorldApplication>(*args)
}