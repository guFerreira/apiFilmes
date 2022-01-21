# Api Filmes

Aplicação desenvolvida com a linguagem Java e o framework Spring Boot.

É um sistema para gerenciar filmes e suas avaliações, sendo possível fazer as seguintes ações com os filmes: 
Adicionar, Atualizar, Listar, Deletar, Avaliar e Recomendar filmes que ainda não foram avaliados.

## Tabela com as URLs da aplicação

| Fuincionalidades da API | Tipo | URL |
| ---    | ---       | --- |
| Avaliar Filme | POST |  http://localhost:8080/avaliacao/filme |
| Criar Filme | POST |  http://localhost:8080/filmes |
| Atualizar Filme  | PUT  |  http://localhost:8080/filmes/{id} |
| Deletar Filme |  DELETE  |   http://localhost:8080/filmes/{id} |
| Exibir Todos os Filmes   | GET| http://localhost:8080/filmes |
| Exibir Filmes por Id  | GET |  http://localhost:8080/filmes/{id}  |
| Indicar Filme sem Avaliação  | GET       |  http://localhost:8080/filmes/recomendacao |
| Exibir todos os Filme sem Avaliação  | GET       |   http://localhost:8080/filmes/sem-avaliacao   |
