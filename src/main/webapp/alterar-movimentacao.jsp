<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
							<h6 class="card-title">Alteração da movimentação nº ${movimentacao.id}</h6>
						</div>
						<div class="card-body">
							<form action="alterarMovimentacao" method="post">
								<div class="form-group row">
									<label for="id" class="col-sm-2 col-form-label">Id</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" name="id" value="${movimentacao.id}" readonly>
									</div>
								</div>
								<div class="form-group row">
									<label for="item_id" class="col-sm-2 col-form-label">Item</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" name="item_id" value="${movimentacao.item.id}" readonly>
									</div>
								</div>
								<div class="form-group row">
			                    	<label for="data" class="col-sm-2 col-form-label">Data</label>
			                    	<div class="col-sm-4">
			                        	<input type="date" class="form-control" name="data" value="<fmt:formatDate value="${movimentacao.data}" pattern="yyyy-MM-dd" />" required>
			                    	</div>
			                    </div>
			                    <div class="form-group row">
			                    	<label for="tipo" class="col-sm-2 col-form-label">Tipo</label>
			                    	<div class="col-sm-4">
			                        	<input type="text" class="form-control" name="tipo" value="${movimentacao.tipo}" required>
			                    	</div>
			                    </div>
								<div class="form-group row">
									<label for="origem" class="col-sm-2 col-form-label">Origem</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" name="origem" value="${movimentacao.origem}" required>
									</div>
								</div>
								<div class="form-group row">
									<label for="destino" class="col-sm-2 col-form-label">Destino</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" name="destino" value="${movimentacao.destino}" required>
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