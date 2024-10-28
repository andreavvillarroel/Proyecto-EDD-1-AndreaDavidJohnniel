/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Moises Liota
 */
public class Vertice {
     private String nombre;
    private int numeroVertice;
    private Lista listaAdy;
    private boolean sucursal;
    private Vertice pasoPeaton;

    public Vertice(String nombre) {
        this.nombre = nombre;
        this.numeroVertice = -1;
        this.listaAdy = new Lista();
        this.sucursal = false;
        this.pasoPeaton = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroEstacion() {
        return numeroVertice;
    }

    public void setNumeroEstacion(int numeroEstacion) {
        this.numeroVertice = numeroEstacion;
    }

    public Lista getListaAd() {
        return listaAdy;
    }

    public void setListaAd(Lista listaAdy) {
        this.listaAdy = listaAdy;
    }

    public boolean isTieneSucursal() {
        return sucursal;
    }

    public void setTieneSucursal(boolean tieneSucursal) {
        this.sucursal = tieneSucursal;
    }

    public Vertice getPeaton() {
        return pasoPeaton;
    }

    public void setPeaton(Vertice pasoPeaton) {
        this.pasoPeaton = pasoPeaton;
    }

    public String mostrarAdyacencias() {
        if (!this.listaAdy.EsVacio()) {
            Nodo aux = this.listaAdy.getpFirst();
            String listaAdyacenciaStr = "";
            
            while (aux != null) {
                Vertice verticeActual = (Vertice) aux.getDato();
                if(aux.getPnext() == null){ 
                    listaAdyacenciaStr += verticeActual.getNombre();
                    break;
                }
                listaAdyacenciaStr += verticeActual.getNombre() + " -> ";
                aux = aux.getPnext();
            }
           
            return listaAdyacenciaStr;
        }

        return "No tiene adyacentes";
    }

    public String nombrePasoPeatonal() {
        if (this.pasoPeaton == null) {
           return "No hay paso peatonal en esta estacion"; 
        } else {  
            return this.pasoPeaton.getNombre();
        }
    }
    
     public String sucursalStr() {
        if (!this.isTieneSucursal()) {
           return "No"; 
        } else {  
            return "Si";
        }
    }
     
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nNumero de Vertice: " + this.numeroVertice + "\nAdyacentes: " + this.mostrarAdyacencias() + "\nPaso Peatonal: " + this.nombrePasoPeatonal() + "\nSucursal: " + this.sucursalStr() + "\n";
    }
    
}
