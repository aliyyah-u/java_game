package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static game.DumpFile.fileName;

/*public class GameSaverLoader {

    public static void save(String fileName, GameLevel level) throws IOException {

        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append);

            writer.write(level.getName() + level.getMei().getAcornCount() + level.getMei().getSoots() + "\n");

        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public static void load(String filename, Game game) throws IOException {


        FileReader fr = null;
        BufferedReader reader = null;

        try {

            fr = new FileReader(filename);
            reader = new BufferedReader(fr);

            String line = reader.readLine();
            GameLevel level;
            if (line.equals("Level1")) {
                level = new Level1(game);
            } else if (line.equals("Level2")) {
                level = new Level2(game);
            } else if (line.equals("level3")) {
                level = new Level3(game);
            }

            line = reader.readLine();
            while (line != null) {

                String[] tokens = line.split(",");

                if (tokens[0].equals("Acorns")) {
                    Acorns acorns = new Acorns(level);
                } else if (tokens[0].equals("Soot")) {
                    Soot soot = new Soot(level);
                } else if (tokens[0].equals("Mei")) {
                    Mei mei = new Mei(level);
                }

                line = reader.readLine();
            }
         //   return level;
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }
}
*/