package com.javarush.task.task23.task2312;

public class Room {

    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;
    public static Room game;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Snake getSnake() {
        return snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
    }

    public void run(){}

    public void print(){}

    public static void main(String[] args){
        Snake snake = new Snake(0, 0);
        game = new Room(300, 300, snake);
        snake.setDirection(SnakeDirection.DOWN);

    }
}