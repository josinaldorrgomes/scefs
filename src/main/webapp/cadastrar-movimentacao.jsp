<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang='pt-BR'>
<head>
<link href="img/favicon.ico" rel="icon">
<title>SCEFS | Cia. Hering</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<div class="container-fluid">
		<div class="row">
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
				<div class="py-3">
					<div class="card">
						<div class="card-header">
							<h6 class="card-title">Cadastrar movimentação</h6>
						</div>
						<div class="card-body">
							<form action="Controller" method="post">
								<div class="form-group row">
									<label for="item" class="col-sm-2 col-form-label">Item</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" name="item" readonly="readonly" value="${item.id}" />
									</div>
								</div>
								<div class="form-group row">
									<label for="data" class="col-sm-2 col-form-label">Data de cadastro</label>
									<div class="col-sm-4">
										<input type="date" class="form-control" name="data" pattern="[0-9]{2}/[0-9]{2}/[0-9]{4}" required="required" />
									</div>
								</div>
								<div class="form-group row">
									<label for="tipo" class="col-sm-2 col-form-label">Tipo de movimentação</label>
									<div class="col-sm-4">
										<select class="form-control" name="tipo">
											<option selected>Selecionar...</option>
											<option value="Transferência">Transferência</option>
											<option value="Empréstimo">Empréstimo</option>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label for="origem" class="col-sm-2 col-form-label">Local de origem</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" name="origem" readonly="readonly" value="${item.local.nome}" />
									</div>
								</div>
								<div class="form-group row">
									<label for="destino" class="col-sm-2 col-form-label">Local de destino</label>
									<div class="col-sm-4">
										<select class="form-control" name="destino">
											<option selected>Selecionar...</option>
											<option value="Anápolis-GO">Anápolis-GO</option>
											<option value="Bom Retiro-SC">Bom Retiro-SC</option>
											<option value="Goianésia-GO">Goianésia-GO</option>
											<option value="Itororó-SC">Itororó-SC</option>
											<option value="Matriz-SC">Matriz-SC</option>
											<option value="Paraúna-GO">Paraúna-GO</option>
											<option value="SLMB-GO">SLMB-GO</option>
											<option value="São Paulo-SP">São Paulo-SP</option>
										</select>
									</div>
								</div>
								<div class="form-group row">
									<label for="" class="col-sm-2 col-form-label"></label>
									<div class="col-sm-6 d-flex justify-content-start">
										<input type="hidden" name="logica" value="CadastrarMovimentacaoLogica" />
										<input type="hidden" name="metodo" value="cadastrar" />
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