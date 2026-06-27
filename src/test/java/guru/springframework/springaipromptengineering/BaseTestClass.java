package guru.springframework.springaipromptengineering;

import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

/**
 * Created by jt, Spring Framework Guru.
 */
@SpringBootTest
public class BaseTestClass {

    @Autowired
    ChatModel chatModel;

    String chat(String prompt) {
        PromptTemplate promptTemplate = new PromptTemplate(prompt);
        Prompt promptToSend = promptTemplate.create();

        return chatModel.call(promptToSend).getResult().getOutput().getText();
    }

    String chat(String prompt, Map<String, Object> variables) {
        PromptTemplate promptTemplate = new PromptTemplate(prompt);
        Prompt promptToSend = promptTemplate.create(variables);

        return chatModel.call(promptToSend).getResult().getOutput().getText();
    }

    String chat(String prompt, Map<String, Object> variables, OpenAiChatOptions openAiChatOptions) {
        PromptTemplate promptTemplate = new PromptTemplate(prompt);
        Message message = promptTemplate.createMessage(variables);
        Prompt promptToSend = new Prompt(message, openAiChatOptions);

        return chatModel.call(promptToSend).getResult().getOutput().getText();
    }

}
