package br.com.alura.ecomerce;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;

import java.time.Duration;
import java.util.Arrays;

public class CatecorizadorDeProdutos {

    public static void main(String[] args) {
        var user = "Caterizador de Produtos";
        var system = "Escova de Dentes";

        var chave = System.getenv("OPENAI_API_KEY");
        var service = new OpenAiService(chave, Duration.ofSeconds(30));

        Integer n;
        var completionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-4")
                .messages(Arrays.asList(
                        new ChatMessage(ChatMessageRole.USER.value(), user),
                        new ChatMessage(ChatMessageRole.SYSTEM.value(), system)
                ))
                .n(n:5)
                .build();

        service
                .createChatCompletion(completionRequest)
                .getChoices()
                .forEach(c -> { 
                    System.out.print(c.getMessage().getContent());
                    System.out.println("\n--------\n");
                
                });
    }

}