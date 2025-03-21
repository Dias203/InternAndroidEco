package kotlinCoBan.bai2.utils

object UserIdGenerator {
    private var nextId = 1
    fun generateId(): String = "U-${nextId++}"
}

object BookIdGenerator {
    private var nextId = 1
    fun generateId(): String = "B-${nextId++}"
}