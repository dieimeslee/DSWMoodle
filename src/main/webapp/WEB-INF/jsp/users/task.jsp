<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
<!-- Navigation-->
<jsp:include page="/WEB-INF/jsp/navbar.jsp"></jsp:include>
<div class="content-wrapper">
    <div class="container">
        <div class="card card-register mx-auto mt-5">
            <div class="card-header">Cadastro de usuário</div>
            <div class="card-body">
                <form action="${linkTo[UsersController].createTask}" method="post">

                    <div class="form-group">
                        <div class="form-row">
                            <div class="col-md-6">
                                <label for="name">Nome</label>
                                <input class="form-control" id="name" name="name" type="text" aria-describedby="nameHelp" placeholder="Insira o nome da tarefa" required>
                            </div>
                            <div class="col-md-6">
                                <label for="downloadLink">Descricao</label>
                                <input class="form-control" id="description" name="description" type="text" aria-describedby="nameHelp" placeholder="Insira a descrição da tarefa" required>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="form-row">
                            <div class="col-md-6">
                                <label for="downloadLink">Link de Download</label>
                                <input class="form-control" id="downloadLink" name="downloadLink" type="text" aria-describedby="nameHelp" placeholder="Insira o link de download" required>
                            </div>
                            <div class="col-md-6">
                                <label for="class">Nome da Turma</label>
                                <input class="form-control" id="class" name="_class" type="text" aria-describedby="emailHelp" placeholder="Insira o nome da Turma" required>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="form-row">
                            <div class="col-md-6">
                                <label for="date">Data</label>
                                <input class="form-control" id="date" type="date" name="date" placeholder="Insira a data da entrega" required>
                            </div>
                        </div>
                        <div id="divPasswords"></div>
                    </div>
                    <input type="submit" class="btn btn-success btn-block" id="cadastrar-btn" value="Criar Tarefa" >
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
