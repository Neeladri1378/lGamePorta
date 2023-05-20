package PingPong;

import java.io.File;

import javax.swing.JFrame;

import GameFolder.Game;

public class PingPong implements Game {

    public void play() {
        JFrame frame = new JFrame("Ping Pong");
        MyPongPanel panel = new MyPongPanel();
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        try {
            panel.money();
        }
        catch (Exception e){

        }

    }

    @Override
    public String getGameName() {
        return "PingPong";
    }

    @Override
    public String getScore() {
        return null;
    }

    @Override
    public void writeHighScore(File f) {
        
        
    }
}