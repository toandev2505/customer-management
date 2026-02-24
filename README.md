# 🚀 Customer Management System (CRM)

Hệ thống quản lý khách hàng (Customer Management Page) là một giải pháp CRM cơ bản giúp doanh nghiệp quản lý thông tin khách hàng một cách hiệu quả và trực quan.

---

## 🌟 Tính năng chính

* **Quản lý danh sách:** Hiển thị danh sách khách hàng với các trường dữ liệu như Tên, Số điện thoại và Trạng thái.
* **Tìm kiếm & Phân trang:** Hỗ trợ tìm kiếm nhanh và phân chia dữ liệu theo số lượng bản ghi hiển thị (Show entries).
* **Thêm mới (Insert):** Giao diện chuyên biệt để nhập liệu khách hàng mới vào hệ thống.
* **Thao tác nhanh:** Hỗ trợ các nút chức năng Chỉnh sửa (Edit) và Xóa (Delete) trực tiếp trên bảng.

---

## 📸 Giao diện ứng dụng

### 1. Danh sách khách hàng
Trang quản trị chính cho phép theo dõi toàn bộ database khách hàng.
![Customer List Management](https://github.com/user-attachments/assets/aa3c53e2-7193-4f22-a325-0485983269c8)

*(Hình ảnh minh họa giao diện danh sách khách hàng)*

### 2. Thêm mới khách hàng
Giao diện "New Customer Insertion" giúp tối ưu hóa việc nhập liệu.
![Insert Customer Form](https://github.com/user-attachments/assets/5f145497-853c-45cb-8f9c-53db1e2d373c)

*(Hình ảnh minh họa form thêm mới khách hàng)*

---

## 🛠 Công nghệ sử dụng

Dựa trên cấu trúc hệ thống, dự án được xây dựng với:
* **Backend:** Java Spring Boot (chạy trên port `8081`).
* **Frontend:** Bootstrap, FontAwesome (biểu tượng Edit/Search), và SB Admin template.
* **Database:** Hỗ trợ lưu trữ thông tin tên và số điện thoại khách hàng.

---

## 💾 Dữ liệu mẫu (Postman)

Để kiểm thử API, bạn có thể sử dụng định dạng JSON sau:

```json
{
    "name": "Nguyễn Văn A",
    "phone": "0123456789",
    "status": "1"
}
---

## 🚀 Hướng dẫn cài đặt và sử dụng

### 1. Yêu cầu hệ thống
* **Java:** Phiên bản 11 hoặc cao hơn.
* **Build Tool:** Maven hoặc Gradle.
* **Database:** MySQL hoặc PostgreSQL (tùy cấu hình).

### 2. Các bước khởi chạy
1. **Clone dự án:**
   ```bash
   git clone [https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git](https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git)
Gemini đã nói
Đây là đoạn mã Markdown tiếp nối từ phần Hướng dẫn cài đặt cho đến hết file, giúp hoàn thiện trang GitHub của bạn:

Markdown
---

## 🚀 Hướng dẫn cài đặt và sử dụng

### 1. Yêu cầu hệ thống
* **Java:** Phiên bản 11 hoặc cao hơn.
* **Build Tool:** Maven hoặc Gradle.
* **Database:** MySQL hoặc PostgreSQL (tùy cấu hình).

### 2. Các bước khởi chạy
1. **Clone dự án:**
   ```bash
   git clone [https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git](https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git)
Cấu hình Database:
Chỉnh sửa thông tin kết nối trong file src/main/resources/application.yaml.

Build & Run:

Bash
./mvnw spring-boot:run
Truy cập:
Mở trình duyệt tại địa chỉ: http://localhost:8081/admin/customer-management
