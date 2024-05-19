package introducao.set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefasSet;

    public ListaTarefas() {
        this.tarefasSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefasSet.add(new Tarefa(descricao, false));
    }

    public void removerTarefa(String descricao) {
        if (!tarefasSet.isEmpty()) {
            for (Tarefa t : tarefasSet) {
                if (t.getDescricao().equals(descricao)) {
                    tarefasSet.remove(t);
                    break;
                }
            }
        } else {
            System.out.println("Não tem tarefas ainda");
        }
    }

    public void exibirTarefas() {
        System.out.println(tarefasSet);
    }

    public int contarTarefas() {
        return tarefasSet.size();
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        if (!tarefasSet.isEmpty()) {
            Set<Tarefa> tarefasConcluidas = new HashSet<>();
            for (Tarefa t : tarefasSet) {
                if (t.isFeita()) {
                    tarefasConcluidas.add(t);
                }
            }
            if (!tarefasConcluidas.isEmpty()) {
                return tarefasConcluidas;
            } else {
                throw new RuntimeException("Nenhuma tarefa concluída!");

            }
        } else {
            throw new RuntimeException("Não exitem tarefas adicionadas!");
        }
    }

    public Set<Tarefa> obterTarefasPendentes() {
        if (!tarefasSet.isEmpty()) {
            Set<Tarefa> tarefasPendentes = new HashSet<>();
            for (Tarefa t : tarefasSet) {
                if (!t.isFeita()) {
                    tarefasPendentes.add(t);
                }
            }
            if (!tarefasPendentes.isEmpty()) {
                return tarefasPendentes;
            } else {
                throw new RuntimeException("Nenhuma tarefa pendente!");

            }
        } else {
            throw new RuntimeException("Não exitem tarefas adicionadas!");
        }
    }

    public void marcarTarefaConcluida(String descricao) {
        boolean tarefaEncontrada = false;
        if (!tarefasSet.isEmpty()) {
            for (Tarefa t : tarefasSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setFeita(true);
                    tarefaEncontrada = true;
                    break;
                }
            }
            if (!tarefaEncontrada) {
                System.out.println("Tarefa não encontrada!");
            }
        } else {
            System.out.println("Não tem tarefas ainda!");
        }
    }

    public void marcarTarefaPendente(String descricao) {
        boolean tarefaEncontrada = false;
        if (!tarefasSet.isEmpty()) {
            for (Tarefa t : tarefasSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setFeita(false);
                    tarefaEncontrada = true;
                    break;
                }
            }
            if (!tarefaEncontrada) {
                System.out.println("Tarefa não encontrada!");
            }
        } else {
            System.out.println("Não tem tarefas ainda!");
        }

    }

    public void limparListaTarefas() {
        if (tarefasSet.isEmpty()) {
            System.out.println("Não tem tarefas!");
        } else {
            tarefasSet.clear();
        }
    }

    public static void main(String[] args) {
        // Criando uma instância da classe ListaTarefas
        ListaTarefas listaTarefas = new ListaTarefas();

        // Adicionando tarefas à lista
        listaTarefas.adicionarTarefa("Estudar Java");
        listaTarefas.adicionarTarefa("Fazer exercícios físicos");
        listaTarefas.adicionarTarefa("Organizar a mesa de trabalho");
        listaTarefas.adicionarTarefa("Ler livro");
        listaTarefas.adicionarTarefa("Preparar apresentação");

        // Exibindo as tarefas na lista
        listaTarefas.exibirTarefas();

        // Removendo uma tarefa
        listaTarefas.removerTarefa("Fazer exercícios físicos");
        listaTarefas.exibirTarefas();

        // Contando o número de tarefas na lista
        System.out.println("Total de tarefas na lista: " + listaTarefas.contarTarefas());

        // Obtendo tarefas pendentes
        System.out.println(listaTarefas.obterTarefasPendentes());

        // Marcando tarefas como concluídas
        listaTarefas.marcarTarefaConcluida("Ler livro");
        listaTarefas.marcarTarefaConcluida("Estudar Java");

        // Obtendo tarefas concluídas
        System.out.println(listaTarefas.obterTarefasConcluidas());

        // Marcando tarefas como pendentes
        listaTarefas.marcarTarefaPendente("Estudar Java");
        listaTarefas.exibirTarefas();

        // Limpando a lista de tarefas
        listaTarefas.limparListaTarefas();
        listaTarefas.exibirTarefas();
    }
}
