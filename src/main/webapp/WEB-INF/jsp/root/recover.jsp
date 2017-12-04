<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
<div class="container">
    <div class="card card-register mx-auto mt-5">
        <div class="card-header">Login</div>
        <div class="card-body">

            <form action="${linkTo[RootController].recover}" method="post">
                <p>${message}</p>
                <div class="form-group">
                    <div class="form-row">
                        <div class="col-md-12">
                            <label for="user">Usuário</label>
                            <input class="form-control" id="user" name="user" type="text" aria-describedby="nameHelp" placeholder="Insira seu nome" required>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="form-row">
                        <div class="col-md-12">
                            <label for="password">Nova Senha</label>
                            <input class="form-control" type="password" id="password" name="newPassword" aria-describedby="nameHelp" placeholder="Insira sua nova senha" required>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="form-row">
                        <div class="col-md-12">
                            <label for="email">E-mail</label>
                            <input class="form-control" type="email" id="email" name="email" aria-describedby="nameHelp" placeholder="Insira seu e-mail" required>
                        </div>
                    </div>
                </div>

                <input type="submit" class="btn btn-success btn-block" id="cadastrar-btn" value="Recuperar" >
            </form>

        </div>
    </div>
</div>
<script src="../js/login.js"></script>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>