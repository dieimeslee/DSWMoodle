<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
<!-- Navigation-->
<jsp:include page="/WEB-INF/jsp/navbar.jsp"></jsp:include>
<div class="content-wrapper">
    <div class="container">
        <div class="card card-register mx-auto mt-5">
            <div class="card-header">Cadastro de usuário</div>
            <div class="card-body">
                <form action="${linkTo[RootController].register}" method="post" name="registration" id="registration">

                    <div class="form-group">
                        <div class="form-row">
                            <div class="col-md-6">
                                <label for="firstName">Nome</label>
                                <input class="form-control" id="firstName" name="firstName" type="text" aria-describedby="nameHelp" placeholder="Insira seu nome" required>
                            </div>
                            <div class="col-md-6">
                                <label for="lastName">Sobrenome</label>
                                <input class="form-control" id="lastName" name="lastName" type="text" aria-describedby="nameHelp" placeholder="Insira seu sobrenome" required>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="form-row">
                            <div class="col-md-6">
                                <label for="userType">Tipo de usuário</label>
                                <select class="form-control" id="userType" name="userType" required>
                                    <option selected disabled value>--Selecione--</option>
                                    <option value="aluno">Aluno</option>
                                    <option value="professor">Professor</option>
                                    <option value="admin">Admin</option>
                                </select>
                            </div>
                            <div class="col-md-6">
                                <label for="email">Email</label>
                                <input class="form-control" id="email" name="email" type="email" aria-describedby="emailHelp" placeholder="Insira seu email" required>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="form-row">
                            <div class="col-md-6">
                                <label for="user">Usuário</label>
                                <input class="form-control" id="user" type="user" name="user" placeholder="Insira o usuário" required>
                            </div>
                            <div class="col-md-6">
                                <label for="password">Senha</label>
                                <input class="form-control" id="password" type="password" name="password" placeholder="Insira uma senha" required>
                            </div>
                        </div>
                        <div id="divPasswords"></div>
                    </div>
                    <input type="submit" class="btn btn-success btn-block" id="cadastrar-btn" value="Cadastrar" >
                </form>

                <h3>${message}</h3>
                <div class="text-center">
                    <a class="d-block small mt-3" href="login.jsp">Página inicial</a>
                </div>
            </div>
        </div>
    </div>
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
        <div class="container">
            <div class="text-center">
                <small>Copyright © Moodle 2017</small>
            </div>
        </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
