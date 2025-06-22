# 📚 Catálogo do Sábio (CodeElevate)

**Catálogo do Sábio** é uma API RESTful desenvolvida em Java com Spring Boot, parte da etapa de code challenge do processo **CodeELevate**. Implementa um sistema de gerenciamento de livros usando banco de dados H2 em memória, incluindo cache, documentação via Swagger e console H2.

---

## 🔎 Visão Geral

- Gerencia **livros** com operações CRUD.
- Usa banco **H2 em memória** para testes rápidos sem configuração de BD externo.
- Integração com **cache local** para melhorar performance.
- Documentação automática de API via **Swagger / OpenAPI**.
- Configuração leve, pensada para entregar o mínimo viável de API funcional.

---

## 🛠️ Tecnologias

- ✅ **Java 17+**
- ✅ **Spring Boot**
- ✅ **Spring Data JPA**, H2 database
- ✅ **Spring Cache**
- ✅ **Springdoc OpenAPI + Swagger UI**
- ✅ **JUnit & Mockito** (teste automatizados)

---

## 🚀 Como rodar localmente

1. Clone este repositório (já feito 😊):

```bash
git clone https://github.com/welingtonjunior/CodeElevate.git
cd CodeElevate
