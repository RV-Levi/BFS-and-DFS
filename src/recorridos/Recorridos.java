package recorridos;

public class Recorridos {

    public static void main(String[] args) {

        int grafo[][] = {
            {0, 0, 0, 1, 0},
            {0, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {0, 1, 1, 1, 0}
        };
        Metodos m = new Metodos(grafo.length);

        System.out.println("");
        System.out.print("BFS: ");
        m.BFS(3, grafo);
        System.out.println("");

        System.out.print("DFS: ");
        m.DFS(3, grafo);
        System.out.println("");

        if (m.noDirigido(grafo)) {
            System.out.println("El grafo es no dirigido");
        } else {
            System.out.println("El grafo es dirigido");
        }

    }

}
