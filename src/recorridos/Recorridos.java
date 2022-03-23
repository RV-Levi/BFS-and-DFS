package recorridos;

import java.util.Random;
import java.util.Scanner;

public class Recorridos {

    public static void main(String[] args) {

        Scanner texto = new Scanner(System.in);
        int filas, columnas, vi, sgte, var1, valor;

        System.out.println("Ingrese el número de filas de la matriz de adyacencia: ");
        filas = texto.nextInt();
        System.out.println("Ingrese el número de columnas: ");
        columnas = texto.nextInt();
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
                        System.out.println(grafo[i][j] + " ");
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
                    }
                }
                break;
            case 3:
                Metodos m = new Metodos(grafo.length);
                boolean visitados[] = new boolean[grafo.length];

                int grafoEjem[][] = {
                    {0, 0, 0, 1, 0},
                    {0, 0, 1, 1, 1},
                    {0, 1, 0, 0, 1},
                    {1, 1, 0, 0, 1},
                    {0, 1, 1, 1, 0}
                };

                System.out.println("");
                System.out.println("BFS: ");
                m.BFS(3, grafoEjem);
                System.out.println("");

                System.out.println("DFS: ");
                m.DFS(3, grafoEjem, visitados);
                System.out.println("");

                if (m.noDirigido(grafoEjem)) {
                    System.out.println("El grafo es no dirigido");
                } else {
                    System.out.println("El grafo es dirigido");
                }
                break;
        }

        Metodos m = new Metodos(grafo.length);
        boolean visitados[] = new boolean[grafo.length];

        if (sgte != 0) {
            do {
                System.out.println("Ingrese el número de la opción deseada: ");
                System.out.println("1. BFS");
                System.out.println("2. DFS");
                System.out.println("3. BFS y DFS");
                System.out.println("0. Salir");
                var1 = texto.nextInt();
                switch (var1) {
                    case 1:
                        System.out.println("Ingrese el valor de inicio: ");
                        vi = texto.nextInt();
                        m.BFS(vi, grafo);
                        break;
                    case 2:
                        System.out.println("Ingrese el valor de inicio: ");
                        vi = texto.nextInt();
                        m.DFS(vi, grafo, visitados);
                        break;
                    case 3:
                        System.out.println("Ingrese el valor de inicio: ");
                        vi = texto.nextInt();
                        m.BFS(vi, grafo);
                        m.DFS(vi, grafo, visitados);
                        break;
                }
            } while (var1 != 0);
        }
    }
}
