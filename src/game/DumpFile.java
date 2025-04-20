package game;

import java.io.FileInputStream;
import java.io.IOException;

public class DumpFile {
    public final static String fileName = "data/sample.txt";

    public static void main(String[] args) throws IOException {

        //HighScoreWriter writer = new HighScoreWriter("data/scores.txt");
        //writer.writeHighScore("Aliyyah", 10);

        HighScoreReader reader = new HighScoreReader("data/scores.txt");
        reader.readScores();

       /* FileInputStream in = new FileInputStream(fileName);
        int c = in.read();
        System.out.println(c);
        int counter = 1;
        while (c != -1 && counter < 16) {
            c = in.read();
            System.out.println(c);
            counter++;
        }
        in.close();*/
    }

}
