package edu.byui.cs;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Processes files, loading and saving them in the appropriate formats
 */
public class FileProcessor {

    /**
     * Loads in a file and saves it out in the correct format.
     *
     * Saving Rules:
     * -If the file has < 10 lines, remove the commas and save it as a text file
     * -If the file has > 10 lines, but < 1000 then save it as a csv file
     * -If the file has < 1000 lines then save it to a text file, but only save the column
     *     with the education level in it (the 4th column, i.e., index=3)
     *
     * @param inputFile The name of the file to read the data from
     */
    public void processFile(String inputFile) throws IOException {
        System.out.println("Running on file " + inputFile);
        List<String> lines = readFile(inputFile);

        System.out.format("Found %d lines%n", lines.size());

        // Now, save it out
        String outputFileWithoutExtension = getOutputFileNameWithoutExtension(inputFile);
        writeFile(outputFileWithoutExtension, lines);
    }

    /**
     * Returns the name of the outputFile, but without an extension
     * so "myFile.txt" becomes "myFile_output" rather than "myFile_output.txt"
     *
     * @param inputFile The name of the input file to begin from
     * @return The new output file
     */
    private String getOutputFileNameWithoutExtension(String inputFile) {

        // This could include a lot more rigorous checking...

        int lastDot = inputFile.lastIndexOf(".");
        return inputFile.substring(0, lastDot) + "_output";
    }

    /**
     * Reads a file line by line and returns a list of each line.
     *
     * @param inputFile The file to read in
     * @return A list of all the lines
     * @throws IOException If a problem occured during the reading process.
     */
    private List<String> readFile(String inputFile) throws IOException {
        // First read the file
        Path filePath = new File(inputFile).toPath();
        Charset charset = Charset.defaultCharset();
        List<String> lines = Files.readAllLines(filePath, charset);

        return lines;
    }

    /**
     * Saves the data to the approriate file, using the following rules:
     *
     * Saving Rules:
     * -If the file has < 10 lines, remove the commas and save it as a text file
     * -If the file has > 10 lines, but < 1000 then save it as a csv file
     * -If the file has < 1000 lines then save it to a text file, but only save the column
     *     with the education level in it (the 4th column, i.e., index=3)
     *
     * @param ouputFileWithoutExtension A filename with no extension (i.e., "file_output" not "file_output.txt")
     * @param lines A list of all the lines that came from the input file.
     */
    private void writeFile(String ouputFileWithoutExtension, List<String> lines) {
        // TODO: Implement this, according to the rules above, making use of Design Patterns
    }
}
