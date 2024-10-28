/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;


/**
 *
 * @author Moises Liota
 */
public class Grafo {
    private Lista vertices;

    public Grafo() {
        this.vertices = new Lista();
    }

    public Lista getVertices() {
        return vertices;
    }

    public void setVertices(Lista vertices) {
        this.vertices = vertices;
    }

    public boolean isEmpty() {
        return this.vertices.EsVacio();
    }

    public Vertice buscar(String nombreVertice) {
        if (!this.isEmpty()) {
            int index = this.vertices.buscarYDevolverIndice(nombreVertice);
            if(index != -1){
                Vertice verticeResultado = (Vertice) this.vertices.getValor(index);
                return verticeResultado;
            }
            
            return null;
        }
        return null;
    }

    public void insertarEstacion(String nombreEstacion) {
        if (this.buscar(nombreEstacion) == null) {
            Vertice estacion = new Vertice(nombreEstacion);
            estacion.setNumeroEstacion(this.vertices.getSize());
            this.vertices.insertarFinal(estacion);
        }
    }
    
    public void insertarVertice(Vertice vertice) {
        if (this.buscar(vertice.getNombre()) == null) {
            vertice.setNumeroEstacion(this.vertices.getSize());
            this.vertices.insertarFinal(vertice);
        }
    }

    public void agregarConexion(String nombreInicio, String nombreFin) {
        Vertice estacionInicio = this.buscar(nombreInicio);
        Vertice estacionFinal = this.buscar(nombreFin);
        if (estacionInicio != null && estacionFinal != null) {
            estacionInicio.getListaAd().insertarFinal(estacionFinal);
            estacionFinal.getListaAd().insertarFinal(estacionInicio);
        } 
    }

    public void eliminarConexion(String nombreInicio, String nombreFin) {
       Vertice estacionInicio = this.buscar(nombreInicio);
        Vertice estacionFinal = this.buscar(nombreFin);
        if (estacionInicio != null && estacionFinal != null) {
            estacionInicio.getListaAd().insertarFinal(estacionFinal);
            estacionFinal.getListaAd().insertarFinal(estacionInicio);
            
            if (estacionInicio.getListaAd().buscar(estacionFinal)) {
                estacionInicio.getListaAd().EliminarPorReferencia(estacionFinal);
                estacionFinal.getListaAd().EliminarPorReferencia(estacionInicio);
            }

        }
    }

    public void destruir() {
        this.vertices = new Lista();
    }

    @Override
    public String toString() {
        if (!this.isEmpty()) {
            String grafoStr = "";
            Nodo aux = this.vertices.getpFirst();
            while (aux != null) {
                Vertice estacionActual = (Vertice) aux.getDato();
                grafoStr += estacionActual.getNombre() + " => " + estacionActual.mostrarAdyacencias();
                if(aux.getPnext() == null){
                   break;
                }
                grafoStr += "\n";
                aux = aux.getPnext();
            }          
            return grafoStr;
        } else {
            return "Grafo vacio";
        }
    }
}
