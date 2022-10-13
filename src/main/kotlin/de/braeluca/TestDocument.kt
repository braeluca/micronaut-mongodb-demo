package de.braeluca

import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity

@MappedEntity("test")
data class TestDocument(
    @field:Id
    val id: String,
    val name: String
)
