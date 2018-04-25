package school2;

import school2.datautil.DataUtil;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
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

    private PanelCadastroAluno(JFrame frame, DaddyPanel inicio, String titulo, List<Aluno> alunos, boolean isCadastro) {
        super(frame, titulo);
        this.init(isCadastro, inicio, alunos);
    }

    public static PanelCadastroAluno newCriar(JFrame frame, DaddyPanel inicio, String titulo, List<Aluno> alunos) {
        return new PanelCadastroAluno(frame, inicio, titulo, alunos,  true);
    }

    public static PanelCadastroAluno newBuscar(JFrame frame, DaddyPanel inicio, String titulo, List<Aluno> alunos) {
        return new PanelCadastroAluno(frame, inicio, titulo, alunos, false);
    }

    private void init(boolean isCadastro, DaddyPanel inicio, List<Aluno> alunos) {
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

        JButton btnSalvarBuscar = new JButton(isCadastro ? "Salvar" : "Buscar");
        btnSalvarBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aluno aluno = new Aluno(
                        txtMatricula.getText(),
                        txtNome.getText(),
                        DataUtil.stringToCalendar(txtDataDeNascimento.getText()),
                        Double.parseDouble(txtNota.getText()),
                        Double.parseDouble(txtFrequencia.getText())
                );
                if (isCadastro) {
                    alunos.add(aluno);
                } else {
                    buscarAluno(alunos,aluno);
                }
            }
        });
        pnButtons.add(btnSalvarBuscar);

        this.add(BorderLayout.SOUTH, pnButtons);
        this.add(dados);
    }

    private void buscarAluno(List<Aluno> alunos, Aluno aluno) {
        for (Aluno a : alunos) {
            if ((a.getMatricula() != ""                                   || aluno.getMatricula().equals(a.getMatricula())) &&
                (a.getNome() != ""                                        || aluno.getNome().equals(a.getNome())) &&
                (DataUtil.calendarToString(a.getDataDeNascimento()) != "" || aluno.getDataDeNascimento().equals(a.getDataDeNascimento())) &&
                (a.getNota().toString() != ""                             || aluno.getNota() == a.getNota()) &&
                (a.getFrequencia().toString() != ""                       || aluno.getFrequencia() == a.getFrequencia())) {

            }
        }
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
