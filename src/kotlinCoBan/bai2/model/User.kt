package kotlinCoBan.bai2.model

class User(
    val id: String,
    var name: String,
    var email: String

) {

    override fun toString(): String {
        return "[$id] - $name - $email"
    }


}