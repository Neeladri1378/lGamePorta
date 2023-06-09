package PingPong;

import javax.swing.JPanel;
import java.awt.*;

public class MyPongPanel extends JPanel {
    /*
     * Oh no! It seems like we have misplaced our Paddle class file!
     * Could you recreate it, so we can play a friendly game of pong?
     * If you want to see how the code behaves,
     * you can comment out any code regarding the Paddle class.
     */

    Paddle one;
    Paddle two;
    Ball b;

    MyPongPanel() {
        one = new Paddle(40, 250);
        two = new Paddle(450, 250);
        b = new Ball(45);
    }

    @Override
    protected void paintComponent(Graphics g) {
        // ignore this part
        super.paintComponent(g);

        // draw paddles
        one.draw(g);
        two.draw(g);

        // draw ball
        b.draw(g);
    }

    public void money() throws InterruptedException {
        while (true) {
            // move the ball a little bit
            b.x += b.dx;
            b.y += b.dy;

            boolean inRightX = b.x + b.diameter >= two.x && b.x <= two.x + two.width;
            boolean inRightY = b.y <= two.y + two.length && b.y + b.diameter >= two.y;
            boolean inLeftX = b.x <= one.x + one.width;
            boolean inLeftY = b.y <= one.y + one.length && b.y + b.diameter >= one.y;

            // hit vertical wall or paddle
            boolean rightEdge = b.x + b.diameter >= getWidth(); 
            if (rightEdge || b.x < 0 ||
                    inRightX && inRightY || inLeftY && inLeftX) {
                b.dx = -1 * b.dx;
            }

            // hit top or bottom
            if (b.y + b.diameter >= getHeight() || b.y < 0) {
                b.dy = -1 * b.dy;
            }

            // check for collision with paddles
            // TODO: CODE HERE

            repaint();

            Thread.sleep(10);
        }
    }
}