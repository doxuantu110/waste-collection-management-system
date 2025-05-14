<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/common/header.jsp">
    <jsp:param name="title" value="About Us - Spring Boot Project"/>
</jsp:include>

<main class="container py-5">
    <div class="row">
        <div class="col-md-8 mx-auto">
            <h1 class="display-4 mb-4">About Us</h1>
            <div class="card">
                <div class="card-body">
                    <h2 class="h4 mb-3">Our Mission</h2>
                    <p class="lead">We are dedicated to creating innovative solutions using modern technologies.</p>
                    
                    <h2 class="h4 mb-3 mt-4">Our Team</h2>
                    <div class="row g-4">
                        <div class="col-md-6">
                            <div class="card h-100">
                                <div class="card-body text-center">
                                    <i class="fas fa-user-circle fa-4x text-primary mb-3"></i>
                                    <h3 class="card-title h5">John Doe</h3>
                                    <p class="card-text">Project Manager</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="card h-100">
                                <div class="card-body text-center">
                                    <i class="fas fa-user-circle fa-4x text-primary mb-3"></i>
                                    <h3 class="card-title h5">Jane Smith</h3>
                                    <p class="card-text">Lead Developer</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/> 