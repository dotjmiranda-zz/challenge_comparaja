package com.dotmiranda.booklist.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ApplicationController {
    @GetMapping("/")
    String Home() {
        return "Home"
    }
}
