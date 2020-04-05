import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;// переменные для определения вида и места окна
    private static final int POS_Y = 200;// переменные для определения вида и места окна
    private static final int WINDOW_WIDTH = 800;// переменные для определения вида и места окна
    private static final int WINDOW_HEIGHT = 600;// переменные для определения вида и места окна

    Sprite[] sprites = new Sprite[10];// Создание массивов типа Sprite из 10 элементов

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {// Непонятная конструкция
            @Override
            public void run() {
                new MainCircles();// Создаем объект MainCircles
            }
        });
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Закрывается программ(окно) когда нажимаем крестик
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);// Задаем размеры окна (WINDOW_WIDTH, WINDOW_HEIGHT) и точку в которой создатся (POS_X, POS_Y)
        GameCanvas canvas = new GameCanvas(this);// Создается объект класса GameCanvas. canvas .Вопрос почему используется this (присваивается последнему фрейму время lastFrameTime = System.nanoTime();)
        add(canvas, BorderLayout.CENTER);// Добавляем объект canvas в центр (внутри окна)
        setTitle("Circles");// Название окна
        initApplication();// Создание 10 шаров
        setVisible(true);// Видимость всей программ (окна, шаров )
    }

    private void initApplication() { // Создание шаров
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    void onCanvasRepainted(GameCanvas canvas, Graphics g, float deltaTime) { // Для чего этот метод ? Чтобы обновлять и перерисовывать? Как часто он вызывается по времени?
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);// вызываем переопределенный метод из Ball, который обновляет координаты шара.
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g); // вызываем переопределенный метод из Ball, который  перерисовывает координаты шара.
        }
    }
}