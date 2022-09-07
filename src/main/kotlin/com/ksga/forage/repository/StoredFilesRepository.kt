package com.ksga.forage.repository

import com.ksga.forage.model.StoredFiles
import org.springframework.data.jpa.repository.JpaRepository

interface StoredFilesRepository : JpaRepository<StoredFiles, Long> {
}