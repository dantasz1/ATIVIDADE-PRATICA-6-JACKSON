# 📧 Validação de E-mails com API JSONPlaceholder

## 🧩 Sobre o projeto

Este projeto em **Java** tem como objetivo **consumir uma API pública** de comentários (JSONPlaceholder), **extrair e validar e-mails** utilizando **regex (Pattern)**, **streams**, e **filtros funcionais**.

O código demonstra o uso integrado de conceitos modernos de **processamento de JSON**, **programação funcional** e **validação de dados**.

---

## 🚀 Funcionalidades

- 🔗 Consome dados da API: [https://jsonplaceholder.typicode.com/comments](https://jsonplaceholder.typicode.com/comments)  
- 📦 Faz o **mapeamento automático** de JSON para objetos Java (`Email`) com **ObjectMapper**.  
- 🔍 Extrai os e-mails de todos os comentários retornados.  
- 🧪 Valida os e-mails usando **expressões regulares (Regex)** com a classe **Pattern**.  
- 🔄 Usa **Stream API** e **filter** para separar e-mails **válidos** e **inválidos**.  
- 🧾 Exibe relatórios no console com:
  - Total de e-mails processados  
  - Quantidade de válidos e inválidos  
  - Listagem de cada grupo separadamente  

---

## 🧠 Conceitos e Tecnologias Utilizadas

### 📘 **ObjectMapper (Jackson Library)**
- Classe da biblioteca **Jackson** usada para **converter JSON em objetos Java** e vice-versa.  
- Permite trabalhar facilmente com dados vindos de APIs REST.
```java
ObjectMapper mapper = new ObjectMapper();
List<Email> emails = mapper.readValue(
    new URL("https://jsonplaceholder.typicode.com/comments"),
    new TypeReference<List<Email>>() {}
);

