<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang='pt-BR'>
<head>
<link href="img/favicon.ico" rel="icon">
<title>SCEFS | Sistema de Controle de Estoque do Field Service</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<div class="container-fluid">
		<div class="row">
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
				<div class="py-3">
					<div class="card">
						<div class="card-header">
							<h6 class="card-title">Cadastrar usuário</h6>
						</div>
						<div class="card-body">
							<form action="Controller" method="post">
								<div class="form-group row">
									<label for="login" class="col-sm-2 col-form-label">Login</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" name="login" placeholder="Login" required="required" autofocus />
									</div>
								</div>
								<div class="form-group row">
									<label for="senha" class="col-sm-2 col-form-label">Senha</label>
									<div class="col-sm-4">
										<input type="password" class="form-control" name="senha" placeholder="Senha" required="required" />
									</div>
								</div>
								<div class="form-group row">
									<label for="tipo" class="col-sm-2 col-form-label">Tipo</label>
									<div class="col-sm-4">
										<select class="form-control" name="tipo" required="required">
											<option selected></option>
											<option value="1">Gerente</option>
											<option value="2">Coordenador</option>
											<option value="3">Analista</option>
											<option value="4">Líder</option>
											<option value="5">Técnico</option>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label for="local_id" class="col-sm-2 col-form-label">Local</label>
									<div class="col-sm-4">
										<select class="form-control" name="local_id" required="required">
											<option selected></option>
											<option value="1">Anápolis-GO</option>
											<option value="2">Bom Retiro-SC</option>
											<option value="3">Goianésia-GO</option>
											<option value="4">Itororó-SC</option>
											<option value="5">Matriz-SC</option>
											<option value="6">Paraúna-GO</option>
											<option value="7">SLMB-GO</option>
											<option value="8">São Paulo-SP</option>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label for="" class="col-sm-2 col-form-label"></label>
									<div class="col-sm-6 d-flex justify-content-start">
										<button type="submit" class="btn btn-outline-primary">Confirmar cadastro</button>
										<button type="reset" class="btn btn-outline-secondary">Limpar tudo</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
</body>
</html>