const { DataTypes } = require('sequelize');
const sequelize = require('../config/database'); 

const TamTru = sequelize.define('TamTru', {
    ID_TamTru: {
        type: DataTypes.INTEGER,
        primaryKey: true,
        autoIncrement: true,
        field: 'ID_TamTru'
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
    SoCCCD: {
        type: DataTypes.STRING(12),
        field: 'SoCCCD'
    },
    NgaySinh: {
        type: DataTypes.DATEONLY,
        field: 'NgaySinh'
    },
    SoDienThoai: {
        type: DataTypes.STRING(15), 
        field: 'SoDienThoai'
    },
    NgayBatDau: {
        type: DataTypes.DATEONLY,
        allowNull: false,
        field: 'NgayBatDau'
    },
    NgayKetThuc: {
        type: DataTypes.DATEONLY,
        allowNull: false,
        field: 'NgayKetThuc'
    },
    LyDo: {
        type: DataTypes.STRING(255), 
        field: 'LyDo'
    },
    NgayDangKy: {
        type: DataTypes.DATE, 
        defaultValue: DataTypes.NOW, 
        field: 'NgayDangKy'
    }
}, {
    tableName: 'TamTru', 
    timestamps: false 
});

module.exports = TamTru;