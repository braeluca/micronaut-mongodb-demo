package de.braeluca

import io.micronaut.data.mongodb.annotation.MongoFindQuery
import io.micronaut.data.repository.CrudRepository

interface TestRepository : CrudRepository<TestDocument, String> {

    @MongoFindQuery(filter = "{'name': {'\$in': :names}}")
    fun findByNameInList(names: List<String>): List<TestDocument>
}