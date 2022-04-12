<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
							<h6 class="card-title">Alteração do patrimônio nº ${item.patrimonio}</h6>
						</div>
						<div class="card-body">
							<form action="alterarItem" method="post">
								<div class="form-group row">
									<label for="id" class="col-sm-2 col-form-label">Id</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" name="id" value="${item.id}" readonly>
									</div>
								</div>
			                    <div class="form-group row">
			                    	<label for="data_de_aquisicao" class="col-sm-2 col-form-label">Data de aquisição</label>
			                    	<div class="col-sm-4">
			                        	<input type="date" class="form-control" name="data_de_aquisicao" value="${item.data_de_aquisicao}" required>
			                    	</div>
			                    </div>
			                    <div class="form-group row">
			                    	<label for="data_de_cadastro" class="col-sm-2 col-form-label">Data de cadastro</label>
			                    	<div class="col-sm-4">
			                        	<input type="date" class="form-control" name="data_de_cadastro" value="${item.data_de_cadastro}" required>
			                    	</div>
			                    </div>
								<div class="form-group row">
									<label for="marca" class="col-sm-2 col-form-label">Marca</label>
									<div class="col-sm-4">
										<input type="text" class="form-control"  name="marca" value="${item.marca}" required>
									</div>
								</div>
			                    <div class="form-group row">
			                    	<label for="Modelo" class="col-sm-2 col-form-label">Modelo</label>
			                    	<div class="col-sm-4">
			                        	<input type="text" class="form-control" name="modelo" value="${item.modelo}" required>
			                    	</div>
			                    </div>
								<div class="form-group row">
									<label for="patrimonio" class="col-sm-2 col-form-label">Patrimônio</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" name="patrimonio" value="${item.patrimonio}"  pattern="[0-9]+$" required>
										<small class="text-muted">*Apenas números</small>
									</div>
								</div>
			                    <div class="form-group row">
									<label for="nome" class="col-sm-2 col-form-label">Local</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" name="nome" value="${item.local.nome}" readonly>
									</div>
								</div>
								<div class="form-group row">
									<label for="" class="col-sm-2 col-form-label"></label>
									<div class="col-sm-6 d-flex justify-content-start">
										<button type="submit" class="btn btn-outline-primary">Confirmar alteração</button>
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