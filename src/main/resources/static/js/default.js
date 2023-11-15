function campoVazio(campo){
	if(campo.trim() == ''){
		return true;
	}else{
		return false;
	}
}

function createToastArea(){
	if($(".toaster").length == 0){
		$("body").prepend(''+
			'<div aria-live="polite" aria-atomic="true"'+
			'class="position-absolute top-0 end-0 erros">'+
			'<div class="toaster position-absolute top-0 end-0">'+
			'</div>'+
			'</div>');
	}
}

function showToast(alerta) {
	createToastArea();
	let tipo
	if(alerta.sucesso){
		tipo = ' bg-success ';
	}else{
		tipo = ' bg-danger ';
	}
	const toastElement = $('<div class="mt-1 toast align-items-center'+tipo+'text-white border-0" role="alert" aria-live="assertive" aria-atomic="true">'+
								'<div class="d-flex">'+
									'<div class="toast-body">'+
										alerta.mensagem+
									'</div>'+
									'<button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>'+
								'</div>'+
							'</div>');
	toastElement.on('hidden.bs.toast', function () {
		$(this).remove();
	});
	$(".toaster").append(toastElement);
	const newToast = new bootstrap.Toast(toastElement);
	newToast.show();
}

function validarCPF(cpf) {
	// Remover caracteres não numéricos
	cpf = cpf.replace(/\D/g, '');
	// Verificar se o CPF tem 11 dígitos
	if (cpf.length !== 11) {
		return false;
	}
	// Verificar CPFs conhecidos inválidos
	const invalidCPFs = [
	'00000000000', '11111111111', '22222222222', '33333333333', '44444444444',
	'55555555555', '66666666666', '77777777777', '88888888888', '99999999999'
	];
	if (invalidCPFs.includes(cpf)) {
		return false;
	}
	// Calcular dígitos verificadores
	let sum = 0;
	for (let i = 0; i < 9; i++) {
		sum += parseInt(cpf.charAt(i)) * (10 - i);
	}
	let remainder = (sum * 10) % 11;
	if (remainder === 10 || remainder === 11) {
		remainder = 0;
	}
	if (remainder !== parseInt(cpf.charAt(9))) {
		return false;
	}
	sum = 0;
	for (let i = 0; i < 10; i++) {
		sum += parseInt(cpf.charAt(i)) * (11 - i);
	}
	remainder = (sum * 10) % 11;
	if (remainder === 10 || remainder === 11) {
		remainder = 0;
	}
	if (remainder !== parseInt(cpf.charAt(10))) {
		return false;
	}
	return true;
}