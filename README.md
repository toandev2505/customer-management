# 🚀 Real Estate CRM - Customer & Product Management System

Hệ thống quản lý khách hàng và kho hàng bất động sản toàn diện, giúp tối ưu hóa quy trình từ tìm kiếm, khớp nhu cầu (Matching) đến quản lý dữ liệu lịch sử.

---

## 🌟 Tính năng nổi bật

### 1. Quản lý Kho hàng (Product Management)
* **Danh sách sản phẩm:** Hiển thị trực quan các thông tin tiêu đề, loại hình (APARTMENT, LAND, VILLA), diện tích và hướng nhà.
* **Chi tiết sản phẩm:** Xem hình ảnh thực tế, thông số kỹ thuật (số phòng ngủ), địa chỉ chính xác đến từng Phường/Xã và trạng thái thực tế (**TRỐNG**, **ĐÃ CỌC**).
* **Bộ lọc thông minh:** Tìm kiếm nhanh theo vị trí, khoảng giá (tính theo Tỷ VNĐ) và loại hình bất động sản.

### 2. Quản lý Khách hàng & Nhu cầu (Smart Matching)
* **Hồ sơ khách hàng:** Lưu trữ thông tin liên hệ và tình trạng hoạt động của từng khách.
* **Tự động lưu nhu cầu:** Khi môi giới hoặc khách hàng thực hiện **Tìm kiếm & Lọc** sản phẩm, hệ thống sẽ tự động trích xuất các tiêu chí lọc để lưu vào "Lịch sử nhu cầu tìm kiếm".
* **Theo dõi nhu cầu:** Hiển thị danh sách các yêu cầu tìm kiếm cũ (Loại BĐS, Khoảng giá, Khu vực) ngay trong trang chi tiết khách hàng để dễ dàng tư vấn lại.

### 3. Thùng rác & Lịch sử (History Customer - Soft Delete)
* **Xóa an toàn:** Khi xóa khách hàng, dữ liệu không mất đi mà được chuyển vào mục **History Customer**.
* **Khôi phục dữ liệu (Recover):** Hỗ trợ xem lại danh sách khách hàng cũ và khôi phục (Active) lại trạng thái hoạt động chỉ với một click, đảm bảo không thất thoát dữ liệu khách hàng tiềm năng.

---

## 📸 Giao diện ứng dụng

### 1. Quản lý kho hàng & Chi tiết sản phẩm
Giao diện hiển thị chi tiết thông số kỹ thuật và hình ảnh thực tế của bất động sản.
![Product List](https://github.com/user-attachments/assets/d2bd27e7-ed8d-44b3-a835-066b397bb2de)

![Product Detail](https://github.com/user-attachments/assets/d3014dce-2b14-444f-a314-cf93fccb27d5)

### 2. Bộ lọc sản phẩm & Tự động lưu nhu cầu
Hệ thống ghi nhận hành vi tìm kiếm của người dùng để cập nhật nhu cầu khách hàng.
![Search & Filter](https://github.com/user-attachments/assets/a81a3310-f05f-4fbc-b74b-82d18109adf1)

### 3. Hồ sơ khách hàng & Lịch sử nhu cầu
Quản lý tập trung thông tin khách hàng và các phân khúc họ đang quan tâm.
![Customer Profile](https://github.com/user-attachments/assets/90590b54-f33a-43e3-9da7-be07b41fda52)

### 4. Quản lý thông tin khách hàng
Hệ thống vẫn lưu lại thông tin khách hàng đã xóa để phục vụ cho mục tiêu kinh doanh.
![History Customer Profile](https://github.com/user-attachments/assets/4974410c-82d5-441c-8f6a-32aa159ce885)

### 5. Mô hình AI dự đoán khả năng khách hàng chốt đơn
Mô hình AI đánh giá các sản phẩm phù hợp với yêu cầu khách hàng.
![AI Profile](https://github.com/user-attachments/assets/4ea1d54b-0dcd-4aea-a740-c8445f4e53ae)

---

## 🛠 Công nghệ sử dụng

* **Backend:** Java Spring Boot (Port `8081`).
* **Frontend:** JSP, JSTL, Bootstrap 5, SB Admin Template.
* **Cấu trúc API:** Phân chia rõ ràng giữa `/api/admin` và `/api/web` để tái sử dụng logic nhưng vẫn đảm bảo bảo mật.
* **Database:** Hỗ trợ lưu trữ đa phân cấp (Tỉnh -> Quận -> Phường) cho địa chỉ sản phẩm.

---

## 🤖 Tích hợp Trí tuệ nhân tạo (AI Lead Scoring)

Điểm nhấn công nghệ của dự án là khả năng **tự động đánh giá mức độ tiềm năng** của khách hàng đối với từng sản phẩm thông qua một dịch vụ AI độc lập (Microservice).

### 1. Cơ chế hoạt động (Smart Lead Matching)
Thay vì chỉ lọc dữ liệu thô, hệ thống sử dụng mô hình học máy để phân tích:
* **Price Matching:** Tính toán độ lệch giữa ngân sách khách hàng và giá thực tế.
* **Area Matching:** So sánh diện tích mong muốn với thông số sản phẩm.
* **Location Relevance:** Kiểm tra sự trùng khớp về vị trí địa lý (Phường/Xã).

### 2. Phân loại khách hàng (Classification)
Dữ liệu từ Spring Boot được gửi sang [AI Service (FastAPI)](https://github.com/toandev2505/customer-management-ai) để xử lý và trả về các nhãn định danh:
* 🔴 **HOT:** Khách hàng cực kỳ tiềm năng, các tiêu chí khớp gần như hoàn hảo.
* 🟡 **WARM:** Khách hàng quan tâm, có một vài tiêu chí lệch nhẹ nhưng vẫn đáng cân nhắc.
* 🔵 **COLD:** Tiêu chí lệch nhiều, độ ưu tiên chăm sóc thấp hơn.

### 3. Công nghệ AI sử dụng
* **Model:** Random Forest Classifier (Scikit-learn).
* **Communication:** Sử dụng `RestTemplate` để kết nối liên dịch vụ giữa Java và Python.
* **Sorting:** Sản phẩm được tự động sắp xếp theo **AI Score** từ cao xuống thấp.

---

## 💾 Dữ liệu mẫu (Lưu nhu cầu tự động)

Hệ thống sử dụng cấu trúc JSON sau để lưu lại hành vi tìm kiếm của khách hàng:

```json
{
    "customerId": 1,
    "minPrice": 20.0,
    "maxPrice": 40.0,
    "districtIds": [760, 761],
    "propertyType": "VILLA",
    "note": "Hệ thống tự động lưu từ bộ lọc tìm kiếm"
}
```

## 🚀 Hướng dẫn cài đặt và khởi chạy

### 1. Yêu cầu hệ thống
* **Java:** Phiên bản 11 hoặc 17 (Khuyên dùng).
* **Build Tool:** Maven 3.6+.
* **Database:** MySQL 8.0 hoặc PostgreSQL.
* **IDE:** IntelliJ IDEA, Eclipse hoặc VS Code.

### 2. Các bước thiết lập
1. **Clone dự án:**
   ```bash
   # Clone AI Service
    git clone [https://github.com/toandev2505/customer-management-ai](https://github.com/toandev2505/customer-management-ai)
    cd customer-management-ai

# Cài đặt môi trường và thư viện
    pip install -r requirements.txt

# Khởi chạy server AI (mặc định port 8000)
    uvicorn main:app --port 8000

# Clone Spring Boot Project
    git clone [https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git](https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git)
    cd YOUR_REPO_NAME
```
