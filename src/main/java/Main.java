import classes.GenerateLexer;
import classes.GenerateParser;
import classes.LocalizationUI;
import classes.UserInterface;

public class Main {

    public static void main(String[] args) {
        try {
            //GenerateLexer.generateLexer();
            //GenerateParser.generateParser();

            LocalizationUI.localizationRUS();

            new UserInterface();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
