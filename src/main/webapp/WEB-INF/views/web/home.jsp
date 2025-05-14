<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Trang Chủ thải - Hệ thống Quản lý Chất thải</title>
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
            background-color: #e3f2fd;
            padding: 15px;
            border-radius: 4px;
            margin-bottom: 20px;
        }
        .menu {
            margin-top: 20px;
        }
        .menu-item {
            background-color: #2196F3;
            color: white;
            padding: 10px 15px;
            text-decoration: none;
            border-radius: 4px;
            display: inline-block;
            margin-right: 10px;
        }
        .menu-item:hover {
            background-color: #1976D2;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="welcome-message">
            <h1>Chào mừng Chủ thải!</h1>
            <p>Bạn đang ở trang quản lý chất thải của mình.</p>
        </div>
        
        <div class="menu">
            <a href="#" class="menu-item">Khai báo Chất thải</a>
            <a href="#" class="menu-item">Xem Lịch sử</a>
            <a href="#" class="menu-item">Báo cáo</a>
            <a href="login.jsp" class="menu-item" style="background-color: #f44336;">Đăng xuất</a>
        </div>
    </div>
</body>
</html>
