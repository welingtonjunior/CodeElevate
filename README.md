# 📚 Catálogo do Sábio (Code Elevate)

**Catálogo do Sábio** é uma API RESTful desenvolvida em Java com Spring Boot, parte do desafio técnico do processo **Code Elevate**. O sistema gerencia livros com operações CRUD, usando banco H2 em memória, cache com Redis e documentação automática via Swagger.

---
## 🏛️ Arquitetura Hexagonal (Ports & Adapters)
O projeto utiliza a **Arquitetura Hexagonal** (também conhecida como Ports & Adapters), que propõe uma separação clara entre a lógica de negócios (core/domínio) e os detalhes de infraestrutura (como banco de dados, web, cache, etc).
Essa abordagem facilita testes, manutenções e possíveis trocas de tecnologias sem impactar o núcleo da aplicação.
- **Camada de Domínio/Core**: Onde ficam as regras de negócio e modelos do sistema.
- **Ports**: Interfaces que definem contratos para entrada (driving, ex: controllers REST) e saída (driven, ex: repositórios, cache).
- **Adapters**: Implementações concretas das interfaces, conectando o domínio à infraestrutura (ex: adaptador do repositório JPA, serviço Redis,
REST Controller).
Assim, a API REST, o acesso ao banco (H2/JPA), o cache (Redis), e até a documentação (Swagger) são plugáveis, mantendo o domínio isolado e testável.

```
Camada de Aplicação (Core) <--> Ports <--› Adapters (Web, Banco, Cache, etc)
```
---

## 🔎 Visão Geral

- 🔄 CRUD completo de **livros**
- 🧠 **Cache com Redis** para melhorar performance
- 🧪 Banco de dados **H2 em memória** (ideal para testes)
- 📑 Documentação via **Swagger / OpenAPI**
- ⚙️ Projeto pronto para rodar localmente ou com **Docker**

---

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