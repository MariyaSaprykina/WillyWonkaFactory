package song;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class OompaLoompaSong {

    private int lines;

    List<String> song = new ArrayList<>();
    List<String> allLines;

    String result = "";

    File file = new File("/home/maria/Downloads/OompaLoompaSong.txt");
    BufferedReader br;

    public OompaLoompaSong(int lines) {
        this.lines = lines;
        allLines = new ArrayList<>();

        try {

            String line;
            br = new BufferedReader(new FileReader(file));

            while ((line = br.readLine()) != null) {
                allLines.add(line);

            }
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.toString());
        } catch (IOException e) {
            System.out.println("Unable to read file: " + file.toString());
        }

    }

    public String sing() {

        Random random = new Random();

        int[] randomLines = new int[lines];

        for (int i = 0; i < randomLines.length; i++) {
            randomLines[i] = random.nextInt(allLines.size());
        }

        Arrays.sort(randomLines);


        int count = 0;
        int i = 0;
        while (i < randomLines.length) {

            if (count == randomLines[i]) {
                song.add(allLines.get(count));
                i++;
                if (i != randomLines.length) {
                    while (i < randomLines.length && count == randomLines[i]) {
                        song.add(allLines.get(count));
                        i++;
                    }
                }

            }

            count++;

        }

        for (String str : song) {
            result = result.concat(str + "\n");
        }

        return result;
    }

}

