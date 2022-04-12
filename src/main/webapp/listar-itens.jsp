<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
							<h6 class="card-title">Lista de itens - Total: ${fn:length(sessionScope.itens)}</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th>Id</th>
											<th>Data de aquisição</th>
											<th>Data de cadastro</th>
											<th>Marca</th>
											<th>Modelo</th>
											<th>Patrimônio</th>
											<th>Local</th>
											<th class="text-center">Opções</th>
										</tr>
									</thead>
									<c:forEach var="item" items="${sessionScope.itens}">
										<tbody>
											<tr>
												<td>${item.id}</td>
												<td>${item.data_de_aquisicao}</td>
												<td>${item.data_de_cadastro}</td>
												<td>${item.marca}</td>
												<td>${item.modelo}</td>
												<td>${item.patrimonio}</td>
												<td>${item.local.nome}</td>
												<td class="text-center">
													<div class="dropdown">
														<a href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="img/settings.svg" class="img-fluid"></a>
														<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
															<li><a class="dropdown-item" href="popularItem?id=${item.id}"><i data-feather="edit"></i> Editar</a></li>
															<li><a class="dropdown-item" href="cadastrarMovimentacao?id=${item.id}"><i data-feather="plus"></i> Cadastrar movimentação</a></li>
															<li><a class="dropdown-item" href="movimentacoes?id=${item.id}"><i data-feather="list"></i> Listar movimentações</a></li>
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