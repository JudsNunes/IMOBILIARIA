# Sistema de Gerenciamento Imobiliário

Um sistema completo para gerenciamento de corretores, imóveis e anúncios em uma imobiliária.

## Tecnologias Utilizadas
- Java 17
- Spring Boot 3
- MySQL 8
- Docker
- Maven
- Lombock
- SpringWeb
- Validation I/O
- Postman
- RestAPI

## Funcionalidades
- CRUD de Corretores
- CRUD de Imóveis
- CRUD de Anúncios (com associação entre corretores e imóveis)
- Busca de anúncios por bairro ou nome do corretor

## Configuração do Ambiente

### Pré-requisitos
- Docker Desktop e Docker Compose instalados
- Java JDK 17+
- Maven (para desenvolvimento)
- Postman (Consultas/Cadastro/Update/Delete)


### Executando com Docker
1. Clone o repositório
2. Navegue até a pasta do projeto
3. Execute:
   ```bash
   docker-compose up -d
   
### Utilização da aplicação
1. Cadastro de Imóvel
2. Cadastro de Corretor
3. Criação de Anuncio

### Instalação e Configuração Inicial do Postman
1. ###  Baixe e instale o Postman: https://www.postman.com/downloads/
Abra o Postman e faça login ou crie uma conta (opcional, mas recomendado para sincronização).

2. ###  Criar uma Nova Coleção
   Clique em "Collections" no menu lateral.

3. ###  Clique no botão "+" ou em "Create Collection". Nomeie como "Imobiliária API".
(Opcional) Adicione uma descrição, como "Endpoints para gerenciamento de corretores, imóveis e anúncios".

3. ### Configurar Variável de Ambiente
   Clique em "Environments" no menu lateral.

5. ### Crie um novo ambiente chamado "Imobiliária Local".

6. ### Adicione uma variável:
Variable: base_url
/Initial Value: http://localhost:8080

7. ### Testar os Endpoints
   A. Criar um Corretor
   Clique em "New Request" na coleção criada.
 
8. ### Criando um Corretor URL: {{base_url}}/corretor/create
 Na aba "Body", selecione "raw" e "JSON", então insira:json
{
"nome": "Maria Silva",
"email": "maria@imobiliaria.com",
"telefone": "11987654321"
}
Clique em "Send".
9. ### Resposta esperada: Status 201 Created com os dados do corretor.

10. ### Listar Todos os Corretores 
Crie uma nova requisição.Configure:Método: GET
11. Atualizando um corretor: Configure:Método: Put{{base_url}}/corretor/update/id
    {
    "nome": "Lucas",
    "email": "Lucas@imobiliaria.com",
    "telefone": "81 98534343"
    }
12. ### Deletando Todos os Corretores
    Deletando um Corretor Configure:DELETE:URL: {{base_url}}/corretor/delete/id

13. ### Lista Todos os Imóveis Configure:Método: GET
URL: {{base_url}}/imoveis
Clique em "Send".
Resposta esperada: Status 200 OK com a lista de imóveis (vazia se nenhum foi criado).

14. ### Criando um Imóvel
Crie uma nova requisição.
Configure:
Método: POST
URL: {{base_url}}/imoveis/create
No Body (JSON), insira:
#### Observação:Tipo de imóvel só aceita valores como "CASA" ou "APARTAMENTO" de forma maiúscula,caso não seja dessa forma apresentará uma mensagem de erro..

json
{
"tipo": "APARTAMENTO",
"bairro": "bomba do hemetério",
"descricao":"rua"
}

Clique em "Send".

Resposta esperada: Status 201 Created com os dados do imóvel.

15. ### Listando todos os Imóveis
Crie uma nova requisição.
Configure:Método:GET

16. ### Atualizando um Imóvel:
Configure:Método put:{{base_url}}/imoveis/update/{id}
    {
    "tipo": "CASA",
    "bairro": "bomba do hemetério",
    "descricao":"rua"
    }
17. ### Delete Imóvel por ID
    Crie uma nova requisição.
    Configure:
    Método: DELETE
    URL: {{base_url}}/imoveis/delete/{id} passando o ID que você deseja deletar.
Resposta esperada: Status 204 No Content.
18. ### Requisitos Obrigatórios para ter um Anúncio
Corretor Existente:

O corretor associado ao anúncio deve estar previamente cadastrado.

O campo corretor.id deve conter um ID válido (existente no banco de dados).

Imóvel Existente:

O imóvel a ser anunciado deve estar cadastrado no sistema.

O campo imovel.id deve referenciar um imóvel válido.

Regra adicional: Um imóvel só pode ter um anúncio ativo (não é possível criar múltiplos anúncios para o mesmo imóvel).

19. ### Como criar um Anúncio
Método POST:{{base_url}}/anuncios/create
{
"imovel": {
"id": 3  
},
"corretor": {
"id": 1  
}
}
20. ### Como Listar todos os Anúncios
Método GET:{{base_url}}/anuncios/create
21. ### Como atualizar um Anúncio
Método PUT:{{base_url}}/anuncios/update/id
22. ### Como Deletar um Anúncio
Método DELETE:{{base_url}}/anuncios/delete/id