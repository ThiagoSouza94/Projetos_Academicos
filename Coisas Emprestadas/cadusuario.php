<html>
	<head>
		<title>ProjCE - Cadastro de Usuários</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="estilo.css" rel="stylesheet"/>
	</head>
	<body>
		<header>
				<h1>Cadastro de Usuários</h1>
			</header>

		<section>
			<nav>
				<ul id="menu">
					<li><a href="inicial.php"><b>Inicio</b></a></li>
					<li><a href="cadusuario.php" class="active"><b>Cadastrar</b></a></li>
					<li><a href="caditem.php"><b>Cadastrar Item</b></a></li>
					<li><a href="emprestar.php"><b>Emprestar Itens</b></a></li>
					<li><a href="status.php"><b>Status</b></a></li>
					<li><a href="index.php"><b>Sair</b></a></li>
					
				</ul></nav>
			
		<article>
			<form action="" method="post">
			<label for="name">Nome</label><input type="text" name="nome" />
			<label for="cpf">CPF </label><input type="text" name="cpf" />
			<label for="fone">Telefone/Celular</label> <input type="text" name="fone" />
			<label for=dtnascimento>Data de nascimento</label><input type="date" name="dtnascimento" />
			<label for="genero">Gênero (feminino, masculino)</label>
			<select name="genero">
			<option>Feminino</option>
			<option>Masculino</option>
			<option>Não desejo informar</option> 
			</select>
			<input type="submit"/>
			<a href="inicial.php">Voltar</a>
		</article>
		</section>

			<footer>
			<p>Todos direitos reservados.</p>
			</footer>
		
	</body>
</html>