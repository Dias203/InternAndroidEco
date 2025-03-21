package kotlinCoBan.bai2.system.manager

import kotlinCoBan.bai2.model.User

open class UserManager : LibraryManager {
    private val users = mutableListOf<User>()

    override fun addUser(user: User) {
        users.add(user)
        println("Đã thêm người dùng thành công!")
    }

    override fun updateUser(userId: String, userNewName: String, userNewEmail: String) {
        val user = findUserById(userId) ?: return println("Không tìm thấy người dùng với ID: $userId")
        user.apply {
            name = userNewName
            email = userNewEmail
        }
        println("Đã cập nhật thông tin người dùng thành công!")
        println("Thông tin người dùng sau khi cập nhật: $user")
    }

    override fun deleteUser(userId: String): Boolean {
        val user = findUserById(userId) ?: return false.also { println("Không tìm thấy người dùng với ID: $userId") }
        users.remove(user)
        println("Đã xóa người dùng với ID: $userId thành công!")
        return true
    }

    override fun getAllUsers(): List<User> = users.toList()

    override fun displayUsers() {
        println("=== Danh sách người dùng (${users.size} người) ===")
        if (users.isEmpty()) {
            println("Hiện không có người dùng nào!")
            return
        }
        users.forEachIndexed { index, user ->
            println("${index + 1}. $user")
        }
    }

    override fun findUserById(userId: String): User? =
        users.find { it.id == userId }

    override fun findUserByName(userName: String): List<User> {
        val results = users.filter { it.name.contains(userName, ignoreCase = true) }
        displaySearchResults(userName, results)
        return results
    }

    private fun displaySearchResults(userName: String, results: List<User>) {
        if (results.isEmpty()) {
            println("Không tìm thấy người dùng nào với tên: $userName!")
        } else {
            println("=== Kết quả tìm kiếm cho '$userName' (${results.size} người) ===")
            results.forEachIndexed { index, user ->
                println("${index + 1}. $user")
            }
        }
    }
}