package kotlinCoBan.bai2

import kotlinCoBan.bai2.system.handler.BookHandler
import kotlinCoBan.bai2.system.handler.UserHandler
import kotlinCoBan.bai2.system.manager.BookManager
import kotlinCoBan.bai2.system.manager.BorrowManager
import kotlinCoBan.bai2.system.manager.UserManager
import kotlinCoBan.bai2.utils.Menu

fun main() {
    // Khởi tạo các đối tượng manager
    val bookManager = BookManager()
    val userManager = UserManager()
    val borrowManager = BorrowManager().apply {
        setManagers(bookManager, userManager)
    }

    // Khởi tạo các handler và thiết lập tham chiếu đến các manager
    val bookHandler = BookHandler().apply {
        setBookAndBorrow(bookManager, borrowManager)
    }
    val userHandler = UserHandler().apply {
        setUserManager(userManager)
    }

    // Vòng lặp chính của chương trình
    var running = true
    while (running) {
        Menu.menu()
        val choice = readlnOrNull()?.toIntOrNull()

        when (choice) {
            1 -> bookHandler.handleBooksMenu()
            2 -> userHandler.handleUsersMenu()
            0 -> {
                println("Đang thoát chương trình...")
                running = false
            }
            else -> println("Lựa chọn không hợp lệ!")
        }
    }

    println("Cảm ơn bạn đã sử dụng hệ thống quản lý thư viện!")
}