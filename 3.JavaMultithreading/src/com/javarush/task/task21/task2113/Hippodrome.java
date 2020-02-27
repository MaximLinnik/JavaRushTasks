package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;
    static public Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void move(){
        for (int i = 0; i< 3; i++) {
            horses.get(i).move();
        }
    }

    public void print(){
        for (Horse horse : getHorses()) {
            horse.print();

        }
        for(int i = 0; i < 10; i++) {
            System.out.println();

        }
    }

    public void run() throws InterruptedException {
        for(int i = 0; i< 100; i++){
            move();
            print();
            Thread.sleep(200);
        }
    }

    public Horse getWinner(){
        Horse winner = getHorses().get(0);
        for (int i = 0; i <getHorses().size()-1; i++) {
            if(getHorses().get(i).getDistance()>getHorses().get(i+1).getDistance())
                winner = getHorses().get(i);
            else winner = getHorses().get(i+1);
        }
        return winner;
    }

    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");
    }

    public static void main(String[] args){
        List<Horse> list = new ArrayList<Horse>();
        game = new Hippodrome(list);
        game.getHorses().add(new Horse("Horse1", 3, 0));
        game.getHorses().add(new Horse("Horse2", 3, 0));
        game.getHorses().add(new Horse("Horse3", 3, 0));
        try {
            game.run();
            game.printWinner();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
