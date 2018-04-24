package school2;

import school2.datautil.DataUtil;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Application {

    private static List<Aluno> alunos = new ArrayList<>();
    JFrame frame;
    DaddyPanel inicio;
    String tituloInicial = "Bem vindo ao cadastro de alunos";
    PanelCadastroAluno pnCadastroAluno;
    String tituloCadastrar = "Cadastro de Aluno";
    PanelCadastroAluno pnEditarAluno;
    String tituloEditar = "Editar Aluno";
    PainelBuscarAluno pnBuscarAluno;
    String tituloBuscar = "Buscar Anulo";
    PainelListarTodosAlunos pnListarTodosAlunos;
    String tituloListarTodos = "Listar Alunos";

    public void start() {
        Aluno aluno1 = new Aluno("111111","Algum Nome", DataUtil.stringToCalendar("20/01/2012"), 9.5d, 96d);
        Aluno aluno2 = new Aluno("111112","Outro Nome", DataUtil.stringToCalendar("23/12/2012"), 9.4d, 97d);
        Aluno aluno3 = new Aluno("111113","Um Outro Nome", DataUtil.stringToCalendar("11/04/2012"), 9.8d, 97d);
        Aluno aluno4 = new Aluno("111114","Algum Outro Nome", DataUtil.stringToCalendar("08/10/2012"), 9.9d, 98d);

        alunos.add(aluno1);
        alunos.add(aluno2);
        alunos.add(aluno3);
        alunos.add(aluno4);

        frame = new JFrame();
        frame.setTitle(tituloInicial);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inicio = criarPainelInicial();

        pnCadastroAluno = PanelCadastroAluno.newCriar(frame, inicio, tituloCadastrar);
        pnEditarAluno = PanelCadastroAluno.newEditar(frame, inicio, tituloEditar);
        pnBuscarAluno = new PainelBuscarAluno(frame, inicio, tituloBuscar);
        pnListarTodosAlunos = new PainelListarTodosAlunos(frame, inicio, pnEditarAluno,tituloListarTodos, alunos);

        frame.setSize(600,400);

        frame.add(inicio);
    }

    private DaddyPanel criarPainelInicial() {
        inicio = new DaddyPanel(frame, tituloInicial);
        Box buttonBox = new Box(BoxLayout.X_AXIS);

        JButton btnCadastrarAluno = new JButton("Cadastrar");
        btnCadastrarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicio.trocarPainel(pnCadastroAluno);
            }
        });
        buttonBox.add(btnCadastrarAluno);

        JButton btnEditarAluno = new JButton("Editar");
        btnEditarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicio.trocarPainel(pnEditarAluno);
            }
        });
        buttonBox.add(btnEditarAluno);

        JButton btnBuscarAluno = new JButton("Buscar");
        btnBuscarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicio.trocarPainel(pnBuscarAluno);
            }
        });
        buttonBox.add(btnBuscarAluno);

        JButton btnListarAlunos = new JButton("Listar todos os Alunos");
        btnListarAlunos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicio.trocarPainel(pnListarTodosAlunos);
            }
        });
        buttonBox.add(btnListarAlunos);

        inicio.add(BorderLayout.NORTH, buttonBox);
        frame.setBounds(20,20,500,500);

        frame.add(inicio);
        frame.setVisible(true);

        return inicio;
    }






    public List<Aluno> buscarAlunosPorFrequencia(Double frequencia) {
        List<Aluno> alunoList = new ArrayList<>();

        for (Aluno aluno : alunos) {
            if (aluno.getFrequencia().equals(frequencia)) {
                alunoList.add(aluno);
            }
        }

        return alunoList;
    }

    public List<Aluno> buscarAlunosPorNota(Double nota) {
        List<Aluno> alunoList = new ArrayList<>();

        for (Aluno aluno : alunos) {
            if (aluno.getNota().equals(nota)) {
                alunoList.add(aluno);
            }
        }

        return alunoList;
    }

    public List<Aluno> buscarAlunosPorData(String dataDeNascimento) {
        List<Aluno> alunoList = new ArrayList<>();
        for (Aluno aluno : alunos) {
            if (DataUtil.calendarToString(aluno.getDataDeNascimento()).contains(dataDeNascimento)) {
                alunoList.add(aluno);
            }
        }
        return alunoList;
    }

    public List<Aluno> buscarAlunosPorNome(String nome) {
        List<Aluno> alunoList = new ArrayList<>();

        for (Aluno aluno : alunos) {
            if (aluno.getNome().contains(nome)) {
                alunoList.add(aluno);
            }
        }
        return alunoList;
    }

    public Aluno buscarAlunoPorMatricula(String matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        return null;

    }
}
