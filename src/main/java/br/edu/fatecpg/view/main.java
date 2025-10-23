package br.edu.fatecpg.view;

import br.edu.fatecpg.model.Email;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode rootNode = mapper.readTree(new URL("https://jsonplaceholder.typicode.com/comments"));
        String primeiroEmail = rootNode.get(0).get("email").asText();
        System.out.println("Primeiro email: " + primeiroEmail);

        List<Email> emails = mapper.readValue(
                new URL("https://jsonplaceholder.typicode.com/comments"),
                new TypeReference<List<Email>>() {}
        );

        // Mostra todos os e-mails
        for (Email e : emails) {
            System.out.println(e.getEmail());
        }

        // Regex corrigida
        Pattern pattern = Pattern.compile("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");

        // Adiciona um e-mail inválido para testar
        emails.add(new Email("Teste3", "teste@dominio", "comentário"));

        // Lista de e-mails válidos
        List<String> emailsValidos = emails.stream()
                .map(Email::getEmail)
                .filter(e -> pattern.matcher(e).matches())
                .collect(Collectors.toList());

        // Lista de e-mails inválidos
        List<String> emailsInvalidos = emails.stream()
                .map(Email::getEmail)
                .filter(e -> !pattern.matcher(e).matches())
                .collect(Collectors.toList());

        // Exibir resultados
        System.out.println("\nTotal de e-mails: " + emails.size());
        System.out.println("Válidos: " + emailsValidos.size());
        System.out.println("Inválidos: " + emailsInvalidos.size());

        System.out.println("\n--- E-mails válidos ---");
        emailsValidos.forEach(System.out::println);

        System.out.println("\n--- E-mails inválidos ---");
        emailsInvalidos.forEach(System.out::println);
    }
}
