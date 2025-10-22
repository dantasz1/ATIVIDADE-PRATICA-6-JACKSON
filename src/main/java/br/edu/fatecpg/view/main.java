package br.edu.fatecpg.view;

import br.edu.fatecpg.model.Email;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();


        JsonNode rootNode = mapper.readTree(new URL("https://jsonplaceholder.typicode.com/comments"));
        JsonNode testeEmail = rootNode.get(1);
        String email = testeEmail.get("email").asText();
        System.out.println("Email do segundo comentário: " + email);


        List<Email> emails = mapper.readValue(
                new URL("https://jsonplaceholder.typicode.com/comments"),
                new TypeReference<List<Email>>() {}
        );


        for (Email e : emails) {
            System.out.println(e.getEmail());
        }
        // Pega cada item do JSON
        for (JsonNode node : rootNode) {
            String name = node.get("name").asText();
            String email = node.get("email").asText();
            String body = node.get("body").asText();
            emails.add(new Email(name, email, body));
        }
    }
    
}
