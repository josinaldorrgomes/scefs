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
							<h6 class="card-title">Cadastrar item</h6>
						</div>
						<div class="card-body">
							<form action="cadastrarItem" method="post">
								<div class="form-group row">
									<label for="data_de_aquisicao" class="col-sm-2 col-form-label">Data de aquisi��o</label>
									<div class="col-sm-4">
										<input type="date" class="form-control" name="data_de_aquisicao" pattern="[0-9]{2}/[0-9]{2}/[0-9]{4}" required="required" />
									</div>
								</div>
								<div class="form-group row">
									<label for="marca" class="col-sm-2 col-form-label">Marca</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" name="marca" required="required" />
									</div>
								</div>
								<div class="form-group row">
									<label for="modelo" class="col-sm-2 col-form-label">Modelo</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" name="modelo" required="required" />
									</div>
								</div>
								<div class="form-group row">
									<label for="patrimonio" class="col-sm-2 col-form-label">Patrim�nio</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" name="patrimonio" pattern="[0-9]+$" required="required" />
										<small class="text-muted">*Apenas n�meros</small>
									</div>
								</div>
								<div class="form-group row">
									<label for="local_id" class="col-sm-2 col-form-label">Local</label>
									<div class="col-sm-4">
										<select class="form-control" name="local_id" required="required">
											<option selected></option>
											<option value="1">HRG CD AN�POLIS-GO</option>
											<option value="2">HRG BOM RETIRO-SC</option>
											<option value="3">HRG GOIAN�SIA-GO</option>
											<option value="4">HRG ITOROR�-SC</option>
											<option value="5">HRG MATRIZ-SC</option>
											<option value="6">HRG PARA�NA-GO</option>
											<option value="7">HRG S�O LU�S-GO</option>
											<option value="8">HRG S�O PAULO-SP</option>
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