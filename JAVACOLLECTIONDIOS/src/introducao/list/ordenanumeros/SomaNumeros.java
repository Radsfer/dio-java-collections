package introducao.list.ordenanumeros;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> numeros = new ArrayList<>();

    public SomaNumeros() {
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        numeros.add(numero);
    }

    public int calcularSoma() {
        int soma = 0;
        if (!numeros.isEmpty()) {
            for (int i : numeros) {
                soma += i;
            }
        }
        return soma;
    }

    public int encontrarMaiorNumero() {
        int maior = Integer.MIN_VALUE;
        if (!numeros.isEmpty()) {
            for (int i : numeros) {
                if (maior <= i) {
                    maior = i;
                }
            }
        }
        return maior;
    }

    public int encontrarMenorNumero() {
        int menor = Integer.MAX_VALUE;
        if (!numeros.isEmpty()) {
            for (int i : numeros) {
                if (menor >= i) {
                    menor = i;
                }
            }
        }
        return menor;
    }

    public void exibirNumeros() {
        if (!numeros.isEmpty()) {
            System.out.println(numeros);
        } else {
            System.out.println("Lista vazia!");
        }
    }

    public static void main(String[] args) {
        SomaNumeros testSomaNumeros = new SomaNumeros();

        testSomaNumeros.adicionarNumero(12);
        testSomaNumeros.adicionarNumero(32);
        testSomaNumeros.adicionarNumero(787);
        testSomaNumeros.adicionarNumero(11);
        testSomaNumeros.adicionarNumero(-199);
        testSomaNumeros.adicionarNumero(14);
        testSomaNumeros.adicionarNumero(2);
        testSomaNumeros.adicionarNumero(8);
        testSomaNumeros.adicionarNumero(2);
        testSomaNumeros.adicionarNumero(0);

        testSomaNumeros.exibirNumeros();
        System.out.println("O maior número é: " + testSomaNumeros.encontrarMaiorNumero());
        System.out.println("O menor número é: " + testSomaNumeros.encontrarMenorNumero());
        System.out.println("Soma total é = " + testSomaNumeros.calcularSoma());
    }
}
