package sample;

public class MyThread implements Runnable {

    private Direction direction;// параметр
    public MyThread(Direction direction) {      // через конструтор передадим параметр
        // передаём в конструктор все параметры, которые могут пигодится потоку
        this.direction=direction; // сохраняем параметры как поля
    }

    public void run() {
        while (Controller.running.get()) {
            Snake.moveSnake(direction);
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}