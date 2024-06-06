import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerPipe;
import org.graphstream.ui.view.View;
public class Automata {


      //      Scanner scanner = new Scanner(System.in);
        //    System.out.print("Ingrese el número de estados: ");
       /*     int numEstados = scanner.nextInt();
            scanner.nextLine(); // Limpiar el búfer
*/
            // Crear un nuevo grafo
            Graph graph = new SingleGraph("Autómata");
            public void crear_nodos(int numEstados) {
                // Agregar nodos al grafo
                for (int i = 0; i <= numEstados; i++) {
                    Node node = graph.addNode("q" + Integer.toString(i));
                    node.setAttribute("ui.label", ("q" + Integer.toString(i)));
                    System.out.println("nodo q " + Integer.toString(i) + "creado");
                }
            }
            // Agregar arcos al grafo

            public void arcos(String EstadoA, String EstadoS, String Arco){
                String idArco = EstadoA + "-" + EstadoS;
                String viejoA;

                boolean nulo = false;
                try{
                    if (graph.getEdge(idArco).getAttribute("ui.label") == null);
                }catch (NullPointerException e) {
                    nulo = true;
                    System.out.println(nulo);
                }


                if (nulo){
                    graph.addEdge(idArco, EstadoA, EstadoS, true);
                    //             graph.getEdge(idArco).setAttribute("ui.label", Character.toString(c));
                    graph.getEdge(idArco).setAttribute("ui.label", Arco);
                    graph.getEdge(idArco).setAttribute("ui.style", "text-visibility-mode: normal;");


                }
                else {

                    viejoA = graph.getEdge(idArco).getAttribute("ui.label");
                    Arco = viejoA + " | " + Arco ;
                    graph.getEdge(idArco).setAttribute("ui.label", Arco);
                    graph.getEdge(idArco).setAttribute("ui.style", "text-visibility-mode: normal;");
                }
            }




   /*         for (int i = 0; i < numEstados; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    System.out.print("Ingrese el siguiente estado para el estado " + i + " con el símbolo " + c + " (o -1 para no definir): ");
                    int siguienteEstado = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el búfer

                    if (siguienteEstado != -1) {
                        String idArco = Integer.toString(i) + "-" + siguienteEstado;
                        graph.addEdge(idArco, Integer.toString(i), Integer.toString(siguienteEstado), true);
                        //             graph.getEdge(idArco).setAttribute("ui.label", Character.toString(c));
                        graph.getEdge(idArco).setAttribute("ui.label", "Hola");
                    }
                    else{
                        c= 'z';
                    }
                }
            }
*/
            // Establecer el estilo del grafo

            //    graph.setAttribute("ui.stylesheet", "node { text-size: 20px; }");
            //  graph.setAttribute("ui.stylesheet", "edge { size: 1px; fill-color: black; }");

            public void mostrar() {

                graph.setAttribute("ui.stylesheet", "node { size: 30px; text-size: 20px; }" +
                        "edge { text-size: 16px; size: 3px; }");
                graph.setAttribute("ui.quality");
                graph.setAttribute("ui.antialias");

                // Mostrar el grafo
               graph.display();
            }
}
