package classes;
import javax.swing.*;
import java.awt.event.*;

/* Этот класс нужднается в редакции, сюда надо завести функцию выбора программы на паскаль, и также конопку СКОМПИЛИРОВАТЬ и в том же окне будет сообщение - зелёный текст всё ок, иначе красный*/
public class UserInterface extends JFrame {
    private  JButton  btnSaveFile   = null;
    private  JButton  btnOpenDir    = null;
    private  JButton  btnFileFilter = null;

    private  JFileChooser fileChooser = null;

    private final String[][] FILTERS = {{"docx", "Файлы Word (*.docx)"},
            {"pdf" , "Adobe Reader(*.pdf)"}};

    public UserInterface() {
        super("Пример FileChooser");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Кнопка создания диалогового окна для выбора директории
        btnOpenDir = new JButton("Открыть директорию");
        // Кнопка создания диалогового окна для сохранения файла
        btnSaveFile = new JButton("Сохранить файл");
        // Кнопка создания диалогового окна для сохранения файла
        btnFileFilter = new JButton("Фильтрация файлов");

        // Generate object of JFileChooser
        fileChooser = new JFileChooser();

        // Connect listeners to buttons
         addFileChooserListeners();

        // Creating of buttons at interface
        JPanel contents = new JPanel();
        contents.add(btnOpenDir   );
        contents.add(btnSaveFile  );
        contents.add(btnFileFilter);
        setContentPane(contents);



        // Print window on screen
        setSize(360, 110);
        setVisible(true);
    }

    private void addFileChooserListeners() {
        btnOpenDir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Выбор директории");
                // Определение режима - только каталог
                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                int result = fileChooser.showOpenDialog(UserInterface.this);
                // Если директория выбрана, покажем ее в сообщении
                if (result == JFileChooser.APPROVE_OPTION )
                    JOptionPane.showMessageDialog(UserInterface.this,
                            fileChooser.getSelectedFile());
            }
        });

        btnSaveFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Сохранение файла");
                // Определение режима - только файл
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = fileChooser.showSaveDialog(UserInterface.this);
                // Если файл выбран, то представим его в сообщении
                if (result == JFileChooser.APPROVE_OPTION )
                    JOptionPane.showMessageDialog(UserInterface.this,
                            "Файл '" + fileChooser.getSelectedFile() +
                                    " ) сохранен");
            }
        });
    }
}
