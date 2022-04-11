<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
							<h6 class="card-title">Lista de movimentações do item - Total: ${fn:length(sessionScope.movimentacoes)}</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th>Item</th>
											<th>Data</th>
											<th>Tipo</th>
											<th>Origem</th>
											<th>Destino</th>
											<th class="text-center">Opções</th>
										</tr>
									</thead>
									<c:forEach var="movimentacao" items="${sessionScope.movimentacoes}">
										<tbody>
											<tr>
												<td>${movimentacao.item.id}</td>
												<td><fmt:formatDate value="${movimentacao.data}" pattern="yyyy/MM/dd" /></td>
												<td>${movimentacao.tipo}</td>
												<td>${movimentacao.origem}</td>
												<td>${movimentacao.destino}</td>
												<td class="text-center">
													<div class="dropdown">
														<a href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="img/settings.svg" class="img-fluid"></a>
														<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
															<li><a class="dropdown-item" href="Controller?logica=AlterarMovimentacaoLogica&metodo=popularMovimentacao&id=${movimentacao.id}"><i data-feather="edit"></i> Editar</a></li>
															<li><a class="dropdown-item" href="Controller?logica=RemoverMovimentacaoLogica&id=${movimentacao.id}"><i data-feather="trash-2"></i> Excluir</a></li>
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