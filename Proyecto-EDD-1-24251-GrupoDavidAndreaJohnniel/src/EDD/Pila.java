/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import javax.swing.JOptionPane;

/**
 *
 * @author Moises Liota
 */
public class Pila {

    private Nodo cima;
    int size;

    public Pila() {
        this.cima = null;
        this.size = 0;
    }

    public Nodo getCima() {
        return cima;
    }

    public void setCima(Nodo cima) {
        this.cima = cima;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return this.cima == null;
    }

    public void apilar(Object dato) {
        Nodo pNew = new Nodo(dato);
        if (this.isEmpty()) {
            this.setCima(pNew);
        } else {
            pNew.setPnext(cima);
            this.setCima(pNew);
        }
        size++;
    }

    public void desapilar() {
        if (!this.isEmpty()) {
            if (this.size == 1) {
                this.setCima(null);
            } else {
                this.setCima(cima.getPnext());
            }
            size--;
        }
    }
    
    public boolean buscar(Object referencia){
        if(!this.isEmpty()){
            if(this.size == 1){
                return this.cima.getDato() == referencia;
            }else{
                Nodo aux = cima;
                while(aux != null){
                    if(aux.getDato() == referencia){
                        return true;
                    }
                    aux = aux.getPnext();
                }
                
                return false;
            }
        }
        
        return false;
    }
    
     public void eliminarPorValor(Object referencia){
         if(!this.isEmpty() && this.buscar(referencia)){
             Nodo aux = cima;
             Pila pilaAux = new Pila();
             while(aux != null){
                 if(aux.getDato() == referencia){
                     this.desapilar();
                     break;
                 }
                 pilaAux.apilar(aux.getDato());
                 aux = aux.getPnext();
                 this.desapilar();
             }
             
             aux = pilaAux.getCima();
             while(aux != null){
                 this.apilar(aux.getDato());
                 aux = aux.getPnext();
                 pilaAux.desapilar();
             }
             
         }
     }
     

    public void destruir() {
        this.cima = null;
        this.size = 0;
    }

    public void mostrar() {
        if (!this.isEmpty()) {
            Nodo aux = cima;
            String pila = "PILA:\n";
            while (aux != null) {
                pila = pila + aux.getDato() + "\n";
                aux = aux.getPnext();
            }
            JOptionPane.showMessageDialog(null, pila);
        } else {
            JOptionPane.showMessageDialog(null, "La Pila esta vacia.");
        }
    }

}
