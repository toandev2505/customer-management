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
![Customer List Management](image_42b018.png)
*(Hình ảnh minh họa giao diện danh sách khách hàng)*

### 2. Thêm mới khách hàng
Giao diện "New Customer Insertion" giúp tối ưu hóa việc nhập liệu.
![Insert Customer Form](Screenshot%202026-02-24%20124005.png)
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
