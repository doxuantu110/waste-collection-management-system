<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/common/header.jsp">
    <jsp:param name="title" value="Contact Us - Spring Boot Project"/>
</jsp:include>

<main class="container py-5">
    <div class="row">
        <div class="col-md-8 mx-auto">
            <h1 class="display-4 mb-4">Contact Us</h1>
            <div class="card">
                <div class="card-body">
                    <form action="/contact" method="post">
                        <div class="mb-3">
                            <label for="name" class="form-label">Name</label>
                            <input type="text" class="form-control" id="name" name="name" required>
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" name="email" required>
                        </div>
                        <div class="mb-3">
                            <label for="subject" class="form-label">Subject</label>
                            <input type="text" class="form-control" id="subject" name="subject" required>
                        </div>
                        <div class="mb-3">
                            <label for="message" class="form-label">Message</label>
                            <textarea class="form-control" id="message" name="message" rows="5" required></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">Send Message</button>
                    </form>
                </div>
            </div>
            
            <div class="card mt-4">
                <div class="card-body">
                    <h2 class="h4 mb-3">Contact Information</h2>
                    <div class="row">
                        <div class="col-md-6">
                            <p><i class="fas fa-map-marker-alt me-2"></i> 123 Street Name, City, Country</p>
                            <p><i class="fas fa-phone me-2"></i> +1 234 567 890</p>
                        </div>
                        <div class="col-md-6">
                            <p><i class="fas fa-envelope me-2"></i> info@example.com</p>
                            <p><i class="fas fa-clock me-2"></i> Mon - Fri: 9:00 AM - 5:00 PM</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/> 
