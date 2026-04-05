import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JasminFileGenerator {

    private FileWriter fileWriter; // Field for writing to file

    private static final String header = """
            .class public Example\s
            .super java/lang/Object

            .method public static run()V
             .limit stack 1024
             .limit locals 256
            """;

    private static final String footer = """
             return
            .end method

            .method public static main([Ljava/lang/String;)V
             invokestatic Output/run()V
             return
            .end method
            """;

    /* Constructor */
    public JasminFileGenerator(String filePath) {
        try {
            this.fileWriter = new FileWriter(filePath);
        } catch (IOException e) {
            e.getCause();
        }
    }

    /* Method of generation of the beginning of file.j */
    public void generateJasminFileBegin() {
        try {
            fileWriter.write(header);
            fileWriter.flush();
        } catch (IOException e) {
            e.getCause();
        }
    }

    /* This method insert the Jasmin after parsing */
    public void insertCodeToJasminFile(String[] commands) {
        try {
            for (int i = 0; i < commands.length-1; i++)
            {
                fileWriter.write(" " + commands[i] + "\n");
            }
        } catch (NullPointerException | IOException e) {
            e.getCause();
        }
    }

    /* Method of generation of the end of file.j */
    public void generateJasminFileEnd() {
        try {
            fileWriter.write(footer);
            fileWriter.flush();
        } catch (IOException e) {
            e.getCause();
        }
    }
}