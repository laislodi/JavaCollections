package school2.comparator;

import school2.Aluno;

import java.util.Comparator;

public class MatriculaComparator implements Comparator<Aluno> {

    @Override
    public int compare(Aluno a1, Aluno a2) {
        return a1.getMatricula().compareTo(a2.getMatricula());
    }
}
