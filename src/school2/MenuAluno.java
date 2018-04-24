package school2;

import java.awt.BorderLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MenuAluno {

    JFrame frame;
    JPanel panel;
    JMenuBar menuBar;
    String[] atributosList = {"Nome","Matrícula", "Data de Nascimento", "Nota","Frquência (%)"};

    void buildMenuCatrastrarAluno() {
        frame = new JFrame("Cadastrar Aluno");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        Box atributosTextFileldBox = new Box(BoxLayout.Y_AXIS);
        Box atributosLableBox = new Box(BoxLayout.Y_AXIS);

        for (int i = 0; i < atributosList.length; i++) {
            JLabel label = new JLabel(atributosList[i]);
            atributosLableBox.add(label);
            atributosTextFileldBox.add(new JTextField());
        }
        panel.add(BorderLayout.WEST, atributosLableBox);
        panel.add(BorderLayout.EAST, atributosTextFileldBox);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    void buildMenuEditarAluno(Aluno aluno) {
        frame = new JFrame("Editar Aluno");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();

    }

}
