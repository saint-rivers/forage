package com.ksga.forage.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "stored_files")
open class StoredFiles(
    filename: String,
    createdDate: LocalDateTime = LocalDateTime.now(),
    isHidden: Boolean = false,
    createdBy: String? = null
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "filename", nullable = false, unique = true)
    open var filename: String? = filename

    @Column(name = "created_date", nullable = false)
    open var createdDate: LocalDateTime? = createdDate
        protected set

    @Column(name = "is_hidden", nullable = false)
    open var isHidden: Boolean? = isHidden

    @Column(name = "created_by")
    open var createdBy: String? = createdBy
}