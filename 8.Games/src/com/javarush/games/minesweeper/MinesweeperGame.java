package com.javarush.games.minesweeper;
import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {

    private static final int SIDE = 10;
    private int countClosedTiles = SIDE*SIDE;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private GameObject [][]gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private int countFlags;
    private boolean isGameStopped;
    private int score;


    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }
    private void createGame(){
        for (int i = 0;i < SIDE;i++) {
            for (int j = 0; j < SIDE; j++) {
                boolean random = false;
                if (getRandomNumber(10) == 1) {
                    random = true;
                    countMinesOnField++;
                }
                this.gameField[j][i] = new GameObject(i, j, random);
                setCellColor(i, j, Color.AQUAMARINE);
                setCellValue(i, j, "");
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
        //isGameStopped = false;
    }

    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.BLACK,"YOU WIN", Color.AZURE, 50);
    }

    private void gameOver(){
        isGameStopped = true;
        showMessageDialog(Color.BLACK,"GAME OVER", Color.AZURE, 50);
    }

    private void restart(){
        isGameStopped = false;
        countClosedTiles = SIDE*SIDE; countFlags = 0; score = 0; countMinesOnField = 0;
        setScore(score);
        createGame();
    }

    private List<GameObject> getNeighbors(GameObject obj){
        List<GameObject> result = new ArrayList<GameObject>();
        int x = obj.x;
        int y = obj.y;
        for(int j = y-1; j<=(y+1);j++){
            for(int i =x-1; i<=(x+1);i++){
                if((i>=0 && j>=0 && i <SIDE && j<SIDE )&&(i!=x || j!=y))
                    result.add(gameField[j][i]);
            }
        }
        return result;
    }

    private void countMineNeighbors(){
        for(int i = 0; i<SIDE; i++){
            for(int j = 0; j<SIDE; j++){
                if(!gameField[j][i].isMine){
                    int count = 0;
                    for(GameObject list: getNeighbors(gameField[j][i])){
                        if(list.isMine)
                            count++;
                    }
                    gameField[j][i].countMineNeighbors = count;
                }
            }
        }
    }

    private void openTile(int x, int y){
        if(isGameStopped == true)
            return;
        if(gameField[y][x].isOpen == true)
            return;
        if(gameField[y][x].isFlag == true)
            return;

        gameField[y][x].isOpen = true;
        if(gameField[y][x].isOpen == true && !gameField[y][x].isMine){
            score+=5;
            setScore(score);
        }
        countClosedTiles--;
        setCellColor(x, y, Color.WHITE);
        if(gameField[y][x].isMine){
            setCellValue(x, y, MINE);
            setCellValueEx(x,y,Color.RED, MINE);
            gameOver();
        }
        else {
            setCellNumber(x, y, gameField[y][x].countMineNeighbors);
            if (gameField[y][x].countMineNeighbors == 0){
                setCellValue(x,y, "");
                for(GameObject list:getNeighbors(gameField[y][x])){
                    if(!list.isOpen){
                        openTile(list.x, list.y);
                        /*
                        для вывода области пустых клеток
                         */
                    }
                }
                if(countClosedTiles==countMinesOnField)
                    win();
            }
        }
    }

    private void markTile(int x, int y){
        if(gameField[y][x].isOpen == true){
            return;
        }
        else if(gameField[y][x].isFlag == false && countFlags == 0){
            return;
        }
        else if(gameField[y][x].isFlag == false){
            gameField[y][x].isFlag = true;
            countFlags--;
            setCellValue(x, y ,FLAG);
            setCellColor(x, y, Color.AQUA);
        }
        else if(gameField[y][x].isFlag == true){
            gameField[y][x].isFlag = false;
            countFlags++;
            setCellValue(x, y, "");
            setCellColor(x, y, Color.AQUAMARINE);
        }
    }

    @Override
    public void onMouseLeftClick(int x, int y){
        if(isGameStopped)
            restart();
        else
            openTile(x, y);
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }
}
