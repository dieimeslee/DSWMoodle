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
  <link href="css/bootstrap.css" rel="stylesheet">
  <link href="css/sb-admin.css" rel="stylesheet">
  <link href="css/plugins/morris.css" rel="stylesheet">
  <link href="css/pages/login.css" rel="stylesheet">
</head>

  <body class="bg-dark">
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

    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="../js/login.js"></script>
  </body>

</html>