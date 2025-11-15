const { Sequelize } = require('sequelize');

// Thay thế các giá trị này bằng thông tin kết nối CSDL SQL Server 
const sequelize = new Sequelize('QuanLyNhanKhauDB', 'username_sqlserver', 'password_sqlserver', {
    host: 'localhost', 
    dialect: 'mssql', 
    logging: false   
});

module.exports = sequelize;

