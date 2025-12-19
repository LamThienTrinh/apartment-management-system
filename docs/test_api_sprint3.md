

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

