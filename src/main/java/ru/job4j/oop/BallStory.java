package ru.job4j.oop;
//история колобка
public class BallStory {
    public static void main(String[] args) {
        BallStory ball = new BallStory();
        Hare here = new Hare();
        WolfK wolfK = new WolfK();
        Fox fox = new Fox();
        here.tryEat(ball);
        wolfK.tryEat(ball);
        fox.tryEat(ball);
    }

}
