<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  request.setAttribute("pageTitle", "Register");
%>
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
<div class="container">
  <div class="card card-register mx-auto mt-5">
    <div class="card-header">Cadastro de usuário</div>
    <div class="card-body">
      <form action="https://1-dot-researchmanagement-178603.appspot.com/user" method="post" name="registration" id="registration">

        <div class="form-group">
          <div class="form-row">
            <div class="col-md-6">
              <label for="name">Nome</label>
              <input class="form-control" id="firstName" name="firstName" type="text" aria-describedby="nameHelp" placeholder="Insira seu nome">
            </div>
            <div class="col-md-6">
              <label for="sobrenome">Sobrenome</label>
              <input class="form-control" id="lastName" name="lastName" type="text" aria-describedby="nameHelp" placeholder="Insira seu sobrenome">
            </div>
          </div>
        </div>

        <div class="form-group">
          <div class="form-row">
            <div class="col-md-6">
              <label for="user-type">Tipo de usuário</label>
              <select class="form-control" id="userType" name="userType">
                <option selected disabled value>--Selecione--</option>
                <option value="aluno">Aluno</option>
                <option value="professor">Professor</option>
              </select>
            </div>
            <div class="col-md-6">
              <label for="email">Email</label>
              <input class="form-control" id="email" name="email" type="email" aria-describedby="emailHelp" placeholder="Insira seu email">
            </div>
          </div>
        </div>

        <div class="form-group">
          <div class="form-row">
            <div class="col-md-6">
              <label for="username">Usuário</label>
              <input class="form-control" id="user" type="user" placeholder="Insira o usuário">
            </div>
            <div class="col-md-6">
              <label for="password">Senha</label>
              <input class="form-control" id="password" type="password" placeholder="Insira uma senha">
            </div>
          </div>
          <div id="divPasswords"></div>
        </div>
        <input type="submit" class="btn btn-success btn-block" id="cadastrar-btn" value="Cadastrar" >
      </form>

      <div class="text-center">
        <a class="d-block small mt-3" href="login.jsp">Página inicial</a>
      </div>
    </div>
  </div>
</div>
<script src="js/register.js" type="text/javascript"></script>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>