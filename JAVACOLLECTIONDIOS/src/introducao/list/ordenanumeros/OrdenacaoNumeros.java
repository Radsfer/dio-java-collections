package introducao.list.ordenanumeros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> numeros = new ArrayList<>();

    public List<Integer> getNumeros() {
        return numeros;
    }

    public void setNumeros(List<Integer> numeros) {
        this.numeros = numeros;
    }

    public OrdenacaoNumeros() {
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        this.numeros.add(numero);
    }

    public void ordenarAscendente() {
        Collections.sort(numeros);
    }

    public void ordenarDescendente() {
        Collections.sort(numeros, Collections.reverseOrder());
    }

    public static void main(String[] args) {
        OrdenacaoNumeros numerosList = new OrdenacaoNumeros();

        numerosList.adicionarNumero(21);
        numerosList.adicionarNumero(13);
        numerosList.adicionarNumero(4);
        numerosList.adicionarNumero(1);
        numerosList.adicionarNumero(25);
        numerosList.adicionarNumero(33);
        numerosList.adicionarNumero(12);
        numerosList.adicionarNumero(0);
        numerosList.adicionarNumero(11);
        numerosList.adicionarNumero(1);
        numerosList.adicionarNumero(2);

        System.out.println(numerosList.getNumeros());
        numerosList.ordenarAscendente();
        System.out.println(numerosList.getNumeros());
        numerosList.ordenarDescendente();
        System.out.println(numerosList.getNumeros());
    }

}