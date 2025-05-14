<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Trang Admin - Hệ thống Quản lý Chất thải</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 1200px;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
            margin-bottom: 20px;
        }
        .welcome-message {
            background-color: #e8f5e9;
            padding: 15px;
            border-radius: 4px;
            margin-bottom: 20px;
        }
        .menu {
            margin-top: 20px;
        }
        .menu-item {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            text-decoration: none;
            border-radius: 4px;
            display: inline-block;
            margin-right: 10px;
        }
        .menu-item:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="welcome-message">
            <h1>Chào mừng Admin!</h1>
            <p>Bạn đang ở trang quản trị hệ thống quản lý chất thải.</p>
        </div>
        
        <div class="menu">
            <a href="#" class="menu-item">Quản lý Người dùng</a>
            <a href="#" class="menu-item">Báo cáo Thống kê</a>
            <a href="#" class="menu-item">Cấu hình Hệ thống</a>
            <a href="login.jsp" class="menu-item" style="background-color: #f44336;">Đăng xuất</a>
        </div>
    </div>
</body>
</html>
