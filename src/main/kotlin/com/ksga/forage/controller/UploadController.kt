package com.ksga.forage.controller

import com.ksga.forage.service.FileService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
class UploadController(
    val fileService: FileService
) {

    @GetMapping("/")
    fun homepage(): String {
        return "index"
    }

    @PostMapping("/upload")
    fun uploadFile(@RequestParam("file") file: MultipartFile, attributes: RedirectAttributes): String {
        val payload = fileService.upload(listOf(file))
        println(payload)
        return "redirect:/"
    }
}