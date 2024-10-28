/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import EDD.Grafo;
import EDD.Lista;
import EDD.Vertice;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.io.IOException;


public class CargarArchivo {
    private Grafo grafo;

    public CargarArchivo(Grafo grafo) {
        this.grafo = grafo;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

    public void cargarArchivoJSON(String rutaArchivo) {
        try {
            Gson gson = new Gson();
            JsonObject redTransporteData = gson.fromJson(new FileReader(rutaArchivo), JsonObject.class);

           
            Lista nombresRedes = obtenerClavesDeJsonObject(redTransporteData);

           
            for (int i = 0; i < nombresRedes.getSize(); i++) {
                String nombreRed = (String) nombresRedes.getValor(i);
                JsonElement redElement = redTransporteData.get(nombreRed);

                
                if (redElement.isJsonObject()) {
                    JsonObject lineasObject = redElement.getAsJsonObject();
                    procesarLineasRed(lineasObject);
                } else if (redElement.isJsonArray()) {
                    JsonArray lineasArray = redElement.getAsJsonArray();
                    for (JsonElement elementoLinea : lineasArray) {
                        if (elementoLinea.isJsonObject()) {
                            JsonObject lineaObject = elementoLinea.getAsJsonObject();
                            procesarLineasRed(lineaObject);  // Procesar cada objeto de línea
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Lista obtenerClavesDeJsonObject(JsonObject jsonObject) {
        Lista listaClaves = new Lista();
        for (String key : jsonObject.keySet()) {
            listaClaves.insertarFinal(key);
        }
        return listaClaves;
    }

    
    private void procesarLineasRed(JsonObject lineasObject) {
       
        Lista nombresLineas = obtenerClavesDeJsonObject(lineasObject);

        for (int i = 0; i < nombresLineas.getSize(); i++) {
            String nombreLinea = (String) nombresLineas.getValor(i);
            JsonArray estacionesArray = lineasObject.getAsJsonArray(nombreLinea);

            Vertice verticeAnterior = null;
            Vertice verticeActual;

            
            for (JsonElement estacionElement : estacionesArray) {
                if (estacionElement.isJsonPrimitive()) {

                    String nombreEstacion = estacionElement.getAsString();
                    verticeActual = obtenerOcrearVertice(nombreEstacion);

                    if (verticeAnterior != null) {
                        verticeAnterior.getListaAd().insertarFinal(verticeActual);
                        verticeActual.getListaAd().insertarFinal(verticeAnterior);
                    }

                    verticeAnterior = verticeActual;

                } else if (estacionElement.isJsonObject()) {
                    
                    JsonObject conexionPeatonal = estacionElement.getAsJsonObject();
                    Lista clavesPeatonales = obtenerClavesDeJsonObject(conexionPeatonal);

                    for (int j = 0; j < clavesPeatonales.getSize(); j++) {
                        String estacion1 = (String) clavesPeatonales.getValor(j);
                        String estacion2 = conexionPeatonal.get(estacion1).getAsString();
                        verticeAnterior = this.agregarPasoPeatonal(estacion1, estacion2, verticeAnterior);
                    }
                }
            }
        }
    }

    private Vertice agregarPasoPeatonal(String estacion1, String estacion2, Vertice estacionAnterior) {
        Vertice v1 = obtenerOcrearVertice(estacion1);
        Vertice v2 = obtenerOcrearVertice(estacion2);

        v1.setPeaton(v2);
        v2.setPeaton(v1);

        
        if (estacionAnterior != null) {
            estacionAnterior.getListaAd().insertarFinal(v1);
            v1.getListaAd().insertarFinal(estacionAnterior);
        }
        estacionAnterior = v1;
        return estacionAnterior;
    }

    private Vertice obtenerOcrearVertice(String nombreEstacion) {

        for (int i = 0; i < grafo.getVertices().getSize(); i++) {
            Vertice verticeActual = (Vertice) grafo.getVertices().getValor(i);
            if (verticeActual.getNombre().equalsIgnoreCase(nombreEstacion)) {
                return verticeActual;
            }
        }
        Vertice verticeNuevo = new Vertice(nombreEstacion);
        grafo.insertarVertice(verticeNuevo);
        return verticeNuevo;
    }
}
