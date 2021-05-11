package com.example.projet_tutore_back

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer


fun main(args: Array<String>) {
    SpringApplication.run(ProjetTutoreApplication::class.java, *args)
}

@SpringBootApplication
class ProjetTutoreApplication : SpringBootServletInitializer() {
    override fun configure(builder: SpringApplicationBuilder): SpringApplicationBuilder {
        return builder.apply {
            builder.sources(ProjetTutoreApplication::class.java)
        }
    }
}

