package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {
         private List<SnakeSection> sections;
         private boolean isAlive;
         private SnakeDirection direction;

        public List<SnakeSection> getSections() {
                return sections;
        }

        public boolean isAlive() {
                return isAlive;
        }

        public SnakeDirection getDirection() {
                return direction;
        }

        public void setDirection(SnakeDirection direction) {
                this.direction = direction;
        }

        public Snake(int x, int y){
            this.sections = new ArrayList<SnakeSection>();
            this.sections.add(new SnakeSection(x, y));
            this.isAlive = true;
        }

        public void move() {
            if (!isAlive) return;
            if (direction == SnakeDirection.UP)
                move(0, -1);
            else if (direction == SnakeDirection.RIGHT)
                move(1, 0);
            else if (direction == SnakeDirection.DOWN)
                move(0, 1);
            else if (direction == SnakeDirection.LEFT)
                move(-1, 0);
    }

    public void move(int x, int y){}

        public int getX(){
            return this.sections.get(0).getX();
        }

        public int getY(){
            return this.sections.get(0).getY();
         }
}
