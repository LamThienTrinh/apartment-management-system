# API Test Cases – Sprint 3

## 1. Mục tiêu kiểm thử

Sprint 3 tập trung vào việc hoàn thiện và ổn định các API liên quan đến chức năng quản lý người dùng và xử lý dữ liệu chính của hệ thống. Mục tiêu của quá trình kiểm thử API là đảm bảo các endpoint hoạt động đúng theo yêu cầu, trả về dữ liệu chính xác, xử lý lỗi hợp lý và đảm bảo tính bảo mật cơ bản.

Các API được kiểm thử bao gồm: đăng nhập, đăng ký tài khoản, lấy danh sách người dùng, cập nhật thông tin người dùng và xóa người dùng.

---

## 2. Môi trường kiểm thử

- Công cụ: Postman
- Phương thức kiểm thử: Manual API Testing
- Định dạng dữ liệu: JSON
- Giao thức: HTTP/HTTPS
- Authentication: Bearer Token

Tất cả các request đều được gửi tới server chạy ở môi trường local hoặc staging. Các phản hồi được kiểm tra dựa trên HTTP status code, nội dung JSON trả về và thời gian phản hồi.

---

## 3. Các test case chính

### 3.1 Đăng nhập (Login API)

**Mô tả:**  
Gửi email và mật khẩu hợp lệ để xác thực người dùng.

**Kết quả mong đợi:**
- Status code: 200
- Trả về access token
- Thông tin người dùng hiển thị đúng

**Trường hợp lỗi:**
- Sai mật khẩu → 401 Unauthorized
- Thiếu trường email → 400 Bad Request

---

### 3.2 Đăng ký tài khoản (Register API)

**Mô tả:**  
Tạo tài khoản mới với email, mật khẩu và tên người dùng.

**Kết quả mong đợi:**
- Status code: 201
- Tài khoản được tạo thành công
- Không cho phép email trùng

---

### 3.3 Lấy danh sách người dùng

**Mô tả:**  
Lấy toàn bộ danh sách user trong hệ thống.

**Kết quả mong đợi:**
- Status code: 200
- Dữ liệu trả về ở dạng mảng JSON
- Có phân trang (nếu có)

---

### 3.4 Cập nhật thông tin người dùng

**Mô tả:**  
Cập nhật tên hoặc thông tin cá nhân của user.

**Kết quả mong đợi:**
- Status code: 200
- Thông tin được cập nhật đúng
- Không cho sửa user khác nếu không có quyền

---

### 3.5 Xóa người dùng

**Mô tả:**  
Xóa user bằng ID.

**Kết quả mong đợi:**
- Status code: 200 hoặc 204
- User không còn trong hệ thống

---

## 4. Kết luận

Qua quá trình kiểm thử API trong Sprint 3, các chức năng chính của hệ thống hoạt động ổn định và đáp ứng đúng yêu cầu. Một số lỗi nhỏ liên quan đến validation dữ liệu đầu vào đã được phát hiện và báo lại cho nhóm phát triển để khắc phục. Việc kiểm thử API giúp đảm bảo chất lượng sản phẩm trước khi triển khai sang giai đoạn tiếp theo.

Trong các sprint tiếp theo, nhóm sẽ mở rộng thêm test case cho các chức năng nâng cao và kiểm thử hiệu năng (performance testing) để đảm bảo hệ thống hoạt động tốt khi có nhiều người dùng truy cập cùng lúc.
