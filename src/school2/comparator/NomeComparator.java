package school2.comparator;

import school2.Aluno;

import java.util.Comparator;

public class NomeComparator implements Comparator<Aluno> {

    @Override
    public int compare(Aluno a1, Aluno a2) {
        return a1.getNome().compareTo(a2.getNome());
    }
}