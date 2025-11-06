const { DataTypes } = require('sequelize');
const sequelize = require('../config/database'); 

const TamVang = sequelize.define('TamVang', {
    ID_TamVang: {
        type: DataTypes.INTEGER,
        primaryKey: true,
        autoIncrement: true, 
        field: 'ID_TamVang'
    },
    ID_NhanKhau: {
        type: DataTypes.INTEGER,
        allowNull: false, 
        field: 'ID_NhanKhau'

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
    NoiDen: {
        type: DataTypes.STRING(255), 
        field: 'NoiDen'
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
    tableName: 'TamVang', 
    timestamps: false 
});

module.exports = TamVang;