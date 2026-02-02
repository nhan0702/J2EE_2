# 📚 Hệ Thống Quản Lý Sách - Spring Boot với Thymeleaf

## Mô Tả Dự Án
Đây là một ứng dụng web quản lý sách được xây dựng bằng Spring Boot và Thymeleaf. Ứng dụng cho phép người dùng xem danh sách sách, thêm sách mới, chỉnh sửa thông tin sách, và xóa sách.

## Công Nghệ Sử Dụng
- **Backend**: Spring Boot 4.0.2
- **Java**: 17
- **Template Engine**: Thymeleaf
- **Build Tool**: Maven
- **CSS**: HTML5 + CSS3 (Responsive Design)

## Cấu Trúc Dự Án

```
demo/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── DemoApplication.java
│   │   │   ├── Controller/
│   │   │   │   └── BookController.java
│   │   │   ├── model/
│   │   │   │   └── Book.java
│   │   │   └── service/
│   │   │       └── BookService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── templates/
│   │           ├── index.html
│   │           ├── books.html
│   │           ├── add-book.html
│   │           └── edit-book.html
│   └── test/
│       └── java/com/example/demo/
│           └── DemoApplicationTests.java
├── pom.xml
└── README.md
```

## Các Tính Năng Chính

### 1. **Trang Chủ** (`/`)
- Giao diện chào mừng với thiết kế hiện đại
- Nút nhanh để truy cập danh sách sách hoặc thêm sách mới
- Hiển thị các tính năng chính của ứng dụng

### 2. **Danh Sách Sách** (`/books`)
- Hiển thị tất cả các sách trong hệ thống
- Bảng chi tiết với ID, tiêu đề, tác giả
- Nút **Sửa** để chỉnh sửa thông tin sách
- Nút **Xóa** để xóa sách với xác nhận

### 3. **Thêm Sách** (`/books/add`)
- Form nhập liệu để thêm sách mới
- Các trường bắt buộc: Tiêu Đề, Tác Giả
- Xác thực dữ liệu phía client
- Tự động gán ID cho sách mới

### 4. **Sửa Sách** (`/books/edit/{id}`)
- Hiển thị form sửa với dữ liệu sách hiện tại
- Cập nhật thông tin tiêu đề và tác giả
- Nút Cập Nhật và Hủy

## Model Dữ Liệu

### Book.java
```java
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    private int id;
    private String title;
    private String author;
}
```

## Các Endpoint Chính

| Method | URL | Mô Tả |
|--------|-----|-------|
| GET | `/` | Trang chủ |
| GET | `/books` | Danh sách sách |
| GET | `/books/add` | Form thêm sách |
| POST | `/books/save` | Lưu sách mới |
| GET | `/books/edit/{id}` | Form sửa sách |
| POST | `/books/update/{id}` | Cập nhật sách |
| GET | `/books/delete/{id}` | Xóa sách |

## Cách Sử Dụng

### 1. Chạy Ứng Dụng
```bash
cd demo
mvn spring-boot:run
```

Ứng dụng sẽ chạy tại `http://localhost:8080`

### 2. Build Project
```bash
mvn clean package
```

### 3. Chạy Tests
```bash
mvn test
```

## Thymeleaf Templates

### index.html
Trang chủ với giao diện gradient đẹp mắt, hiển thị các tính năng chính.

### books.html
Danh sách sách dưới dạng bảng, cho phép sửa và xóa.

### add-book.html
Form thêm sách mới với validation cơ bản.

### edit-book.html
Form sửa thông tin sách, hiển thị dữ liệu hiện tại.

## Đặc Điểm Thiết Kế

✅ **Responsive Design**: Hoạt động tốt trên desktop và mobile
✅ **Gradient Header**: Thiết kế hiện đại với màu sắc gradient
✅ **Styled Forms**: Form nhập liệu với hover effects
✅ **Confirmation Dialog**: Xác nhận trước khi xóa sách
✅ **Clean Navigation**: Menu điều hướng rõ ràng
✅ **Consistent Styling**: Phong cách một quán khắp ứng dụng

## Dữ Liệu Khởi Tạo

Ứng dụng khởi tạo với 3 cuốn sách mẫu:
1. **1984** - George Orwell
2. **To Kill a Mockingbird** - Harper Lee
3. **The Great Gatsby** - F. Scott Fitzgerald

## Requirements
- Java 17+
- Maven 3.6+
- Spring Boot 4.0.2

## Lưu Ý
- Dữ liệu sách được lưu trong bộ nhớ (in-memory list), không persist vào database
- Nếu muốn persist dữ liệu, hãy thêm Spring Data JPA và database (MySQL, PostgreSQL, etc.)

## Tác Giả
Demo Project - Spring Boot with Thymeleaf

## License
MIT License
