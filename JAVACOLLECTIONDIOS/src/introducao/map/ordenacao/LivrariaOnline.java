package introducao.map.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LivrariaOnline {
    private Map<String, Livro> livroMap;

    public LivrariaOnline() {
        this.livroMap = new HashMap<>();
    }

    public void adicionarLivro(String link, Livro livro) {
        livroMap.put(link, livro);
    }

    public void removerLivro(String titulo) {
        if (!livroMap.isEmpty()) {
            for (Map.Entry<String, Livro> l : livroMap.entrySet()) {
                if (l.getValue().getTitulo() == titulo) {
                    String aux = l.getKey();
                    livroMap.remove(aux);
                    break;
                }
            }
        } else {
            System.out.println("Não há livros na loja ainda!");
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livroMap.entrySet());

        Collections.sort(livrosParaOrdenarPorPreco, new ComparadorPorPreco());

        Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorPreco) {
            livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
        }

        return livrosOrdenadosPorPreco;
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorAutor() {
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorAutor = new ArrayList<>(livroMap.entrySet());

        Collections.sort(livrosParaOrdenarPorAutor, new ComparadorPorAutor());

        Map<String, Livro> livrosOrdenadosPorAutor = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorAutor) {
            livrosOrdenadosPorAutor.put(entry.getKey(), entry.getValue());
        }

        return livrosOrdenadosPorAutor;
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
        if (!livroMap.isEmpty()) {
            Map<String, Livro> livrosPorAutor = new HashMap<>();
            for (Map.Entry<String, Livro> l : livroMap.entrySet()) {
                if (l.getValue().getAutor().startsWith(autor)) {
                    livrosPorAutor.put(l.getKey(), l.getValue());
                }
            }
            if (!livrosPorAutor.isEmpty()) {
                return livrosPorAutor;
            } else {
                System.out.println("Autor não encontrado!");
            }
        }
        System.out.println("Loja sem livros!");
        return null;
    }

    public Livro obterLivroMaisCaro() {
        if (!livroMap.isEmpty()) {
            Double maiorPreco = Double.MIN_VALUE;
            Livro livroMaiorPreco = null;
            for (Map.Entry<String, Livro> l : livroMap.entrySet()) {
                if (l.getValue().getPreco() > maiorPreco) {
                    maiorPreco = l.getValue().getPreco();
                    livroMaiorPreco = l.getValue();
                }
            }
            return livroMaiorPreco;
        }
        System.out.println("Loja sem livros!");
        return null;
    }

    public Livro obterLivroMaisBarato() {
        if (!livroMap.isEmpty()) {
            Double menorPreco = Double.MAX_VALUE;
            Livro livroMenorPreco = null;
            for (Map.Entry<String, Livro> l : livroMap.entrySet()) {
                if (l.getValue().getPreco() < menorPreco) {
                    menorPreco = l.getValue().getPreco();
                    livroMenorPreco = l.getValue();
                }
            }
            return livroMenorPreco;
        }
        System.out.println("Loja sem livros!");
        return null;
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();
        // Adiciona os livros à livraria online
        livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z", new Livro("1984", "George Orwell", 50d));
        livrariaOnline.adicionarLivro("https://amzn.to/47Umiun",
                new Livro("A Revolução dos Bichos", "George Orwell", 7.05d));
        livrariaOnline.adicionarLivro("https://amzn.to/3L1FFI6",
                new Livro("Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d));
        livrariaOnline.adicionarLivro("https://amzn.to/3OYb9jk", new Livro("Malorie", "Josh Malerman", 5d));
        livrariaOnline.adicionarLivro("https://amzn.to/45HQE1L",
                new Livro("E Não Sobrou Nenhum", "Agatha Christie", 50d));
        livrariaOnline.adicionarLivro("https://amzn.to/45u86q4",
                new Livro("Assassinato no Expresso do Oriente", "Agatha Christie", 5d));

        // Exibe todos os livros ordenados por preço
        System.out.println("Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());

        // Exibe todos os livros ordenados por autor
        System.out.println("Livros ordenados por autor: \n" + livrariaOnline.exibirLivrosOrdenadosPorAutor());

        // Pesquisa livros por autor
        System.out.println("Pesquisar livros por autor:");
        String autorPesquisa = "Josh Malerman";
        System.out.println(livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa));

        // Obtém e exibe o livro mais caro
        System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

        // Obtém e exibe o livro mais barato
        System.out.println("Livro mais barato: " + livrariaOnline.obterLivroMaisBarato());

        // Remover um livro pelo título
        livrariaOnline.removerLivro("1984");
        System.out.println(livrariaOnline.livroMap);

    }
}
