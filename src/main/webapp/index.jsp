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
					    	<h6 class="card-title">Dashboard</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th>Local</th>
											<th class="text-center">Itens em estoque</th>
										</tr>
									</thead>
									<c:forEach var="item" items="${sessionScope.itensPorLocal}">
										<tbody>
											<tr>
												<td><h6><span class="badge badge-secondary"> ${item.local}</span></h6></td>
												<td class="text-center"><span class="badge badge-pill badge-info"><i data-feather="monitor"></i> ${item.quantidade}</span></td>
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