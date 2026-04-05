package classes;

import java.io.File;

public class GenerateParser {

    public static void generateParser(String root) throws Exception {
        if (root.isEmpty()) throw new IllegalArgumentException("Your path is empty");

        File parserFile = new File(root);

        if (parserFile.getName().isEmpty()) {
            java_cup.Main.main(new String[]{root});
        }
    }

}
