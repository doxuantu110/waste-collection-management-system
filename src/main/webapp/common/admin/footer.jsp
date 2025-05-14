<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<footer class="footer">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6">
                <p class="mb-0">
                    &copy; <script>document.write(new Date().getFullYear())</script> 
                    <a href="#" class="text-primary">Admin Dashboard</a> - All rights reserved
                </p>
            </div>
            <div class="col-md-6">
                <div class="text-md-end">
                    <p class="mb-0">
                        Version 1.0.0
                    </p>
                </div>
            </div>
        </div>
    </div>
</footer>

<style>
.footer {
    padding: 20px 0;
    background-color: #f8f9fa;
    border-top: 1px solid #e9ecef;
    position: relative;
    bottom: 0;
    width: 100%;
}

.footer p {
    margin: 0;
    color: #6c757d;
}

.footer a {
    color: #0d6efd;
    text-decoration: none;
}

.footer a:hover {
    color: #0a58ca;
    text-decoration: underline;
}
</style>
