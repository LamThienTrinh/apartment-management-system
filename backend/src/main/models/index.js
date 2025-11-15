
const sequelize = require('../config/database');
const HoGiaDinh = require('./HoGiaDinh');
const NhanKhau = require('./NhanKhau');
const TamTru = require('./TamTru');
const TamVang = require('./TamVang');

// 1. Quan hệ HoGiaDinh (1) <---> NhanKhau (N)
HoGiaDinh.hasMany(NhanKhau, {
    foreignKey: 'ID_HoGiaDinh', // Tên cột FK trong bảng NhanKhau
    as: 'danhSachNhanKhau'     // Tên gợi nhớ khi truy vấn
});
NhanKhau.belongsTo(HoGiaDinh, {
    foreignKey: 'ID_HoGiaDinh',
    as: 'hoGiaDinh'
});

// 2. Quan hệ HoGiaDinh (1) <---> TamTru (N)
HoGiaDinh.hasMany(TamTru, {
    foreignKey: 'ID_HoGiaDinh',
    as: 'danhSachTamTru'
});
TamTru.belongsTo(HoGiaDinh, {
    foreignKey: 'ID_HoGiaDinh',
    as: 'hoGiaDinh'
});

// 3. Quan hệ NhanKhau (1) <---> TamVang (N)
NhanKhau.hasMany(TamVang, {
    foreignKey: 'ID_NhanKhau',
    as: 'danhSachTamVang'
});
TamVang.belongsTo(NhanKhau, {
    foreignKey: 'ID_NhanKhau',
    as: 'nhanKhau'
});

// Xuất các model và kết nối
module.exports = {
    sequelize,
    HoGiaDinh,
    NhanKhau,
    TamTru,
    TamVang
};