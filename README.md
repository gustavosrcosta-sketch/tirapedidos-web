# Sistema Tira Pedidos Web

## 📌 Descrição
Sistema web desenvolvido em Java com Spring Boot para cadastro de clientes, produtos e realização de pedidos.

Projeto desenvolvido nas Etapas 7, 8 e 9 da UC15.

---

## 🛠 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Maven
- JPA / Hibernate
- MySQL
- HTML
- CSS
- JavaScript
- Git e GitHub

---

## 📂 Funcionalidades Implementadas

### ✔ Cadastro de Cliente
- Nome
- CPF/CNPJ
- Email
- Validação de campos obrigatórios

### ✔ Cadastro de Produto
- Nome
- Preço
- Validação de campos obrigatórios

### ✔ Novo Pedido
- Seleção de Cliente
- Seleção de Produto
- Cálculo automático do valor total
- Persistência no banco de dados

---

## 🔄 Integração Front-end e Back-end

O front-end foi integrado ao Spring Boot utilizando:
- Fetch API
- Endpoints REST
- Persistência com JPA

---

## 🐞 Correções Realizadas (Bugtracking)

- Correção erro 500 ao salvar pedido
- Ajuste de relacionamento entre Pedido e Produto
- Correção carregamento de CSS
- Ajuste cálculo automático do valor total

---

## 🚀 Como Executar o Projeto

1. Abrir o projeto no NetBeans
2. Configurar banco MySQL
3. Executar `Clean and Build`
4. Rodar aplicação
5. Acessar:http://localhost:8080/index.html


## 👨‍💻 Autor
Gustavo