const { DataTypes } = require('sequelize');
const sequelize = require('../config/database');

const NhanKhau = sequelize.define('NhanKhau', {
    ID_NhanKhau: {
        type: DataTypes.INTEGER,
        primaryKey: true,
        autoIncrement: true,
        field: 'ID_NhanKhau'
    },
    ID_HoGiaDinh: {
        type: DataTypes.INTEGER,
        allowNull: false,
        field: 'ID_HoGiaDinh'
    },
    HoTen: {
        type: DataTypes.STRING(100),
        allowNull: false,
        field: 'HoTen'
    },
    NgaySinh: {
        type: DataTypes.DATEONLY,
        field: 'NgaySinh'
    },
    GioiTinh: {
        type: DataTypes.STRING(10), 
        field: 'GioiTinh'
    },
    SoCCCD: {
        type: DataTypes.STRING(12), 
        unique: true, 
        field: 'SoCCCD'
    },
    SoDienThoai: {
        type: DataTypes.STRING(15), 
        field: 'SoDienThoai'
    },
    Email: {
        type: DataTypes.STRING(100), 
        field: 'Email'
    },
    QuanHeVoiChuHo: {
        type: DataTypes.STRING(50), 
        field: 'QuanHeVoiChuHo'
    },
    LaChuHo: {
        type: DataTypes.BOOLEAN, 
        defaultValue: false, 
        field: 'LaChuHo'
    },
    NgayChuyenDen: {
        type: DataTypes.DATEONLY,
        field: 'NgayChuyenDen'
    },
    TrangThai: {
        type: DataTypes.STRING(50), 
        field: 'TrangThai'
    }
}, {
    tableName: 'NhanKhau', 
    timestamps: false 
});

module.exports = NhanKhau;