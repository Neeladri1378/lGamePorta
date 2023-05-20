package GameFolder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public interface Game {
    String getGameName();

    void play(); // must be able to play a game

    11 // get a score - if there is no "score" then we

    void writeHighScore(File f); // writes the high score of this game to a file.
}