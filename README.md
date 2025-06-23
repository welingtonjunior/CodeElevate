# 📚 Catálogo do Sábio (Code Elevate)

**Catálogo do Sábio** é uma API RESTful desenvolvida em Java com Spring Boot, parte do desafio técnico do processo **Code Elevate**. O sistema gerencia livros com operações CRUD, usando banco H2 em memória, cache com Redis e documentação automática via Swagger.

---
## 🏛️ Arquitetura de Solução e Arquitetura Técnica
O projeto adota a **Arquitetura Hexagonal (Ports & Adapters)** para facilitar a testabilidade, manutenção e flexibilidade tecnológica.
O domínio da aplicação é isolado de detalhes de infraestrutura, permitindo fácil adaptação para diferentes bancos de dados ou camadas externas.

### ⚙️ Escolhas Técnicas
- **Spring Boot:** Framework robusto para desenvolvimento de APIs REST.
- **H2 Database:** Banco de dados em memória, ideal para testes e desenvolvimento local.
- **Redis:** Armazenamento em cache para acelerar consultas frequentes.
- **Swagger (Springdoc OpenAPI):** Documentação automática dos endpoints.
- **Docker:** Containerização e padronização do ambiente de execução.

**Diagrama simplificado:**

```
[REST Controller]
       |
       v
[BookUseCase Port] <---> [BookService - Domínio]
       |
       v
[BookRepositoryPort]      [CachePort]
       |                        |
       v                        v
[BookRepository Adapter] [Redis Adapter]
       |                        |
       v                        v
     [H2 DB]                  [Redis]      
```

---

## Explicação sobre o Case Desenvolvido (Plano de Implementação)

A API permite a busca de dados sobre livros, com busca por gênero e autor.
O fluxo principal é:
1. O Controller expõe os endpoints REST.
2. O Service (no domínio) executa a lógica de negócio.
3. Os Ports definem contratos para repositórios e cache.
4. Adapters implementam esses contratos usando Spring Data JPA (H2) e Redis.

**Entidade principal:**
- **Book:** id, título, autor, gênero, descrição, ano, etc.

**Aquisição de Dados:**
- A base de dados é automaticamente populada no início da aplicação com 200 livros fictícios, gerados autores, gêneros e demais informações realistas.

**Paginação e Cache:**
- Todas as requisições dos endpoints de livros utilizam cache via Redis, acelerando a resposta para consulta banco de dados. As respostas podem ser paginadas conforme necessário.

**Tratamento de Erros:**
- Erros tratados com mensagens informativas e códigos HTTP adequados (ex: 404 para não encontrado).

**Testes:**
- Cobertura de testes unitários em serviços e integração de endpoints, utilizando JUnit e Mockito.

---



## Reprodutibilidade
Todo o ambiente pode ser iniciado com um simples "docker-compose up --build.
Para customização de portas ou variáveis, edite o arquivo *docker-compose.ym]*.
A documentação Swagger está disponível em
*/swagger-ui.html após o deploy.

## 🛠️ Tecnologias

- ✅ Java 17+
- ✅ Spring Boot 3.5.3
- ✅ Spring Data JPA + H2 Database
- ✅ Spring Cache + Redis
- ✅ Springdoc OpenAPI + Swagger UI
- ✅ JUnit + Mockito
- ✅ Docker & Docker Compose

---

## 🚀 Como rodar localmente (sem Docker)

1. Clone este repositório:

```bash
git clone https://github.com/welingtonjunior/CodeElevate.git
cd CodeElevate
```

## 🐳 Como rodar com Docker
1. Build e run

```bash
docker build -t catalogodosabio .
docker run -p 8080:8080 catalogodosabio
```

## 🧱 Como rodar com Docker Compose (API + Redis)
1. Comando único:
```bash
docker-compose up --build
```
A aplicação estará disponível em: http://localhost:8080/swagger-ui.html

## 🔗 Endpoints principais
### Método	Endpoint	Descrição
- GET	/books	Lista livros (com paginação)
- GET	/books/{id}	Busca livro por ID
- GET	/books/genre/{g}	Lista livros por gênero
- GET	/books/author/{a}	Lista livros por autor

## 🛠️ Testes
Execute os testes com:

```bash

./mvnw test
```

## Melhorias e Considerações Finais
**Possíveis melhorias:**
- Autenticação e autorização (JNT, OAuth) 
- Persistência em banco relacional externo (PostgresQL, MysQL).
- Integração com APIs públicas de livros (OpenLibrary).
- Deploy automatizado (CI/CD).
- Monitoramento e métricas.
- Testes End-to-End automatizados.

**Desafios e limitações:**
- Integração do cache com dados dinâmicos.
- Limitações do banco H2 para grandes volumes de dados.
- Decisão por mock de dados vs. ingestão real de datasets.
---