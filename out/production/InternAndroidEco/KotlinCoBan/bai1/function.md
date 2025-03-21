### Các phương thức làm việc với collection
#### 1. Chuyển đổi Collection
    - toList() - chuyển thành danh sách không thay đổi
    - toSet() - chuyển thành tập hợp không thay đổi
    - toMap() - chuyển thành map không thay đổi
    - toMutableList() - chuyển thành danh sách có thể thay đổi
    - toMutableSet() - chuyển thành tập hợp có thể thay đổi
    - toMutableMap() - chuyển thành map có thể thay đổi
    - asSequence() / asIterable() - chuyển thành sequence/iterable cho xử lý lười biếng

#### 2. Lọc và Chọn
    - filterNot() - loại bỏ các phần tử thỏa mãn điều kiện
    - filterNotNull() - loại bỏ các phần tử null
    - filterIsInstance<T>() - chỉ giữ lại các phần tử thuộc kiểu T
    - take() / takeLast() - lấy n phần tử đầu/cuối
    - takeWhile() / takeLastWhile() - lấy phần tử cho đến khi điều kiện sai
    - drop() / dropLast() - bỏ n phần tử đầu/cuối
    - dropWhile() / dropLastWhile() - bỏ phần tử cho đến khi điều kiện sai
    - chunked() - chia thành các nhóm có kích thước xác định
    - windowed() - tạo các cửa sổ trượt với kích thước xác định
    - distinct() / distinctBy() - loại bỏ phần tử trùng lặp

#### 3. Biến đổi
    - flatMap() / flatMapTo() - biến đổi và làm phẳng kết quả
    - flatten() - làm phẳng collection lồng nhau
    - mapIndexed() / mapIndexedNotNull() - biến đổi với chỉ số
    - mapNotNull() - biến đổi và loại bỏ các kết quả null
    - zip() / zipWithNext() - kết hợp hai collection/các phần tử liền kề
    - associate() / associateWith() / associateBy() - tạo map từ collection
    - groupBy() / groupingBy() - nhóm phần tử theo điều kiện

#### 4. Tính toán
    - sumOf() / maxOf() / minOf() - tính tổng/giá trị lớn nhất/nhỏ nhất
    - sumBy() / maxBy() / minBy() - tính tổng/giá trị lớn nhất/nhỏ nhất theo điều kiện
    - count() / countBy() - đếm số phần tử
    - average() / averageBy() - tính trung bình
    - fold() / foldRight() / foldIndexed() - gộp các phần tử với giá trị khởi tạo
    - runningFold() / runningReduce() - tính giá trị gộp tích lũy

#### 5. Kiểm tra
    - any() / all() / none() - kiểm tra ít nhất một/tất cả/không có phần tử thỏa điều kiện
    - contains() / containsAll() - kiểm tra có chứa phần tử/tất cả phần tử
    - isEmpty() / isNotEmpty() - kiểm tra rỗng/không rỗng

#### 6. Truy xuất
    - elementAt() / elementAtOrNull() / elementAtOrElse() - lấy phần tử tại vị trí
    - random() / randomOrNull() - lấy phần tử ngẫu nhiên
    - first() / firstOrNull() - lấy phần tử đầu tiên
    - last() / lastOrNull() - lấy phần tử cuối cùng
    - single() / singleOrNull() - lấy phần tử duy nhất
    - getOrElse() / getOrNull() - lấy phần tử hoặc giá trị mặc định

#### 7. Thao tác với tập hợp
    - union() / intersect() / subtract() - hợp/giao/hiệu của tập hợp
    - plus() / minus() / plusElement() / minusElement() - thêm/bớt phần tử
    - partition() - chia thành hai danh sách theo điều kiện

#### 8. Các phương thức mutable
    - add() / addAll() - thêm phần tử/nhiều phần tử
    - remove() / removeAll() / removeIf() - xóa phần tử/nhiều phần tử/theo điều kiện
    - retainAll() - giữ lại các phần tử chỉ định
    - clear() - xóa tất cả phần tử
    - set() / put() / putAll() - đặt/thêm giá trị vào map
    
