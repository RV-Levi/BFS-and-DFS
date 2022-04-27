package recorridos;

import java.util.Random;
import java.util.Scanner;

public class Recorridos {

    public static void main(String[] args) {

        Scanner texto = new Scanner(System.in);
        int filas, columnas, vi, sgte, var1, valor;

        System.out.println("Ingrese el número de filas o columnas de la matriz de adyacencia: ");
        filas = texto.nextInt();
        columnas = filas;
        int[][] grafo = new int[filas][columnas];

        System.out.println("Cómo desea ingresar datos a la matriz de adyacencia?\n"
                + "1. Manualmente\n"
                + "2. De forma aleatoria\n"
                + "3. Ejecutar un ejemplo\n"
                + "0. Salir");
        sgte = texto.nextInt();
        while (sgte < 0 | sgte > 3) {
            System.out.println("Cómo desea ingresar datos?\n"
                    + "1. Manualmente\n"
                    + "2. De forma aleatoria\n"
                    + "0. Salir");
            sgte = texto.nextInt();
        }
        switch (sgte) {
            case 1:
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        System.out.println("Grafo[" + i + "][" + j + "]= ");
                        grafo[i][j] = texto.nextInt();
                        while (grafo[i][j] < 0 | grafo[i][j] > 2) {
                            System.out.println("Grafo[" + i + "][" + j + "]= ");
                            grafo[i][j] = texto.nextInt();
                        }
                    }
                }
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        System.out.print(grafo[i][j] + " ");
                    }
                }
                break;
            case 2:
                System.out.println("Insertando los siguientes valores de forma aleatoria: ");
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        int min = 0;
                        int max = 2;
                        Random random = new Random();
                        valor = (int) (random.nextInt(max + min) + min);
                        grafo[i][j] = valor;
                    }
                }
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        System.out.print(grafo[i][j] + " ");
                        if (j == columnas - 1) {
                            System.out.print("\n");
                        }
                    }
                }
                break;
            case 3:
                int grafoEjem[][] = {
                    {0, 0, 0, 1, 0},
                    {0, 0, 1, 1, 1},
                    {0, 1, 0, 0, 1},
                    {1, 1, 0, 0, 1},
                    {0, 1, 1, 1, 0}
                };

                Metodos m = new Metodos(grafoEjem.length);

                System.out.println("");
                System.out.println("BFS: ");
                m.BFS(3, grafoEjem);

                System.out.println("");
                System.out.println("DFS: ");
                m.DFS(3, grafoEjem);
                System.out.println("");

                if (m.noDirigido(grafoEjem)) {
                    System.out.println("El grafo es no dirigido");
                } else {
                    System.out.println("El grafo es dirigido");
                }
                break;
        }

        Metodos m = new Metodos(grafo.length);

        if (sgte != 0 & sgte != 3) {
            do {
                System.out.println("");
                System.out.println("Ingrese el número de la opción deseada:\n"
                        + "1. BFS\n"
                        + "2. DFS\n"
                        + "3. Verificar si es dirigido\n"
                        + "4. BFS, DFS y verificar si es dirigido\n"
                        + "0. Salir");
                var1 = texto.nextInt();
                switch (var1) {
                    case 1:
                        System.out.println("Ingrese el valor de inicio: ");
                        vi = texto.nextInt();
                        m.BFS(vi, grafo);
                        System.out.println("");
                        break;
                    case 2:
                        System.out.println("Ingrese el valor de inicio: ");
                        vi = texto.nextInt();
                        m.DFS(vi, grafo);
                        System.out.println("");
                        break;
                    case 3:
                        if (m.noDirigido(grafo)) {
                            System.out.println("El grafo es no dirigido");
                        } else {
                            System.out.println("El grafo es dirigido");
                        }
                        break;
                    case 4:
                        System.out.println("Ingrese el valor de inicio: ");
                        vi = texto.nextInt();
                        System.out.println("BFS: ");
                        m.BFS(vi, grafo);
                        System.out.println("");
                        System.out.println("DFS: ");
                        m.DFS(vi, grafo);
                        System.out.println("");
                        if (m.noDirigido(grafo)) {
                            System.out.println("El grafo es no dirigido");
                        } else {
                            System.out.println("El grafo es dirigido");
                        }
                        break;
                }
            } while (var1 != 0);
        }
    }
}
