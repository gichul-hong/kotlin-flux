package com.sec.aip.sharedpool.controller

import com.sec.aip.sharedpool.model.Message
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController {

    @GetMapping("/api/message")
    fun getMessage(): Message {
        return Message("Hello, RestController!")
    }
}
