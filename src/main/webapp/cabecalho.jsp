<!DOCTYPE html>
<html lang='pt-BR'>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/dashboard.css" rel="stylesheet">
<script src="js/feather.min.js"></script>
<title>SCEFS | Sistema de Controle de Estoque do Field Service</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-dark bg-dark fixed-top flex-md-nowrap p-0 shadow">
			<a class="navbar-brand col-sm-3 col-md-2 mr-4">SCEFS | Cia. Hering</a>
			<input class="form-control form-control-dark w-100"	type="text" placeholder="Digite a pesquisa" aria-label="Search">
			<ul class="navbar-nav px-3">
				<li class="nav-item text-nowrap">
					<a class="nav-link" href="#"><i data-feather="search"></i> Pesquisar</a>
				</li>
			</ul>
		</nav>
	</header>
	<div class="container-fluid">
		<div class="row">
			<nav class="col-md-2 d-none d-md-block bg-light sidebar">
				<div class="sidebar-sticky p-3">
					<ul class="nav flex-column">
						<li class="nav-item">
							<a class="nav-link" href="index.jsp"><i data-feather="home"></i> Início</a>
						</li>
					</ul>
					<!-- <h6 class="sidebar-heading d-flex justify-content-start px-3 mt-4 mb-1 text-muted">Usuários</h6>
        			<ul class="nav flex-column">
						<li class="nav-item">
							<a class="nav-link" href="#"><i data-feather="plus"></i> Cadastrar usuário</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="#"><i data-feather="list"></i> Listar usuários</a>
						</li>        			
        			</ul> -->
        			<h6 class="sidebar-heading d-flex justify-content-start px-3 mt-4 mb-1 text-muted">Locais</h6>
        			<ul class="nav flex-column">
						<li class="nav-item">
							<a class="nav-link" href="cadastrar-local.jsp"><i data-feather="plus"></i> Cadastrar local</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="locais"><i data-feather="list"></i> Listar locais</a>
						</li>
					</ul>
					<h6 class="sidebar-heading d-flex justify-content-start px-3 mt-4 mb-1 text-muted">Itens</h6>
					<ul class="nav flex-column">
						<li class="nav-item">
							<a class="nav-link" href="popularCadastrarItem"><i data-feather="plus"></i> Cadastrar item</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="itens"><i data-feather="list"></i> Listar itens</a>
						</li>
					</ul>
					<h6 class="sidebar-heading d-flex justify-content-start px-3 mt-4 mb-1 text-muted">Movimentação</h6>
					<ul class="nav flex-column">
						<li class="nav-item">
							<a class="nav-link" href="movimentacoes"><i data-feather="list"></i> Listar movimentações</a>
						</li>
					</ul>
					<h6 class="sidebar-heading d-flex justify-content-start px-0 mt-4 mb-1 text-muted">
						<a class="nav-link" href="logout"><i data-feather="log-out"></i>Sair</a>
					</h6>
				</div>
			</nav>
		</div>
	</div>
	<script src="js/jquery-3.4.1.slim.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript">feather.replace()</script>
</body>
</html>