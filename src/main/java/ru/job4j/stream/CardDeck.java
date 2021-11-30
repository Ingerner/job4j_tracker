package ru.job4j.stream;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardDeck {

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(
                        s -> Stream.of(Value.values())
                                .map(v -> new Card(s, v)))
                .forEach(System.out::println);
    }

    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        V_6, V_7, V_8
    }

    public static class Card {

        private Suit suit;
        private Value value;

        public Card(Suit suit, Value value) {
            this.suit = suit;
            this.value = value;
        }

        public Suit getSuit() {
            return suit;
        }

        public Value getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Card card = (Card) o;
            return suit == card.suit && value == card.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(suit, value);
        }

        @Override
        public String toString() {
            return "Card{" +
                    "suit=" + suit +
                    ", value=" + value +
                    '}';
        }
    }

}