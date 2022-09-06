package com.ksga.forage.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.util.StringUtils
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.util.*

class StorageException(_message: String) : RuntimeException(_message)

@Service
class FileServiceImpl(
    @Value("\${files.storage.path}")
    private val storagePath: String
) : FileService {

    var rootLocation: Path = Paths.get(storagePath)

    fun save(file: MultipartFile): String {
        val filename = file.originalFilename?.let { StringUtils.cleanPath(it) }
        val extension = File(filename!!).extension
        try {
            if (file.isEmpty) {
                throw StorageException("Failed to store empty file $filename")
            }
            if (filename.contains("..")) {
                // This is a security check
                throw StorageException(
                    "Cannot store file with relative path outside current directory $filename"
                )
            }
        } catch (_: Exception) {
        }

        val newName = "${UUID.randomUUID()}.${extension}"
        val path = rootLocation.resolve(newName)
        Files.copy(file.inputStream, path, StandardCopyOption.REPLACE_EXISTING)

        return newName
    }

    override fun loadAsResource(filename: String): Resource {
        val file = rootLocation.resolve(filename)
        val resource = UrlResource(file.toUri())

        if (resource.exists() || resource.isReadable) {
            return resource
        } else {
            throw RuntimeException("FAIL!")
        }
    }

    override fun upload(files: List<MultipartFile>): List<String> {
        return files.map {
            save(it)
        }
    }
}