package academy.learnprogramming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {
    // == fields ==
    private final Game game;

    // == constructor ==
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    // == init ==
    @PostConstruct
    public void init() {
        log.info("game = {}", game);
    }

    // == public mehtods ==
    @Override
    public String getMainMessage() {
        return "Number is between " + game.getSmallest() + " and " + game.getBiggest() +
                ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if (game.getRemainingGuesses() == game.getGuessCount()) {
            return "What is your first guess?";
        }
        if (!game.isValidNumberRange()) {
            return "Invalid number range!";
        }
        if (game.isGameWon()) {
            return "You guessed it! The number was " + game.getNumber();
        }
        if (game.isGameLost()) {
            return "You lost! The number was " + game.getNumber();
        }
        String direction = "Lower";
        if (game.getGuess() < game.getNumber()) {
            direction = "Higher";
        }
        return direction + "! You have " + game.getRemainingGuesses() + "guess left";
    }
}
