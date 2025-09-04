package com.vansh.httprequests

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import javax.management.Query

@RestController
@RequestMapping(path = ["/quotes"])
class QuoteController {
    val quotes = mutableListOf<QuoteDto>()

    @GetMapping
    fun getAllQuotes(
        @RequestParam("q", required = false) query: String?
    ): List<QuoteDto>{
        return if (query != null){
            quotes.filter {
                it.content.contains(query, ignoreCase = true)
                }
            } else {
                quotes
            }
    }

    @PostMapping
    fun addQuote(@RequestBody quoteDto: QuoteDto): QuoteDto{
        quotes.add(quoteDto)
        return quoteDto
    }

    @PutMapping
    fun updateQuote(
        @RequestBody quoteDto: QuoteDto
    ): QuoteDto{
        val index = quotes.indexOfFirst { it.id == quoteDto.id }
        quotes[index] = quoteDto

        return quoteDto
    }

    @DeleteMapping(path = ["/{id}"])
    fun deleteQuote(@PathVariable id: Long){
        val quoteToDelete = quotes.find { it.id == id }
        if (quoteToDelete != null) quotes.remove(quoteToDelete)
        else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

}