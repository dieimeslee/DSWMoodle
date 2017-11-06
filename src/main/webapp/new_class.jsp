<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Ambiente Virtual de Aprendizagem</title>
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="css/sb-admin.css" rel="stylesheet">
  <script src="js/jquery.min.js"></script>
</head>

  <body class="bg-dark">
    <div class="container">
      <div class="card card-register mx-auto mt-5">
        <div class="card-header">Cadastro de turma</div>
        <div class="card-body">

          <form action="https://1-dot-researchmanagement-178603.appspot.com/class" method="post" name="registration" id="registration">

            <div class="form-group">
              <div class="form-row">
                <div class="col-md-12">
                  <label for="name">Nome</label>
                  <input class="form-control" id="name" name="limit" type="text" aria-describedby="nameHelp" placeholder="Insira seu nome">
                </div>
              </div>
            </div>

            <div class="form-group">
              <div class="form-row">
                <div class="col-md-12">
                  <label for="sobrenome">Limite de alunos</label>
                  <input class="form-control" id="limit" name="limit" type="text" aria-describedby="nameHelp" placeholder="Insira seu sobrenome">
                </div>
              </div>
            </div>

            <input type="submit" class="btn btn-success btn-block" id="cadastrar-btn" value="Cadastrar" >
          </form>

          <div class="text-center">
            <a class="d-block small mt-3" href="login.html">Página inicial</a>
          </div>
        </div>
      </div>
    </div>
    
    <script src="bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="js/jquery-easing/jquery.easing.min.js"></script>

  </body>

</html>