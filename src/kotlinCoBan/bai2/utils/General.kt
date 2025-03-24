package kotlinCoBan.bai2.utils


// sealed class
sealed class GeneratorID {
    abstract fun generateId() : String
}

// Singleton
data object UserIdGenerator : GeneratorID() {
    private var nextId = 1
    override fun generateId(): String = "U-${nextId++}"
}

data object BookIdGenerator : GeneratorID() {
    private var nextId = 1
    override fun generateId(): String = "B-${nextId++}"
}

// Inline function & generic
inline fun <T> List<T>.displayAll(info: (T) -> String) {
    this.forEach {
        println(info(it))
    }
}

// Enum class
enum class TypeBook {
    EBOOK,
    PAPER_BOOK
}