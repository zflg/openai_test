package com.yanqi.openai_test;

import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.service.OpenAiService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OpenaiTestApplicationTests {

  @Test
  void contextLoads() {

    OpenAiService service = new OpenAiService("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");
    CompletionRequest completionRequest = CompletionRequest.builder()
        .prompt("Suggest three names for an animal that is a superhero.\n"
            + "\n"
            + "Animal: Cat\n"
            + "Names: Captain Sharpclaw, Agent Fluffball, The Incredible Feline\n"
            + "Animal: Dog\n"
            + "Names: Ruff the Protector, Wonder Canine, Sir Barks-a-Lot\n"
            + "Animal: Horse\n"
            + "Names:")
        .model("text-davinci-003")
        .temperature(0.6)
        .build();
    CompletionResult completion = service.createCompletion(completionRequest);
    completion.getChoices().forEach(choice -> System.out.println(choice.getText()));
  }

}
