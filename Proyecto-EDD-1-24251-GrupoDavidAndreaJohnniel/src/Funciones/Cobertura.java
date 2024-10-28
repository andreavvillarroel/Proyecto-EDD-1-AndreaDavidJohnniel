/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import EDD.Cola;
import EDD.Grafo;
import EDD.Lista;
import EDD.Pila;
import EDD.Vertice;
import javax.swing.JOptionPane;

public class Cobertura {

    private Grafo grafo;
    private int maxDistancia;

    public Cobertura(Grafo grafo, int maxDistancia) {
        this.grafo = grafo;
        this.maxDistancia = maxDistancia;
    }

    // BFS (búsqueda en anchura)
    public void realizarBusquedaBFS(Vertice origen) {
        if (origen == null) {
            JOptionPane.showMessageDialog(null, "El vértice de inicio no puede ser nulo.");
            return;
        }

        String resultado = "Iniciando desde: " + origen.getNombre() + "\n";
        Cola colaVertices = new Cola();
        Cola colaDistancias = new Cola();
        Lista visitados = new Lista();

        colaVertices.encolar(origen);
        colaDistancias.encolar(0);
        visitados.insertarFinal(origen);

        while (!colaVertices.colaVacia()) {
            Vertice actual = (Vertice) colaVertices.desencolar();
            int distancia = (int) colaDistancias.desencolar();

            if (distancia > maxDistancia) {
                continue;
            }

            resultado += "Vértice: " + actual.getNombre() + ", Distancia: " + distancia + "\n";

            // Chequear paso peatonal
            Vertice pasoPeatonal = actual.getPeaton();
            if (pasoPeatonal != null) {
                Vertice peatonal = grafo.buscar(pasoPeatonal.getNombre());
                if (!visitados.buscar(peatonal)) {
                    colaVertices.encolar(peatonal);
                    colaDistancias.encolar(distancia);
                    visitados.insertarFinal(peatonal);
                }
            }

            // Revisar adyacentes
            Lista adyacentes = actual.getListaAd();
            for (int i = 0; i < adyacentes.getSize(); i++) {
                Vertice vecino = (Vertice) adyacentes.getValor(i);
                if (!visitados.buscar(vecino)) {
                    colaVertices.encolar(vecino);
                    colaDistancias.encolar(distancia + 1);
                    visitados.insertarFinal(vecino);
                }
            }
        }

        JOptionPane.showMessageDialog(null, resultado);
    }

    public void realizarBusquedaDFS(Vertice origen) {
        if (origen == null) {
            JOptionPane.showMessageDialog(null, "El vértice de inicio no puede ser nulo.");
            return;
        }

        String resultado = "Iniciando desde: " + origen.getNombre() + "\n";
        Pila pila = new Pila();
        Lista visitados = new Lista();
        Pila distancias = new Pila();

        pila.apilar(origen);
        distancias.apilar(0);
        visitados.insertarFinal(origen);

        while (!pila.isEmpty()) {
            Vertice actual = (Vertice) pila.getCima().getDato();
            int distancia = (int) distancias.getCima().getDato();

            pila.desapilar();
            distancias.desapilar();

            if (distancia > maxDistancia) {
                continue;
            }

            resultado += "Vértice: " + actual.getNombre() + ", Distancia: " + distancia + "\n";

            // Revisar paso peatonal (distancia = 0)
            Vertice pasoPeatonal = actual.getPeaton();
            if (pasoPeatonal != null) {
                Vertice peatonal = grafo.buscar(pasoPeatonal.getNombre());
                if (!visitados.buscar(peatonal)) {
                    pila.apilar(peatonal);
                    distancias.apilar(distancia); // La distancia no incrementa
                    visitados.insertarFinal(peatonal);
                }
            }

            // Revisar adyacentes
            Lista adyacentes = actual.getListaAd();
            for (int i = 0; i < adyacentes.getSize(); i++) {
                Vertice vecino = (Vertice) adyacentes.getValor(i);
                if (!visitados.buscar(vecino)) {
                    pila.apilar(vecino);
                    distancias.apilar(distancia + 1);
                    visitados.insertarFinal(vecino);
                }
            }
        }

        JOptionPane.showMessageDialog(null, resultado);
    }
}
