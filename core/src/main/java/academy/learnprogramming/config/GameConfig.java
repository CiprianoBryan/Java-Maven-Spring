package academy.learnprogramming.config;

import academy.learnprogramming.GuessCount;
import academy.learnprogramming.MaxNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {
    // == fields ==
    private int maxNumber = 50;
    private int guessCount = 8;

    // == bean methods ==
    @Bean
    @MaxNumber
    public int maxNumber_changeName() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount1() {
        return guessCount;
    }
}
