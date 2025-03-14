package kotlinCoBan.bai2

class User(
    val id: String,
    val name: String,
    val email: String

) {
    companion object {
        private var nextId = 1
        fun generateId() : String = "U-${nextId++}"
    }

    override fun toString(): String {
        return "[$id] - $name - $email"
    }


}