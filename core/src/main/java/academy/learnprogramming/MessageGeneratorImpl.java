package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {
    // == constant ==
    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    // == fields ==
    @Autowired
    private Game game;
    private int guessCount = 10;

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
        if (game.getRemainingGuesses() == guessCount) {
            return "What is your first guess";
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
