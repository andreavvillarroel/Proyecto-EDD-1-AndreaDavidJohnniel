/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import EDD.Grafo;
import EDD.Vertice;

/**
 *
 * @author Moises Liota
 */
public class GestionSucursal {
    private Grafo grafo;

    public GestionSucursal(Grafo grafo) {
        this.grafo = grafo;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }
    
    private boolean tieneSucursales(){
        if(!grafo.isEmpty()){
            for (int i = 0; i < this.grafo.getVertices().getSize(); i++) {
                Vertice vertice = (Vertice) this.grafo.getVertices().getValor(i);
                if(vertice.isTieneSucursal()){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean colocarSucursal(String nombreParada){
        if(grafo.buscar(nombreParada) != null){
            grafo.buscar(nombreParada).setTieneSucursal(true);
            return true;
        }
        
        return false;
    }
    
    public boolean eliminarSucursal(String nombreParada){
        if(grafo.buscar(nombreParada) != null){
            grafo.buscar(nombreParada).setTieneSucursal(false);
            return true;
        }
        
        return false;
    }
    
    public String nombres(){
        if(!grafo.isEmpty()){
            String nombresSucursales = "SUCURSALES:\n";
            for (int i = 0; i < this.grafo.getVertices().getSize(); i++) {
                Vertice vertice = (Vertice) this.grafo.getVertices().getValor(i);
                if(vertice.isTieneSucursal()){
                    nombresSucursales += vertice.getNombre() + "\n";
                } 
            }
            
            return nombresSucursales;
        }
        
        return "No hay Estaciones";
    }
}
