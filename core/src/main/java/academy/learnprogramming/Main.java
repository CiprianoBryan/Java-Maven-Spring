package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        // Create context (container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // get number generator bean from context (container)
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        // call method next() to get a random number
        int number = numberGenerator.next();
        log.info("number = {}", number);

        // get message generator bean from context (container)
        MessageGenerator message = context.getBean(MessageGenerator.class);
        log.info("getMainMessage = {}", message.getMainMessage());
        log.info("getResultMessage = {}", message.getResultMessage());

        // close context (container)
        context.close();
    }
}