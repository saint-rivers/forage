package com.ksga.forage.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.servers.Server

@OpenAPIDefinition(
    servers = [Server(url = "/", description = "File Storage API")], info = Info(
        title = "File Storage API",
        description = "Spring Boot API made with Spring Data JPA, Kotlin and PostgreSQL. All endpoints are open and no security has been applied.",
        version = "1.0"
    )
)
class OpenApiConfig
