<html>
	<head>
		<title>ProjCE - Cadastro Item</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="estilo.css" rel="stylesheet"/>
	</head>
	<body>
		<header>
			<h1><b>Cadastro de Item</b></h1>
		</header>
		
		<section>
			<nav>
				<ul id="menu">
					<li><a href="inicial.php"><b>Inicio</b></a></li>
					<li><a href="cadusuario.php"><b>Cadastrar</b></a></li>
					<li><a href="caditem.php" class="active"><b>Cadastrar Item</b></a></li>
					<li><a href="emprestar.php"><b>Emprestar Itens</b></a></li>
					<li><a href="status.php"><b>Status</b></a></li>
					<li><a href="index.php"><b>Sair</b></a></li>
					
				</ul>
			</nav>
		  
		<article>
			<p><form action="" method="post">
			Nome: <input type="text" name="nome" /><br/><br/>
			Tipo: <input type="text" name="tipo" /><br/><br/>
			Estado : 
			<select name="genero">
			<option>Novo</option>
			<option>Semi-novo</option>
			<option>Usado</option> 
			</select><br/><br/>
			<input type="submit"/><br/><br/>
			<a href="inicial.php">Voltar</a></p>
		</article>
		</section>

		<footer>
		  <p>Todos direitos reservados.</p>
		</footer>

		
		
		
		
	</body>
</html>