package codingame.locm;

import java.util.*;

abstract class Phase {
    protected Integer remainingTurns = 1;

    public Integer getRemainingTurns() {
        return remainingTurns;
    }
}

class Draft extends Phase {
    public Draft() {
        remainingTurns = 30;
    }

    /**
     * Selects the card player wants to add to deck.
     *
     * @param cardId the card index (i.e. 0 or 1 or 2)
     */
    public void pick(int cardId) {
        // TODO:
    }

    public void pass() {
        pick(0);
    }
}

class Battle extends Phase {
}

class Card {
}

class Creature {
}

class Deck {
    public static final Integer DECK_SIZE = 30;
    private List<Card> cards = new ArrayList<>(DECK_SIZE);

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card draw() {
        return cards.remove(0);
    }
}

class Player {
    private Deck deck = new Deck();
    private List<Card> cardsInHand = new ArrayList<>();

    public Player(int countOfCardsInHandToStart) {
        for (int i = 0; i < countOfCardsInHandToStart; i++) {
            draw();
        }
    }

    public void draw() {
        cardsInHand.add(deck.draw());
    }
}

public class CodeAndMagicGame {
    public static void main(String[] args) {
        Player player1 = new Player(4);
        Player player2 = new Player(5);
    }
}
