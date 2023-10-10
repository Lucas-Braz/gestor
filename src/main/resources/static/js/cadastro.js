function validaEnvio(){
	let podeEnviar = true
    let nome = $("#nome").val();
	let cpf_cnpj = $("#cpf_cnpj").val();
	let telefone = $("#telefone").val();
	let email = $("#email").val();
	let senha = $("#senha").val();
	let conf_senha = $("#conf_senha").val();

	if(campoVazio(nome)){
		podeEnviar = false;
		$(".nome").addClass("error-field");
		showToast({sucesso:false,mensagem:"O nome precisa ser preenchido!"});
	}
	if(!validarCPF(cpf_cnpj)){
        podeEnviar = false;
        $(".cpf").addClass("error-field");
        showToast({sucesso:false,mensagem:"O CPF informado é inválido!"});
    }
	if(campoVazio(telefone) && campoVazio(email)){
		podeEnviar = false;
		$(".email").addClass("error-field");
		showToast({sucesso:false,mensagem:"É necessário informar um email ou telefone!"});
	}
	if(campoVazio(senha)){
		podeEnviar = false;
		$(".senha").addClass("error-field");
		showToast({sucesso:false,mensagem:"É necessário informar uma senha!"});
	}else if(senha != conf_senha){
		podeEnviar = false;
		$(".senha").addClass("error-field");
		showToast({sucesso:false,mensagem:"A Senha e a confirmação de senha não conferem!"});
	}

    if(podeEnviar){
        $.ajax({
            type: "POST",
            url: "/cadUsuario",
            data: {
                nome: nome,
                email: email,
                telefone: telefone,
                cpf_cnpj: cpf_cnpj,
                senha: senha,
                conf_senha: conf_senha,
            },
            success: function(data){
                showToast(data);
            },
            error: function(){
                showToast({sucesso: false, mensagem: "Erro ao enviar o cadastro!"});
            }
        })
    }
}