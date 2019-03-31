package sample;

import java.io.IOException;
import java.util.ArrayList;

public class Snake {

    int posX;
    int posY;
    int length;
    boolean isAlive;

    public static Snake snake;

    public Snake(int posX, int posY, int length, boolean isAlive){
        this.length=length;
        this.isAlive=isAlive;
        this.posX=posX;
        this.posY=posY;
    }

    public static void createSnake(int posX, int posY, int length, boolean isAlive){       //создаем змеюгу
        snake = new Snake(posX, posY, length, isAlive);
        for (int i=0; i<length; i++){
            BodyElements.addBodyElement();
        }
        Field.fillField();
        Field.printField();
    }


    public static void moveSnake(Direction direction){

        //сюда вставить очистку консоли, но: IntelliJ IDEA console is not a real terminal, so there is no command to clear it from your Java code.

        if (snake.isAlive) {
           int newX=direction.getNewXId(snake.getPosX());
           int newY=direction.getNewYId(snake.getPosY());
            if (!BodyElements.bodyElements.isEmpty()) {
                if (direction.getNewXId(snake.getPosX()) == BodyElements.bodyElements.get(0).getPosX() && direction.getNewYId(snake.getPosY()) == BodyElements.bodyElements.get(0).getPosY()) {
                    return;
                }

                BodyElements.bodyElements.forEach(element -> {
                    if (element.getPosX() == direction.getNewXId(snake.getPosX()) && element.getPosY() == direction.getNewYId(snake.getPosY())) {
                        snake.isAlive = false;
                        snake.posX=direction.getNewXId(snake.getPosX());
                        snake.posY=direction.getNewYId(snake.getPosY());
                        System.out.println("GAME OVER");
                        Field.printField();
                        Controller.move.stop();
                        return;
                    }
                });

            }

         ArrayList<Obstacle> junk = new ArrayList<>();
           if (newX>=Field.fieldArray[0].length){
               newX=0;
           }
           if (newX<0){
               newX=Field.fieldArray[0].length-1;
           }
           if (newY>=Field.fieldArray.length){
               newY=0;
           }
           if (newX<0){
               newY=Field.fieldArray.length-1;
           }
           Obstacle newObjectBuf = new Obstacle(newX, newY);        //ПЕРЕМЕННАЯ В ЛЯМБДЕ ДОЛЖНА БЫТЬ ФИНАЛ ЛИБО ТИПА ПОЧТИ ФИНАЛ ИЛИ КАК ТАМ ГОВОРЯТ, НЕ ПОМНЮ

            Obstacle.obstaclesArrayList.forEach(obstacle -> {

                if (obstacle.getPosX()==newObjectBuf.getPosX()&&obstacle.getPosY()==newObjectBuf.getPosY()){
                   junk.add(obstacle);
                   BodyElements.addBodyElement();
                }
            });
            junk.forEach(obstacle -> {
                Obstacle.obstaclesArrayList.remove(obstacle);
            });

            if (direction.getNewXId(snake.getPosX()) < Field.fieldArray[0].length && direction.getNewXId(snake.getPosX()) >= 0) {
                snake.posX = direction.getNewXId(snake.getPosX());
            } else if (direction.getNewXId(snake.getPosX()) >= Field.fieldArray[0].length) {
                snake.posX = 0;
            } else if (direction.getNewXId(snake.getPosX()) < 0) {
                snake.posX = Field.fieldArray.length - 1;
            }
            if (direction.getNewYId(snake.getPosY()) < Field.fieldArray.length && direction.getNewYId(snake.getPosY()) >= 0) {
                snake.posY = direction.getNewYId(snake.getPosY());
            } else if (direction.getNewYId(snake.getPosY()) >= Field.fieldArray.length) {
                snake.posY = 0;
            } else if (direction.getNewYId(snake.getPosY()) < 0) {
                snake.posY = Field.fieldArray.length - 1;
            }
            BodyElements.moveBody();
            Field.fillField();
            Field.printField();
        } else
        System.out.println("GAME OVER");

    }

    public int getPosY() {
        return posY;
    }

    public int getPosX() {
        return posX;
    }
}
