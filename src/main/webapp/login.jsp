<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  request.setAttribute("pageTitle", "Login");
  request.setAttribute("siteName", "Moodle");
%>
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
<div class="container">
  <div class="card card-register mx-auto mt-5">
    <div class="card-header">Login</div>
    <div class="card-body">

      <form action="https://1-dot-researchmanagement-178603.appspot.com/login" method="post" name="registration" id="registration">

        <div class="form-group">
          <div class="form-row">
            <div class="col-md-12">
              <label for="name">Usuário</label>
              <input class="form-control" id="user" name="user" type="text" aria-describedby="nameHelp" placeholder="Insira seu nome" required>
            </div>
          </div>
        </div>

        <div class="form-group">
          <div class="form-row">
            <div class="col-md-12">
              <label for="sobrenome">Senha</label>
              <input class="form-control" type="password" id="password" name="password" aria-describedby="nameHelp" placeholder="Insira seu sobrenome" required>
            </div>
          </div>
        </div>

        <input type="submit" class="btn btn-success btn-block" id="cadastrar-btn" value="Acessar" >
      </form>

      <div class="text-center">
        <a class="d-block small mt-3" href="register.jsp">Criar Usuário</a>
      </div>
    </div>
  </div>
</div>
<script src="../js/login.js"></script>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>