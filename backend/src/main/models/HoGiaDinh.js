
const { DataTypes } = require('sequelize');
const sequelize = require('../config/database'); // Import kết nối CSDL

const HoGiaDinh = sequelize.define('HoGiaDinh', {
    ID_HoGiaDinh: {
        type: DataTypes.INTEGER,
        primaryKey: true,
        autoIncrement: true,
        field: 'ID_HoGiaDinh'
    },
    MaHoGiaDinh: {
        type: DataTypes.STRING(50),
        allowNull: false,
        unique: true, 
        field: 'MaHoGiaDinh'
    },
    TenChuHo: {
        type: DataTypes.STRING(100),
        field: 'TenChuHo'
    },
    SoDienThoaiLienHe: {
        type: DataTypes.STRING(15),
        field: 'SoDienThoaiLienHe'
    },
    EmailLienHe: {
        type: DataTypes.STRING(100),
        field: 'EmailLienHe'
    },
    SoTang: {
        type: DataTypes.INTEGER,
        field: 'SoTang'
    },
    SoCanHo: {
        type: DataTypes.STRING(50),
        field: 'SoCanHo'
    },
    DienTich: {
        type: DataTypes.FLOAT,
        field: 'DienTich'
    },
    TrangThai: {
        type: DataTypes.STRING(50),
        field: 'TrangThai'
    },
    NgayTao: {
        type: DataTypes.DATE,
        defaultValue: DataTypes.NOW, // DEFAULT GETDATE()
        field: 'NgayTao'
    },
    NgayCapNhat: {
        type: DataTypes.DATE,
        field: 'NgayCapNhat'
    }
}, {
    tableName: 'HoGiaDinh', 
    timestamps: false // Tắt tự động thêm createdAt và updatedAt của Sequelize
});

module.exports = HoGiaDinh;