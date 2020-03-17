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

    public void checkBorders(SnakeSection head) {
        if(head.getX()>=Room.game.getWidth()){
            isAlive =false;
        }
        if(head.getY()>=Room.game.getHeight()){
            isAlive =false;
        }
        if(head.getX()<0){
            isAlive =false;
        }
        if(head.getY()<0){
            isAlive =false;
        }

    }

    public void checkBody(SnakeSection head) {
        if (sections.contains(head)) {
            isAlive = false;
        }
    }


    public void move(int x, int y){
        SnakeSection head = new SnakeSection(this.getX() + x,this.getY() + y);
        checkBorders(head);
        checkBody(head);
        sections.add(0, head);

        if (head.getX() == Room.game.getMouse().getX() && head.getY() == Room.game.getMouse().getY()) {
            Room.game.eatMouse();
        } else {
            sections.remove(sections.size() - 1);
        }

    }
        public int getX(){
            return this.sections.get(0).getX();
        }

        public int getY(){
            return this.sections.get(0).getY();
         }
}
