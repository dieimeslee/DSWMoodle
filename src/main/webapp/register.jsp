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
  <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.min.js"></script>

  <script>
    $(document).ready(function() {
      $("#registration").validate({
        rules: {
          firstname: "required",
          lastname: "required",
          username: {
            required: true,
            minlength: 5
          },
          password: {
            required: true,
            minlength: 5
          },
          email: {
            required: true,
            email: true
          }
        },
        messages: {
          firstname: "Por favor insira o primeiro nome",
          lastname: "Por favor insira o sobrenome",
          email: "Por favor insira o email "
          user: {
            required: "Por favor insira o nome de usuário",
            minlength: "O nome do usuário deve conter o mínimo de 5 caracteres"
          },
          password: {
            required: "Por favor insira a senha",
            minlength: "A senha deve conter o mínimo de 5 caracteres"
          }
          email: "Por favor entre com um email válido"
        }
      });
    });
  </script>
  
</head>
  <body class="bg-dark">
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
            <a class="d-block small mt-3" href="login.html">Página inicial</a>
          </div>
        </div>
      </div>
    </div>
    <script src="bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="js/jquery-easing/jquery.easing.min.js"></script>
  </body>

</html>
