package recorridos;

import java.util.LinkedList;
import java.util.Queue;

public class Metodos {

    boolean visitadosDFS[];

    public Metodos(int nVertices) {
        visitadosDFS = new boolean[nVertices];
    }

    public void DFS(int vi, int grafo[][], boolean visitadosDFS[]) {
        System.out.print(vi + " ");
        visitadosDFS[vi] = true;
        for (int i = 0; i < grafo[vi].length; i++) {
            if (grafo[vi][i] == 1 && (!visitadosDFS[i])) {
                DFS(i, grafo, visitadosDFS);
            }
        }
    }

    public void BFS(int vi, int grafo[][]) {
        int v;
        boolean visitados[] = new boolean[grafo.length];
        Queue<Integer> cola = new LinkedList();
        visitados[vi] = true;
        cola.add(vi);
        while (!cola.isEmpty()) {
            v = cola.remove();
            System.out.print(v + " ");
            for (int i = 0; i < grafo.length; i++) {
                if (grafo[v][i] == 1 && !visitados[i]) {
                    visitados[i] = true;
                    cola.add(i);
                }
            }
        }
    }

    public boolean noDirigido(int grafo[][]) {
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo.length; j++) {
                if (grafo[i][j] != grafo[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
