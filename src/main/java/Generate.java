import java.io.*;

public class Generate {
    public static void main(String[] args) throws Exception {
//        String pathToParser = "src/main/java/parser.cup";
//        String pathToLexer = "src/main/java/lexer.flex";
//        generateLex(pathToLexer);
//        generateParse(pathToParser);
        // Don't touch what's above, I optimize (or you) it later...

        /* Create generator of jasmin files and next create blank template */
        JasminFileGenerator jFileGenerator = new JasminFileGenerator("src/main/java/Example.j");
        jFileGenerator.generateJasminFileBegin();

        /* Declaration of things */
        FileReader fileReader = new FileReader("src/main/java/PascalProgram.txt");

        CalcLexer lexer = new CalcLexer(fileReader);
        parser pars = new parser(lexer);

        String[] commands = pars.parse().value.toString().split("\n");


        System.out.println("\n" + commands.length);
        for (String s : commands){
            System.out.println(s);

        }

        jFileGenerator.insertCodeToJasminFile(commands);

        jFileGenerator.generateJasminFileEnd();




        /* Generate example.class by CMD */
            /* Not working */
        /*String[] command = {"java -jar jasmin.jar src/main/java/Example.j"};
        Process cmd = Runtime.getRuntime().exec(command);
        cmd.waitFor();
        cmd.destroy();*/
    }
}
