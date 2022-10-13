package de.braeluca

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@MicronautTest(transactional = false)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MicronautMongodbDemoTest {

    @Inject
    lateinit var testRepository: TestRepository

    val doc1 = TestDocument("1", "name1")
    val doc2 = TestDocument("2", "name2")

    @BeforeAll
    fun setup() {
        testRepository.saveAll(listOf(doc1, doc2))
    }

    @Test
    fun `in list with one parameter`() {
        val testDocuments = testRepository.findByNameInList(listOf("name1"))

        assertEquals(testDocuments.size, 1)
    }

    @Test
    fun `in list with two parameters`() {
        val testDocuments = testRepository.findByNameInList(listOf("name1", "name2"))

        assertEquals(testDocuments.size, 2)
    }

}
