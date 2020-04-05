import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    MainCircles listener;
    long lastFrameTime;

    GameCanvas(MainCircles listener) { // Что за конструктор,для чего используется. Почему нет модификатора доступа?
        this.listener = listener;
        lastFrameTime = System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);// Зачем вызывать? Чтобы создать объект графики? для чего он создается и где используется?
        //60 frames per second
        long currentTime = System.nanoTime(); // Текущее время
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f; //
        lastFrameTime = currentTime; // прошлое время
        listener.onCanvasRepainted(this, g, deltaTime);// Что такое listener (слушатель) как он работает?
        try { // непонятная часть
            Thread.sleep(17);// останавливается на 17 милисекунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();// перерисовка. Перерисовывается полностью вся канва?
    }

    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }

}