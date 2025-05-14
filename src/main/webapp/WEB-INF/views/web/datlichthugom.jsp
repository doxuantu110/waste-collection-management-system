<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/common/header.jsp">
    <jsp:param name="title" value="Đặt lịch thu gom - Green City"/>
</jsp:include>

<div class="container-fluid" style="min-height: 100vh; background: #f8f9fa;">
  <div class="row">
    <!-- Sidebar -->
    <nav class="col-md-2 d-none d-md-block bg-success sidebar text-white" style="min-height: 100vh;">
      <div class="position-sticky pt-3">
        <h4 class="mb-4 mt-3">GREEN CITY</h4>
        <div class="mb-2">Xin chào, Nguyễn Văn A<br><span class="small">Mã KH: KH001</span></div>
        <ul class="nav flex-column">
          <li class="nav-item mb-2"><a class="nav-link text-white active" href="#"><i class="fas fa-calendar-check me-2"></i>Đặt lịch thu gom</a></li>
          <li class="nav-item mb-2"><a class="nav-link text-white" href="#"><i class="fas fa-history me-2"></i>Lịch sử thu gom</a></li>
          <li class="nav-item mb-2"><a class="nav-link text-white" href="#"><i class="fas fa-comment-dots me-2"></i>Gửi phản ánh</a></li>
          <li class="nav-item mb-2"><a class="nav-link text-white" href="#"><i class="fas fa-file-invoice me-2"></i>Xem hóa đơn</a></li>
          <li class="nav-item mb-2"><a class="nav-link text-white" href="#"><i class="fas fa-info-circle me-2"></i>Hướng dẫn phân loại</a></li>
        </ul>
      </div>
    </nav>
    <!-- Main content -->
    <main class="col-md-10 ms-sm-auto px-md-4 py-4">
      <div class="card mb-4">
        <div class="card-body">
          <h2 class="mb-4 text-success">Đặt lịch thu gom</h2>
          <form>
            <div class="row mb-3">
              <div class="col-md-6">
                <label for="ngay" class="form-label">Ngày thu gom</label>
                <input type="date" class="form-control" id="ngay" name="ngay">
              </div>
              <div class="col-md-6">
                <label for="gio" class="form-label">Giờ thu gom</label>
                <select class="form-select" id="gio" name="gio">
                  <option>7:00</option>
                  <option>9:00</option>
                  <option>15:00</option>
                </select>
              </div>
            </div>
            <div class="row mb-3">
              <div class="col-md-6">
                <label for="loairac" class="form-label">Loại rác</label>
                <select class="form-select" id="loairac" name="loairac">
                  <option>Rác sinh hoạt</option>
                  <option>Rác tái chế</option>
                  <option>Rác cồng kềnh</option>
                </select>
              </div>
              <div class="col-md-6">
                <label for="khoiluong" class="form-label">Khối lượng ước tính (kg)</label>
                <input type="number" class="form-control" id="khoiluong" name="khoiluong" min="1">
              </div>
            </div>
            <div class="mb-3">
              <label for="ghichu" class="form-label">Ghi chú</label>
              <textarea class="form-control" id="ghichu" name="ghichu" rows="2"></textarea>
            </div>
            <button type="submit" class="btn btn-success">Xác nhận đặt lịch</button>
          </form>
        </div>
      </div>
      <div class="card">
        <div class="card-body">
          <h3 class="mb-3 text-success">Lịch sử thu gom</h3>
          <div class="table-responsive">
            <table class="table table-bordered align-middle">
              <thead class="table-success">
                <tr>
                  <th>Ngày</th>
                  <th>Giờ</th>
                  <th>Loại rác</th>
                  <th>Khối lượng</th>
                  <th>Trạng thái</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>2024-06-01</td>
                  <td>7:00</td>
                  <td>Rác sinh hoạt</td>
                  <td>5</td>
                  <td><span class="badge bg-success">Hoàn thành</span></td>
                </tr>
                <tr>
                  <td>2024-06-03</td>
                  <td>9:00</td>
                  <td>Rác tái chế</td>
                  <td>3</td>
                  <td><span class="badge bg-warning text-dark">Đang thực hiện</span></td>
                </tr>
                <tr>
                  <td>2024-06-05</td>
                  <td>15:00</td>
                  <td>Rác cồng kềnh</td>
                  <td>10</td>
                  <td><span class="badge bg-secondary">Chưa bắt đầu</span></td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </main>
  </div>
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/> 