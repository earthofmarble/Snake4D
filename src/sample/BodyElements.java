package sample;

import java.util.ArrayList;

public class BodyElements {  //частички змееносца

    int posX;
    int posY;
    int previousElementsPosX;
    int previousElementsPosY;

    public static ArrayList<BodyElements> bodyElements = new ArrayList<>();

    public BodyElements(int posX, int posY, int previousElementsPosX, int previousElementsPosY){
        this.posX=posX;
        this.posY=posY;
        this.previousElementsPosX=previousElementsPosX;
        this.previousElementsPosY=previousElementsPosY;
    }

    public static void addBodyElement(){  //добавляем ячейку змеюги             //КОГДА ДОДЕЛАЛ, ПОНЯЛ, ЧТО НОВАЯ ЯЧЕЙКА ПОЯВИТСЯ ТОЛЬКО КОГДА ЗМЕЯ ПОХОДИТ, СООТВЕТСТВЕННО ЭТА ЯЧЕЙКА ПОЯВИТСЯ НА МЕСТЕ ГДЕ ТОЛЬКО ЧТО БЫЛА ПОСЛЕДНЯЯ ЯЧЕЙКА, ОЙ ЕЙ ЕЙ, ЗРЯ СТОЛЬКО ВСЕГО НАПИСАЛ, НУ НИЧЕГО БУДЕТ ЗАДЕЛ ПОД ЯГОДЫ, ИЛИ КАК ИХ НАЗВАТЬ, КОТОРЫЕ БУДУТ ДАВАТЬ БОЛЕЕ 1 ЕДИНИЦЫ ДЛИНЫ((
        int tempX=0;
        int tempY=0;
        if (bodyElements.size()>0){
            if (bodyElements.get(bodyElements.size()-1).getPreviousElementsPosX()>bodyElements.get(bodyElements.size()-1).getPosX()){
                tempX=bodyElements.get(bodyElements.size()-1).getPosX()-1;
                tempY=bodyElements.get(bodyElements.size()-1).getPosY();
//                System.out.println("Xold>Xnew");
            } else  if (bodyElements.get(bodyElements.size()-1).getPreviousElementsPosX()<bodyElements.get(bodyElements.size()-1).getPosX()){
                tempX=bodyElements.get(bodyElements.size()-1).getPosX()+1;
                tempY=bodyElements.get(bodyElements.size()-1).getPosY();

//                System.out.println("Xold<Xnew");
            } else  if (bodyElements.get(bodyElements.size()-1).getPreviousElementsPosY()>bodyElements.get(bodyElements.size()-1).getPosY()){
                tempX=bodyElements.get(bodyElements.size()-1).getPosX();
                tempY=bodyElements.get(bodyElements.size()-1).getPosY()-1;

//                System.out.println("Yold>Ynew");
            } else  if (bodyElements.get(bodyElements.size()-1).getPreviousElementsPosY()<bodyElements.get(bodyElements.size()-1).getPosY()){
                tempX=bodyElements.get(bodyElements.size()-1).getPosX();
                tempY=bodyElements.get(bodyElements.size()-1).getPosY()+1;

//                System.out.println("Yold<Ynew");
            }
            tempX=checkTemp(tempX);
            tempY=checkTemp(tempY);
            bodyElements.add(new BodyElements(tempX, tempY, bodyElements.get(bodyElements.size()-1).getPosX(), bodyElements.get(bodyElements.size()-1).getPosY()));
        } else {
            bodyElements.add(new BodyElements(Snake.snake.getPosX()+1, Snake.snake.getPosY(), Snake.snake.getPosX(), Snake.snake.getPosY()));
//            System.out.println("SnakeHeadOption");
        }

    }

    public static int checkTemp(int temp){          //!!будет работать неправильно, если массив(КАРТА, ДЛЯ ДУРАКОВ) будет не равносторонним!!! потому что для икса надо филдаррей[0].length
        if (temp>=Field.fieldArray.length){
            temp=0;
        } else
        if (temp<0){
            temp=Field.fieldArray.length-1;
        }
        return temp;
    }

    public static void moveBody() {         // шевелим змеёй, присваиваем каждой ячейке змеи положение предыдущей ячейки, чтоб потом переместить туда текущую
        if (bodyElements.size() > 0) {
            bodyElements.get(0).posX= bodyElements.get(0).previousElementsPosX;
            bodyElements.get(0).posY=bodyElements.get(0).previousElementsPosY;
            bodyElements.get(0).previousElementsPosX=Snake.snake.getPosX();
            bodyElements.get(0).previousElementsPosY=Snake.snake.getPosY();
            for (int i = 1; i < bodyElements.size(); i++){
                bodyElements.get(i).posX=bodyElements.get(i).previousElementsPosX;
                bodyElements.get(i).posY=bodyElements.get(i).previousElementsPosY;
                bodyElements.get(i).previousElementsPosX=bodyElements.get(i-1).getPosX();
                bodyElements.get(i).previousElementsPosY=bodyElements.get(i-1).getPosY();
            }
        }
    }

    public int getPreviousElementsPosX() {
        return previousElementsPosX;
    }

    public int getPreviousElementsPosY() {
        return previousElementsPosY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
