CRUD de Produtos em Java com PostgreSQL
Este projeto é uma aplicação simples que implementa operações CRUD (Create, Read, Update, Delete) para gerenciamento de produtos com apenas nome e preço usando Java e PostgreSQL.

Funcionalidades
Criar um produto

Listar todos os produtos

Atualizar produto

Deletar produto

Tecnologias Utilizadas
Java 24

JDBC

PostgreSQL

Maven

Configuração do Banco de Dados
Crie o banco:

sql
CREATE DATABASE meubanco;
Crie a tabela:

sql
CREATE TABLE produtos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DOUBLE PRECISION NOT NULL
);
Configure as credenciais no arquivo application.properties:

properties

db.url=jdbc:postgresql://localhost:5432/meubanco
db.username=seu_usuario
db.password=sua_senha
Como Rodar
Clone:

git clone https://github.com/RaulRenshaw/CRUD-com_PostgreSQL.git
cd seu_projeto
Configure o banco conforme acima.

Compile e rode com Maven:

mvn clean install
mvn exec:java -Dexec.mainClass="com.seu_pacote.Main"

Exemplo de Uso
Criar Produto

Produto p = new Produto("Caneca", 25.50);
produtoDAO.criar(p);
Listar Produtos

List<Produto> produtos = produtoDAO.listarTodos();
produtos.forEach(prod -> System.out.println(prod.getNome() + " - " + prod.getPreco()));
Atualizar Produto

Produto p = produtoDAO.buscarPorId(1);
p.setPreco(29.90);
produtoDAO.atualizar(p);
Deletar Produto

produtoDAO.deletar(1);
Estrutura do Projeto

src/
 └─ main/
     ├─ java/
     │   └─ com/
     │       └─ seu_pacote/
     │           ├─ model/         # Produto.java
     │           ├─ controller/    # ProdutoController.java
     │           ├─ repository/    # ProdutoRepository.java
     │           ├─ service/       # ProdutoService.java
     │           └─ Application.java      # Classe principal
     └─ resources/
         └─ application.properties
