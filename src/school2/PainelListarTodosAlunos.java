package school2;

import school2.datautil.DataUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PainelListarTodosAlunos extends DaddyPanel {

    public PainelListarTodosAlunos(JFrame frame, DaddyPanel inicio, PanelCadastroAluno telaEditar, String titulo, List<Aluno> alunos) {
        super(frame, titulo);
        this.criarPainelListar(frame, inicio, telaEditar, titulo, alunos);
    }

    private void criarPainelListar(JFrame frame, DaddyPanel inicio, PanelCadastroAluno telaEditar, String titulo, List<Aluno> alunos) {
        frame.setTitle(titulo);

        JTable table;
        String[] colunas = new String[]{"Matricula","Nome", "Data de Nascimento", "Nota", "Frequencia(%)"};
        String[][] dados = new String[alunos.size()][];
        String[] dadoDoAluno = new String[5];

        JButton btnEditar = new JButton("Editar");
        for (int i = 0; i < alunos.size(); i++) {
            Aluno aluno = alunos.get(i);
            dadoDoAluno[0] = aluno.getMatricula();
            dadoDoAluno[1] = aluno.getNome();
            dadoDoAluno[2] = DataUtil.calendarToString(aluno.getDataDeNascimento());
            dadoDoAluno[3] = aluno.getNota().toString();
            dadoDoAluno[4] = aluno.getFrequencia().toString();
            dados[i] = dadoDoAluno;
        }

        table = new JTable(dados, colunas);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaEditar.fillScreen(dadoDoAluno);
                trocarPainel(telaEditar);
            }
        });

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
