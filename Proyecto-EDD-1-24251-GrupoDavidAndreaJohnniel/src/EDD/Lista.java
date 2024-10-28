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
public class Lista {
    private Nodo pFirts;
    private int size;
    

    public Lista() {
        this.pFirts = null;
        this.size = 0;
    }

    public Nodo getpFirst() {
        return pFirts;
    }

    public void setpFirst(Nodo pFirst) {
        this.pFirts = pFirst;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean EsVacio() {
        return this.pFirts == null;
    }

    public void insertarInicio(Object dato) {
        Nodo pNew = new Nodo(dato);

        if (EsVacio()) {
            this.pFirts.setDato(dato);
            this.pFirts.setPnext(null);
        } else {
            pNew.setPnext(this.pFirts);
            this.pFirts = pNew;
        }
        size++;
    }

    public void insertarFinal(Object dato) {
        Nodo pNew = new Nodo(dato);
        if (EsVacio()) {
            this.setpFirst(pNew);
        } else {
            Nodo aux = this.pFirts;
            while (aux.getPnext() != null) {
                aux = aux.getPnext();
            }
            aux.setPnext(pNew);
        }
        size++;
    }

    public void insertarPorPosicion(int posicion, Object valor) {
        if (posicion >= 0 && posicion < size) {
            
            if (posicion == 0) {
                this.insertarInicio(valor);
            } else {
               
                if (posicion == size - 1) {
                    this.insertarFinal(valor);
                } else {
                     Nodo nuevo = new Nodo(valor);
                    Nodo aux = this.pFirts;
                    for (int i = 0; i < (posicion - 1); i++) {
                        aux = aux.getPnext();
                    }
                    Nodo siguiente = aux.getPnext();
                    aux.setPnext(nuevo);
                    nuevo.setPnext(siguiente);
                }
            }
            size++;
        }
    }

    public void insertarPorReferencia(Object ref, Object valor) {

        Nodo nuevo = new Nodo(valor);

        if (!EsVacio()) {
            if (buscar(ref)) {
                Nodo aux = this.pFirts;
                
                while (aux.getDato() != ref) {
                    aux = aux.getPnext();
                }
                
                Nodo siguiente = aux.getPnext();
                
                aux.setPnext(nuevo);
                
                nuevo.setPnext(siguiente);

                size++;
            }
        }
    }

    public String Transformar() {
        if (!EsVacio()) {
            Nodo aux = this.pFirts;
            StringBuilder expresion = new StringBuilder();
            for (int i = 0; i < size; i++) {
               
                expresion.append(aux.getDato().toString()).append("\n");
                aux = aux.getPnext();
            }
            return expresion.toString();
        }
        return "Lista vacia";
    }

    public void mostrar() {
        if (!EsVacio()) {
            Nodo aux = this.pFirts;
            String expresion = "";
            while (aux != null) {
                expresion = expresion + aux.getDato().toString() + "\n";
                aux = aux.getPnext();
            }
            JOptionPane.showMessageDialog(null, expresion);
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }

    public boolean eliminarInicio() {
        if (!EsVacio()) {
            this.setpFirst(this.pFirts.getPnext());
            size--;
            return true;
        } else {
            return false;
        }
    }

    public void eliminarFinal() {
        if (!EsVacio()) {
            if (getSize() == 1) {
                destruir();
            } else {
                Nodo pointer = getpFirst();
                while (pointer.getPnext() != null && pointer.getPnext().getPnext() != null) {
                    pointer = pointer.getPnext();
                }
                pointer.setPnext(null);
            }
            size--;
        }
    }

    public void EliminarPorReferencia(Object referencia) {

        if (buscar(referencia)) {
            if (this.pFirts.getDato() == referencia) {
                this.eliminarInicio();
            } else {
                Nodo aux = this.pFirts;
                while (aux.getPnext().getDato() != referencia) {
                    aux = aux.getPnext();
                }
                Nodo siguiente = aux.getPnext().getPnext();
                aux.setPnext(siguiente);
            }
            size--;
        }
    }

    public void eliminarPorPosicion(int posicion) {

        if (posicion >= 0 && posicion < size) {
            if (posicion == 0) {
                this.pFirts = this.pFirts.getPnext();
            } else {
                Nodo aux = this.pFirts;
                for (int i = 0; i < posicion - 1; i++) {
                    aux = aux.getPnext();
                }
                Nodo siguiente = aux.getPnext();
                aux.setPnext(siguiente.getPnext());
            }
            size--;
        }
    }

    //Metodo para obtener el valor de un nodo en una determinada posición
    public Object getValor(int posicion) {

        if (posicion >= 0 && posicion < size) {

            if (posicion == 0) {
                return this.pFirts.getDato();
            } else {
                Nodo aux = this.pFirts;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getPnext();
                }
                return aux.getDato();
            }
        }
        return null;
    }


    // Funcion para buscar un elemento en la lista
    public boolean buscar(Object referencia) {
        Nodo aux = this.pFirts;
        boolean encontrado = false;
        while (aux != null && encontrado != true) {
            if (referencia == aux.getDato()) {
                encontrado = true;
            } else {
                aux = aux.getPnext();
            }
        }
        return encontrado;
    }
    
    public int buscarYDevolverIndice(String nombreVertice) {
        if (!this.EsVacio()) {
            if (this.size == 1) {
                Vertice vertice1 = (Vertice) this.pFirts.getDato();
                if(vertice1.getNombre().equalsIgnoreCase(nombreVertice)){
                    return 0;
                }
                return -1;
            } else {
                Nodo aux = this.pFirts;
                int count = 0;
                while (aux != null) {
                    Vertice vertice1 = (Vertice) aux.getDato();
                    if ( vertice1.getNombre().equalsIgnoreCase(nombreVertice)) {
                        return count;
                    }
                    count++;
                    aux = aux.getPnext();
                }
                return -1;
            }
        }
        return -1;
    }

    //Destructor
    public void destruir() {
        this.pFirts = null;
        size = 0;
    }
            
}
