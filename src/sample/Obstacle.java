package sample;

import java.util.ArrayList;

public class Obstacle {

    int posX; int posY;
    static ArrayList<Obstacle> obstaclesArrayList = new ArrayList<>();

    public Obstacle(int posX, int posY){
        this.posX=posX;
        this.posY=posY;
    }

    public static void addObstacle(Obstacle obstacle){
        obstaclesArrayList.add(obstacle);
    }


    public static void createObstacles(int count){
        while (count>0) {
            int randomX = 0 + (int) (Math.random() * Field.fieldArray.length - 1);          //вроде они не спавнятся в самый правый столбик, черт его знает
            int randomY = 0 + (int) (Math.random() * Field.fieldArray[0].length - 1);       //потом посмотрим

            if (canBePlaced(randomX, randomY)) {
                addObstacle(new Obstacle(randomX, randomY));
                count--;
            }
        }


    }


    public static boolean canBePlaced(int rX, int rY){
        boolean temp=true;
      for (int i=0; i<obstaclesArrayList.size(); i++){
          if (obstaclesArrayList.get(i).getPosX()==rX && obstaclesArrayList.get(i).getPosY()==rY){
              temp=false;
             return false;
          }
      }

      for (int i=0; i<BodyElements.bodyElements.size(); i++){
          if (BodyElements.bodyElements.get(i).getPosX()==rX && BodyElements.bodyElements.get(i).getPosY()==rY){
              temp=false;
              return false;
          }
      }

        if (Snake.snake.getPosX()==rX && Snake.snake.getPosY()==rY){
            temp=false;
            return false;
        }

        return temp;
    }


    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}

