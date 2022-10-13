package de.braeluca

import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import java.time.LocalDateTime

@MicronautTest(transactional = false)
class MicronautMongodbDemoTest {

    @Inject
    lateinit var testRepository: TestRepository

    @Test
    fun `in list with one parameter`() {
        val testDocuments = testRepository.findByNameInList(listOf("1"))
    }

    @Test
    fun `in list with two parameters`() {
        val testDocuments = testRepository.findByNameInList(listOf("1", "2"))
    }

}
