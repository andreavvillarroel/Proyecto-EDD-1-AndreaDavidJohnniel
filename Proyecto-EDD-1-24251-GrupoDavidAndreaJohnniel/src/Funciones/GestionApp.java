/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import EDD.Grafo;
import EDD.Lista;
import EDD.Vertice;

/**
 *
 * @author Moises Liota
 */
public class GestionApp {

    public Lista nombresEstacionesSinSucursal(Grafo grafo) {
        if (!grafo.isEmpty()) {
            Lista nombres = new Lista();
            for (int i = 0; i < grafo.getVertices().getSize(); i++) {
                Vertice vertice = (Vertice) grafo.getVertices().getValor(i);
                if (!vertice.isTieneSucursal()) {
                    nombres.insertarFinal(vertice.getNombre());
                }
            }
            return nombres;
        }
        return null;
    }

    public Lista nombresEstacionesSucursal(Grafo grafo) {
        if (!grafo.isEmpty()) {
            Lista nombres = new Lista();
            for (int i = 0; i < grafo.getVertices().getSize(); i++) {
                Vertice vertice = (Vertice) grafo.getVertices().getValor(i);
                if (vertice.isTieneSucursal()) {
                    nombres.insertarFinal(vertice.getNombre());
                }
            }
            return nombres;
        }
        return null;
    }

    public Lista nombresEstaciones(Grafo grafo) {
        if (!grafo.isEmpty()) {
            Lista nombres = new Lista();
            for (int i = 0; i < grafo.getVertices().getSize(); i++) {
                Vertice vertice = (Vertice) grafo.getVertices().getValor(i);

                nombres.insertarFinal(vertice.getNombre());

            }
            return nombres;
        }
        return null;
    }

    public String nombresLinea(Lista linea) {
        if (!linea.EsVacio()) {
            String resultado = "";
            for (int i = 0; i < linea.getSize(); i++) {
                String nombre = (String) linea.getValor(i);
                resultado += nombre + "\n";
            }

            return resultado;
        }

        return "No hay estaciones en la linea";
    }

    public boolean nombreEnLinea(Lista linea, String nombreEst) {
        if (!linea.EsVacio()) {
            for (int i = 0; i < linea.getSize(); i++) {
                String nombre = (String) linea.getValor(i);
                if (nombreEst.equalsIgnoreCase(nombre)) {
                    return true;
                }
            }

            return false;
        }

        return false;
    }

    public void conectarEstacionesLinea(Lista linea, Lista vertices) {
        for (int i = 0; i < linea.getSize() - 1; i++) {
            String nombreEstacion = (String) linea.getValor(i); 
            String nombreFuturo = (String) linea.getValor(i + 1);    

            Vertice verticeNuevo = obtenerOcrearVertice(nombreEstacion, vertices);
            Vertice verticeFuturo = obtenerOcrearVertice(nombreFuturo, vertices);

            verticeFuturo.getListaAd().insertarFinal(verticeNuevo);
            verticeNuevo.getListaAd().insertarFinal(verticeFuturo);
        }
    }
    
     private Vertice obtenerOcrearVertice(String nombreEstacion, Lista vertices) {

        for (int i = 0; i < vertices.getSize(); i++) {
            Vertice verticeActual = (Vertice) vertices.getValor(i);
            if (verticeActual.getNombre().equalsIgnoreCase(nombreEstacion)) {
                return verticeActual;
            }
        }
        
        Vertice verticeNuevo = new Vertice(nombreEstacion);
        vertices.insertarFinal(verticeNuevo);
        return verticeNuevo;
    }
     
    public void aggVertices(Grafo grafo, Lista vertices){
        for (int i = 0; i < vertices.getSize(); i++) {
            Vertice verticeActu = (Vertice) vertices.getValor(i);
            grafo.insertarVertice(verticeActu);
        }
    }
}
