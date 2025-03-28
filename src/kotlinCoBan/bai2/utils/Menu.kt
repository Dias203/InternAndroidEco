package kotlinCoBan.bai2.utils

object Menu {
    fun menu() {
        println("\n===== HỆ THỐNG QUẢN LÝ THƯ VIỆN =====")
        println("1. Quản lý sách")
        println("2. Quản lý người dùng")
        println("0. Thoát chương trình")
        print("Nhập lựa chọn của bạn: ")
    }
    fun bookMenu() {
        println("\n===== QUẢN LÝ SÁCH =====")
        println("1. Thêm sách mới")
        println("2. Cập nhật thông tin sách")
        println("3. Tìm kiếm sách theo tên")
        println("5. Hiển thị danh sách sách")
        println("6. Xóa sách")
        println("7. Mượn sách")
        println("8. Trả sách")
        println("9. Tổng số sách đang được mượn")
        println("10. Sắp xếp danh sách sách theo năm xuất bản")
        println("11. Lọc danh sách sách")
        println("0. Thoát chương trình")
        print("Nhập lựa chọn của bạn: ")
    }

    fun userMenu() {
        println("\n===== QUẢN LÝ NGƯỜI DÙNG =====")
        println("1. Thêm người dùng mới")
        println("2. Cập nhật thông tin người dùng")
        println("3. Tìm kiếm người dùng theo tên")
        println("4. Xóa người dùng")
        println("5. Hiển thị danh sách người dùng")
        println("6. Hiển thị sách đã mượn của người dùng")
        println("0. Thoát chương trình")
        print("Nhập lựa chọn của bạn: ")
    }

}