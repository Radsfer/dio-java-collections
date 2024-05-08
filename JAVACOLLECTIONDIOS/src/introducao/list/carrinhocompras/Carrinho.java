package introducao.list.carrinhocompras;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Item> listItem;

    public Carrinho() {
        this.listItem = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        listItem.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        if (!listItem.isEmpty()) {
            List<Item> itensRemovidos = new ArrayList<>();
            for (Item i : listItem) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itensRemovidos.add(i);
                }
            }
            listItem.removeAll(itensRemovidos);
        } else {
            System.out.println("Carrinho de compras vazio!");
        }
    }

    public double calcularValorTotal() {
        double valorTotal = 0d;
        if (!listItem.isEmpty()) {
            for (Item i : listItem) {
                int auxQ = i.getQuantidade();
                double auxP = i.getPreco();
                double auxVI = auxP * auxQ;
                valorTotal += auxVI;
            }
        } else {
            System.out.println("Carrinho vazio!");
        }
        return valorTotal;
    }

    public void exibirItens() {
        if (!listItem.isEmpty()) {
            System.out.println(this.listItem);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    @Override
    public String toString() {
        return "CarrinhoDeCompras{" +
                "itens=" + listItem +
                '}';
    }

    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionarItem("Maçã", 0.50d, 3);
        carrinho.adicionarItem("Leite", 7.50d, 2);
        carrinho.adicionarItem("Pente de ovos", 16.83d, 1);
        carrinho.adicionarItem("Refrigerante", 11.73d, 1);

        carrinho.exibirItens();
        System.out.println("Valor total de R$" + carrinho.calcularValorTotal());

        carrinho.removerItem("Maçã");
        carrinho.removerItem("Pente de ovos");

        carrinho.exibirItens();
        System.out.println("Valor total de R$" + carrinho.calcularValorTotal());

    }
}
