package school2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PainelBuscarAluno extends DaddyPanel {

    public PainelBuscarAluno(JFrame frame, DaddyPanel inicio, String titulo, List<Aluno> alunos) {
        super(frame, titulo);
        this.criarPainelBuscar(frame, inicio, titulo, alunos);
    }

    private void criarPainelBuscar(JFrame frame, DaddyPanel inicio, String tituloDaFrame, List<Aluno> alunos) {
        frame.setTitle(tituloDaFrame);


        JButton btnVoltarInicio = new JButton("Voltar");
        btnVoltarInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(inicio);
            }
        });
        this.add(btnVoltarInicio);
    }


}
