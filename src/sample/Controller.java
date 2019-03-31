package sample;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonUp;

    @FXML
    private Button buttonLeft;

    @FXML
    private Button buttonRight;

    @FXML
    private Button buttonDown;
    public static Thread move;
    public static final AtomicBoolean running = new AtomicBoolean(false);
    @FXML
        void initialize() {
        Runnable first = new MyThread(Direction.NORTH);             //однажды я научусь думать головой и обходить такие ситуации
        move =  new Thread(first);
      //  move.start();

        Field.createField(new Field(10,10));
        Snake.createSnake(2,1, 3, true);

    buttonRight.setOnAction(event -> {

        start(Direction.EAST);
//        Runnable r = new MyThread(Direction.EAST);
//        move.stop();
//        move =  new Thread(r);
//        running.set(true);
//        move.start();

           //   Snake.moveSnake(Direction.EAST);
    });

    buttonUp.setOnAction(event -> {
        start(Direction.NORTH);
//        Runnable r = new MyThread(Direction.NORTH);
//        move.stop();
//       move =  new Thread(r);
//        running.set(true);
//       move.start();

          //   Snake.moveSnake(Direction.NORTH);
    });

    buttonLeft.setOnAction(event -> {
        start(Direction.WEST);
//        Runnable r = new MyThread(Direction.WEST);
//        move.stop();
//        move =  new Thread(r);
//        running.set(true);
//        move.start();
//        Snake.moveSnake(Direction.WEST);
    });

    buttonDown.setOnAction(event -> {
        start(Direction.SOUTH);
//        Runnable r = new MyThread(Direction.SOUTH);
//        move.stop();
//        move =  new Thread(r);
//        running.set(true);
//        move.start();
     //   Snake.moveSnake(Direction.SOUTH);
    });

    }


    public void start(Direction direction) {
        if (Snake.snake.isAlive) {
            Runnable r = new MyThread(direction);
            move.stop();            //ХОТЕЛОСЬ БЫ ИНАЧЕ, НО, ВИДИМО, НЕ СУДЬБА
            move = new Thread(r);
            running.set(true);
            move.start();
        } else System.out.println("ВСЁ, ДОИГРАЛСЯ");

    }

}
