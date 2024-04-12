import java.util.ArrayList;
import java.util.Scanner;

public class DesafioMatrizQuadradaI {

    public static void main(String[] args) throws Exception {

        int indexMtzM = 1;

        // ArrayList para armazenar valores das ordens imputados
        ArrayList<Integer> index_OrderMtzM = new ArrayList<Integer>();

        // Instanciaçao do objeto Scanner
        Scanner inputNM = new Scanner(System.in);

        // Popular vetor com ordens das matrizes
        while (indexMtzM > 0 && indexMtzM <= 100) {
            indexMtzM = inputNM.nextInt();
            index_OrderMtzM.add(indexMtzM);
        }

        // Varrer o vetor passando itens para a função plotMatriz que recebe a matriz constrída da função buildMatriz
        for (int item : index_OrderMtzM) {
            plotMatriz(buildMatriz(item));
        }

        // Destrói o objeto criado da classe Scanner
        inputNM.close();
    }

    // Função para construção da matriz de ordem predeterminada index_OrderMtzM
    public static int[][] buildMatriz(int index_OrderMtzM) {

        int value, ajLim, midMtz = 0;

        // ponto central da matriz
        midMtz = index_OrderMtzM / 2;

        int[][] matriz = new int[index_OrderMtzM][index_OrderMtzM];

        // ajuste de shift para matrizes de índices pares ou ímpares
        ajLim = index_OrderMtzM % 2 == 0 ? -1 : 0;

        for (int midMLen = midMtz + ajLim; midMLen >= 0; midMLen--) {
            for (int linCol = midMLen; linCol >= 0; linCol--) {

                // Definição da posição da matriz
                value = linCol + 1;

                // primeiro quadrante
                matriz[linCol][midMLen] = value;
                matriz[midMLen][linCol] = value;

                // segundo quadrante
                matriz[linCol][midMtz + midMLen - linCol] = value;
                matriz[midMtz + linCol - midMLen + ajLim][2 * midMtz - linCol + ajLim] = value;

                // terceiro quadrante
                matriz[midMtz + midMLen - linCol][linCol] = value;
                matriz[2 * midMtz - linCol + ajLim][midMtz + linCol - midMLen + ajLim] = value;

                // quarto quadrante
                matriz[2 * midMtz - midMLen + ajLim][2 * midMtz - linCol + ajLim] = value;
                matriz[2 * midMtz - linCol + ajLim][2 * midMtz - midMLen + ajLim] = value;
            }
        }

        return matriz;
    }

    // Função para plotar a matriz recebida por parâmetro
    public static void plotMatriz(int[][] matrizM) {

        int itens = 0, cont;
        while (itens < matrizM.length) {
            // Foreach para plotar percorrer os itens da matriz
            cont = 1;
            for (int item : matrizM[itens]) {
                String form = (cont < matrizM.length) ? "  %d " : "  %d";
                System.out.print(String.format(form, item));
                cont++;
            }
            itens++;

            // Quebra de linha entre as linhas da matriz
            System.out.println();
        }
        // Quebra de linha entre matrizes
        System.out.println();
    }
}