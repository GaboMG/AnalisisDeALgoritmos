package graph;

import java.io.*;
import java.util.*;

class Grafica {

    private int V;
    private LinkedList<Integer> adj[];

    /**
     * Constructor para clase Grafica
     * @param v numero de vertices de la gráfica.
     */
    public Grafica (int v) {
        V = v;
        adj = new LinkedList [v];
        for (int i = 0; i < V; ++i) {
            adj[i] = new LinkedList();
        }
    }

    /**
     * Funcion que agega una arista a la gráfica.
     * @param int v vertice de la gráfica.
     * @param int w vertice de la gráfica.
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    /**
     * Implementacion del algoritmo de BFS
     * @param s Vertice inicial
     */
    public void BFS(int s, boolean visited[]) {
        visited[s] = true;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s]=true;
        queue.add(s);
        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s+" ");
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    /**
     * Implementacion del algoritmo DFS.
     * @param int     v         vertice inicial.
     * @param boolean visited[] arreglo con ls vertices que fueron visitados.
     */
    public void DFS(int v,boolean visited[]){
        visited[v] = true;
        System.out.print(v+" ");
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFS(n, visited);
        }
    }

    /**
     * Metodo que encuentra las componentes conexas de una grafica usando el
     * algoritmo DFS.
     */
    public void componenteDFS(){
        boolean visited[] = new boolean[V];
        for(int v = 0; v < V; v++)
            visited[v] = false;
        for( int i = 0 ; i < V ; i++){
            if(visited[i] == false){
                DFS(i,visited);
                System.out.println("nueva componente");
            }
        }
    }
    /**
     * Metodo que encuentra las componentes conexas de una grafica usando el
     * algoritmo BFS.
     */
    public void componenteBFS(){
        boolean visited[] = new boolean[V];
        for(int v = 0; v < V; v++)
            visited[v] = false;
        for( int i = 0 ; i < V ; i++){
            if(visited[i] == false){
                BFS(i,visited);
                System.out.println("nueva componente");
            }
        }
    }
}
