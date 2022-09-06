package com.ksga.forage.service
import org.springframework.core.io.Resource
import org.springframework.web.multipart.MultipartFile

interface FileService {

    fun loadAsResource(filename: String): Resource

    fun upload(files: List<MultipartFile>): List<String>
}