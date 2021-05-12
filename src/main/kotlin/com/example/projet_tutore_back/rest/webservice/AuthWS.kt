package com.example.projet_tutore_back.rest.webservice

import com.example.projet_tutore_back.data.dto.LoginReqDto
import com.example.projet_tutore_back.data.dto.LoginRespDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthWS {

    @PostMapping("/login")
    fun login(@RequestBody loginReq: LoginReqDto): LoginRespDto {
        return LoginRespDto("Thomas", "48")
    }
}
