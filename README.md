# 📚 Catálogo do Sábio (Code Elevate)

**Catálogo do Sábio** é uma API RESTful desenvolvida em Java com Spring Boot, parte do desafio técnico do processo **Code Elevate**. O sistema gerencia livros com operações CRUD, usando banco H2 em memória, cache com Redis e documentação automática via Swagger.

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