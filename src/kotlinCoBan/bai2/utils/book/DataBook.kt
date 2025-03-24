package kotlinCoBan.bai2.utils.book

import kotlinCoBan.bai2.model.EBook
import kotlinCoBan.bai2.model.PhysicalBook

object DataBook {
    val listDataBook = mutableListOf(
        PhysicalBook("Bước chậm lại giữa thế gian vội vã", "Hae Min", 2023, "Tâm lý học", 220),
        PhysicalBook("Ngày xưa có một chuyện tình", "Nguyễn Nhật Ánh", 2022, "Lãng mạn", 300),
        PhysicalBook("Cuộc đời của Pi", "Yann Martel", 2021, "Phiêu lưu", 400),
        PhysicalBook("Tắt đèn", "Ngô Tất Tố", 1939, "Văn học Việt Nam", 200),
        PhysicalBook("Số đỏ", "Vũ Trọng Phụng", 1936, "Hài kịch", 250),
        PhysicalBook("Hạt giống tâm hồn", "Nhiều tác giả", 2002, "Phát triển bản thân", 300),
        PhysicalBook("Đắc nhân tâm", "Dale Carnegie", 1936, "Kỹ năng sống", 350),

        EBook("Doraemon", "Fujiko Fujio", 2020, "Comic", 29.4),
        EBook("Doraemon", "Fujiko Fujio", 2020, "Thiếu nhi", 20.7),
        EBook("Dế Mèn phiêu lưu ký", "Tô Hoài", 1941, "Thiếu nhi", 5.3),  // Dung lượng 5.3MB
        EBook("Những người khốn khổ", "Victor Hugo", 1862, "Văn học nước ngoài", 10.5),  // Dung lượng 10.5MB
        EBook("Nhật ký Đặng Thùy Trâm", "Đặng Thùy Trâm", 2005, "Hồi ký", 4.2), // Dung lượng 4.2MB
        EBook("Chuyện con mèo dạy hải âu bay", "Luis Sepúlveda", 2023, "Thiếu nhi", 7.5),
        EBook("Một thoáng ta rực rỡ ở nhân gian", "Ocean Vuong", 2022, "Văn học nước ngoài", 9.0),
        EBook("Hiểu về trái tim", "Minh Niệm", 2023, "Kỹ năng sống", 6.3)
    )

}

