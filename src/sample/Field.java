package sample;

public class Field {

    int sizeX; int sizeY;
    public static String[][] fieldArray;

    public Field(int sizeX, int sizeY){
        this.sizeY=sizeY;
        this.sizeX=sizeX;
    }

    public static void createField(Field field){           //создает поле и заполняет звёздочками, или чем-нибудь пустым
        fieldArray=new String[field.getSizeX()][field.getSizeY()];
        System.out.println("Массив создан");
        for (int i=0; i<fieldArray.length; i++){
            for (int j=0; j<fieldArray[i].length; j++){
                fieldArray[i][j]="*";  // ПОТОМ ЗАМЕНИТЬ НА ПРОБЕЛ
            }
        }

        System.out.println("Поле создано, поле: ");
        printField();
    }

    public static void fillField(){
        for (int i=0; i<fieldArray.length; i++){
            for (int j=0; j<fieldArray[i].length; j++){
                fieldArray[i][j]="*";  // ПОТОМ ЗАМЕНИТЬ НА ПРОБЕЛ
            }
        }
        fieldArray[Snake.snake.getPosX()][Snake.snake.getPosY()]="Г";
        BodyElements.bodyElements.forEach(element ->{
            fieldArray[element.getPosX()][element.getPosY()]="Х";
        });

        if (Obstacle.obstaclesArrayList.size()<5){              //если точек с едой <5 создаем новые, кажется, это стоит написать в другой метод, но пускай пока побудет тут
            Obstacle.createObstacles(5-Obstacle.obstaclesArrayList.size());
        }

        Obstacle.obstaclesArrayList.forEach(obstacle -> {
            fieldArray[obstacle.getPosX()][obstacle.getPosY()]="E";
        });
    }

    public static void printField(){            //выводит поле в консоль
        System.out.println();
        System.out.println();
        for (int i=0; i<fieldArray.length; i++){
            for (int j=0; j<fieldArray[i].length; j++){
                System.out.print(fieldArray[i][j]+"\t");
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }


    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }
}
