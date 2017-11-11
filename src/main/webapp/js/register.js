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