package school2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCadastroAluno extends DaddyPanel {

    private JTextField txtNome;
    private JTextField txtMatricula;
    private JTextField txtDataDeNascimento;
    private JTextField txtNota;
    private JTextField txtFrequencia;

    private PanelCadastroAluno(JFrame frame, DaddyPanel inicio, String titulo, boolean isCadastro) {
        super(frame, titulo);
        this.init(isCadastro, inicio);
    }

    public static PanelCadastroAluno newCriar(JFrame frame, DaddyPanel inicio, String titulo) {
        return new PanelCadastroAluno(frame, inicio, titulo, true);
    }

    public static PanelCadastroAluno newEditar(JFrame frame, DaddyPanel inicio, String titulo) {
        return new PanelCadastroAluno(frame, inicio, titulo, false);
    }

    private void init(boolean isCadastro, DaddyPanel inicio) {
        JPanel dados = criarPainelDeDados();
        JPanel pnButtons = new JPanel();

        JButton btnVoltarInicio = new JButton("Voltar");
        btnVoltarInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocarPainel(inicio);
            }
        });
        pnButtons.add(btnVoltarInicio);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        pnButtons.add(btnSalvar);

        this.add(BorderLayout.SOUTH, pnButtons);
        this.add(dados);
    }

    private JPanel criarPainelDeDados() {
        GridLayout gridLayout = new GridLayout(6,2);
        JPanel pnDados = new JPanel(gridLayout);
        pnDados.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        pnDados.add(txtNome);
        pnDados.add(new JLabel("Matricula:"));
        txtMatricula = new JTextField();
        pnDados.add(txtMatricula);
        pnDados.add(new JLabel("Data de Nascimento:"));
        txtDataDeNascimento = new JTextField();
        pnDados.add(txtDataDeNascimento);
        pnDados.add(new JLabel("Nota:"));
        txtNota = new JTextField();
        pnDados.add(txtNota);
        pnDados.add(new JLabel("Frequencia:"));
        txtFrequencia = new JTextField();
        pnDados.add(txtFrequencia);

        return pnDados;
    }

    public void fillScreen(Object[] dadosDoAluno) {
        txtMatricula.setText(dadosDoAluno[0].toString());
        txtNome.setText(dadosDoAluno[1].toString());
        txtDataDeNascimento.setText(dadosDoAluno[2].toString());
        txtNota.setText(dadosDoAluno[3].toString());
        txtFrequencia.setText(dadosDoAluno[4].toString());

    }

}
