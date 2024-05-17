package introducao.set.operacoesbasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavrasUnicas;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicas = new HashSet<>();
    }

    public void adicionarPalavra(String palavra) {
        palavrasUnicas.add(palavra);
    }

    public void removerPalavra(String palavra) {
        String palavraRemovida = "";
        for (String palavraCopia : palavrasUnicas) {
            if (palavraCopia == palavra) {
                palavraRemovida = palavraCopia;
                break;
            }
        }
        palavrasUnicas.remove(palavraRemovida);
    }

    public void verificarPalavra(String palavra) {
        if (palavrasUnicas.contains(palavra)) {
            System.out.println("A palavra " + palavra + " está presente no conjunto.");
        } else {
            System.out.println("A palavra não está presente no conjunto.");
        }
    }

    public void exibirPalavrasUnicas() {
        System.out.println(palavrasUnicas);
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoTeste = new ConjuntoPalavrasUnicas();

        conjuntoTeste.adicionarPalavra("Abacaxi");
        conjuntoTeste.adicionarPalavra("Carro");
        conjuntoTeste.adicionarPalavra("Celular");
        conjuntoTeste.adicionarPalavra("Chave");
        conjuntoTeste.adicionarPalavra("Pedra");
        conjuntoTeste.adicionarPalavra("Maçaneta");

        conjuntoTeste.exibirPalavrasUnicas();

        conjuntoTeste.verificarPalavra("Pedra");

        conjuntoTeste.removerPalavra("Pedra");

        conjuntoTeste.verificarPalavra("Pedra");
        conjuntoTeste.verificarPalavra("Maça");

        conjuntoTeste.exibirPalavrasUnicas();

    }
}
