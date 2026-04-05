package classes;

import java.io.File;

public class GenerateLexer {

    public static void generateLexer(String root) throws Exception {
        if (root.isEmpty()) throw new IllegalArgumentException("Your path is empty");

        File lexFile = new File(root);

        if (lexFile.getName().isEmpty()) {
            jflex.Main.generate(new String[]{root});
        }
    }

}
