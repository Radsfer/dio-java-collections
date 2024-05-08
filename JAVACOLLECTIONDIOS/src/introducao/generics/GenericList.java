package introducao.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericList {
    public static void main(String[] args) {
        // Exemplo sem Generics
        List listaSemGenerics = new ArrayList();
        listaSemGenerics.add("Elemento 1");
        listaSemGenerics.add(10); // Permite adicionar qualquer tipo de objeto

        // Exemplo com Generics
        List<String> listaGenerics = new ArrayList<>();
        listaGenerics.add("Elemento 1");
        listaGenerics.add("Elemento 2");

        // Iterando sobre a lista com Generics
        for (String elemento : listaGenerics) {
            System.out.println(elemento);
        }

        // Iterando sobre a lista sem Generics (necessário fazer cast)
        // Utilizando do artíficio da concatenação pra conversão na hora
        // da chamada da string str do segundo elemento, lembrando
        // que não é boa prática isso. O generics existe justamente
        // pra evitar esses tipos de conversão!
        for (Object elemento : listaSemGenerics) {
            String str = elemento + "";
            System.out.println(str);
        }
    }
}
