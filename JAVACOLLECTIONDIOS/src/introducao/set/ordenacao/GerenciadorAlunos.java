package introducao.set.ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunosSet;

    public GerenciadorAlunos() {
        this.alunosSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double media) {
        alunosSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula) {
        boolean alunoEncontrado = false;
        if (!alunosSet.isEmpty()) {
            for (Aluno a : alunosSet) {
                if (a.getMatricula() == matricula) {
                    alunoEncontrado = true;
                    alunosSet.remove(a);
                    break;
                }
            }
            if (!alunoEncontrado) {
                System.out.println("Aluno com número de matrícula " + matricula + " não encontrado");
            }
        } else {
            System.out.println("Não tem alunos cadastrados!");
        }
    }

    public void exibirAlunosPorNome() {
        if (!alunosSet.isEmpty()) {
            Set<Aluno> alunosOrganizadosNome = new TreeSet<>(alunosSet);
            System.out.println(alunosOrganizadosNome);
        } else {
            System.out.println("Não tem alunos cadastrados!");
        }
    }

    public void exibirAlunosPorNota() {
        if (!alunosSet.isEmpty()) {
            Set<Aluno> alunosOrganizadosNota = new TreeSet<>(new ComparatorPorNota());
            alunosOrganizadosNota.addAll(alunosSet);
            System.out.println(alunosOrganizadosNota);
        } else {
            System.out.println("Não tem alunos cadastrados!");
        }
    }

    public void exibirAlunos() {
        if (alunosSet.isEmpty()) {
            System.err.println("Não tem alunos cadastrados!");
        } else {
            System.err.println(alunosSet);
        }
    }

    public static void main(String[] args) {
        // Criando uma instância do GerenciadorAlunos
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        // Adicionando alunos ao gerenciador
        gerenciadorAlunos.adicionarAluno("João", 123456L, 7.5);
        gerenciadorAlunos.adicionarAluno("Maria", 123457L, 9.0);
        gerenciadorAlunos.adicionarAluno("Carlos", 123458L, 5.0);
        gerenciadorAlunos.adicionarAluno("Ana", 123459L, 6.8);

        // Exibindo todos os alunos no gerenciador
        System.out.println("Alunos no gerenciador:");
        System.out.println(gerenciadorAlunos.alunosSet);

        // Removendo um aluno com matrícula inválida e outro pelo número de matrícula
        gerenciadorAlunos.removerAluno(000L);
        gerenciadorAlunos.removerAluno(123457L);
        System.out.println(gerenciadorAlunos.alunosSet);

        // Exibindo alunos ordenados por nome
        gerenciadorAlunos.exibirAlunosPorNome();

        // Exibindo alunos ordenados por nota
        gerenciadorAlunos.exibirAlunosPorNota();
    }
}
