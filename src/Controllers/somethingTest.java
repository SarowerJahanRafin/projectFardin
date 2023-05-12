package Controllers;

import java.util.*;
import java.io.*;

public class somethingTest {
    String givenName = "given_name";
    String outputFilename = "output.txt";

    try(
    BufferedReader reader = new BufferedReader(new FileReader("putput.txt"));
    BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename)))
    {

        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\s+");
            String name_changed = parts[0];
            String id_changed = parts[1];

            if (name_changed.equals(givenName)) {
                name_changed = "changed_name";
                id_changed = "changed_id";
            }

            writer.write(name + " " + id);
            writer.newLine();
        }

    }catch(
    IOException e)
    {
        System.err.println("Error: " + e.getMessage());
    }
}
