package school2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PainelBuscarAluno extends DaddyPanel {

    public PainelBuscarAluno(JFrame frame, DaddyPanel inicio, String titulo) {
        super(frame, titulo);
        this.criarPainelBuscar(frame, inicio, titulo);
    }

    private void criarPainelBuscar(JFrame frame, DaddyPanel inicio, String tituloDaFrame) {
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
