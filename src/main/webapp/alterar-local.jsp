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
							<h6 class="card-title">Alterar local</h6>
						</div>
						<div class="card-body">
							<form action="alterarLocal" method="post">
								<div class="form-group row">
									<label for="id" class="col-sm-2 col-form-label">Id</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" name="id" value="${local.id}" readonly>
									</div>
								</div>
								<div class="form-group row">
									<label for="nome" class="col-sm-2 col-form-label">Nome</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" name="nome" value="${local.nome}" required>
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