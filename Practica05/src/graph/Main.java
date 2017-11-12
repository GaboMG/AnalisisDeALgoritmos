package graph;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        String archivo = args[0];
        String algoritmo = args[1];

        Lector lr = new Lector("resource/"+archivo);
        String[] vertices = lr.vertices;
        ArrayList<String[]> aristas = lr.aristas;

        Grafica gr = new Grafica((vertices.length));

        for(int i = 0; i < aristas.size(); i++){

          gr.addEdge(Integer.parseInt(aristas.get(i)[0]),Integer.parseInt(
          aristas.get(i)[1]));

        }

        if (algoritmo.equals("DFS")) {
            gr.componenteDFS();
        }else if (algoritmo.equals("BFS")){
            gr.componenteBFS();
        }else{
            System.err.println("Entrada no valida");
        }
    }
}
