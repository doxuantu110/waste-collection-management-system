<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/common/header.jsp">
    <jsp:param name="title" value="Home - Spring Boot Project"/>
</jsp:include>

<main class="container py-5">
    <!-- Hero Section -->
    <div class="row mb-5">
        <div class="col-md-8 mx-auto text-center">
            <h1 class="display-4 mb-4">Welcome to Spring Boot Project</h1>
            <p class="lead text-muted">A modern web application built with Spring Boot and Bootstrap</p>
            <div class="mt-4">
                <a href="<c:url value='/about'/>" class="btn btn-primary me-2">Learn More</a>
                <a href="<c:url value='/contact'/>" class="btn btn-outline-primary">Contact Us</a>
            </div>
        </div>
    </div>

    <!-- Features Section -->
    <div class="row g-4 mb-5">
        <div class="col-md-4">
            <div class="card h-100">
                <div class="card-body text-center">
                    <i class="fas fa-rocket fa-3x text-primary mb-3"></i>
                    <h3 class="card-title h5">Fast & Efficient</h3>
                    <p class="card-text">Built with Spring Boot for optimal performance and scalability.</p>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card h-100">
                <div class="card-body text-center">
                    <i class="fas fa-shield-alt fa-3x text-primary mb-3"></i>
                    <h3 class="card-title h5">Secure</h3>
                    <p class="card-text">Enterprise-grade security with Spring Security integration.</p>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card h-100">
                <div class="card-body text-center">
                    <i class="fas fa-mobile-alt fa-3x text-primary mb-3"></i>
                    <h3 class="card-title h5">Responsive</h3>
                    <p class="card-text">Fully responsive design that works on all devices.</p>
                </div>
            </div>
        </div>
    </div>

    <!-- Latest Updates Section -->
    <div class="row">
        <div class="col-12">
            <h2 class="section-title">Latest Updates</h2>
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Date</th>
                            <th>Title</th>
                            <th>Description</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>2024-03-20</td>
                            <td>New Feature Release</td>
                            <td>Added user management system</td>
                            <td><span class="badge bg-success">Completed</span></td>
                        </tr>
                        <tr>
                            <td>2024-03-15</td>
                            <td>System Update</td>
                            <td>Performance improvements</td>
                            <td><span class="badge bg-info">In Progress</span></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</main>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/> 