<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
							<h6 class="card-title">Lista de movimentações do item - Total: ${fn:length(sessionScope.movimentacoes)}</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th>#</th>
											<th>Data</th>
											<th>Tipo</th>
											<th>Item</th>
											<th>Local</th>
											<th class="text-center">Opções</th>
										</tr>
									</thead>
									<c:forEach var="movimentacao" items="${sessionScope.movimentacoes}">
										<tbody>
											<tr>
												<td>${movimentacao.id}</td>
												<td>${movimentacao.data}</td>
												<td>${movimentacao.tipo}</td>
												<td>${movimentacao.item.id}</td>
												<td>${movimentacao.local.nome}</td>
												<td class="text-center">
													<div class="dropdown">
														<a href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="img/settings.svg" class="img-fluid"></a>
														<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
															<li><a class="dropdown-item" href="alterarMovimentacao&id=${movimentacao.id}"><i data-feather="edit"></i> Editar</a></li>
															<li><a class="dropdown-item" href="#"><i data-feather="trash-2"></i> Excluir</a></li>
														</ul>
													</div>
												</td>
											</tr>
										</tbody>
									</c:forEach>
								</table>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
</body>
</html>